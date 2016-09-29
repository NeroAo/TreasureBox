package neroao.treasurebox.linescounter.counterImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import neroao.treasurebox.linescounter.CounterFactory;
import neroao.treasurebox.linescounter.ILineCounter;

public class LinesCounter {
	//test
	private String projectPath;
	private Map<String,List<File>> fileMap;
	
	public LinesCounter(String projectPath, String countCondition){
		this.projectPath = projectPath;
		fileMap = new HashMap<String,List<File>>();
		String[] fileTypes = countCondition.split(",");
		for(String fileType : fileTypes){
			fileMap.put(fileType, new ArrayList<File>());
		}
	}
	
	public void countLines(){
		long begin = System.currentTimeMillis();
		int sum = 0;
		File project = new File(projectPath);
		File[] files = project.listFiles();
		for(File file : files){
			traversalFiles(file);
		}
		Set<String> fileTypes = fileMap.keySet();
		for(String type : fileTypes){
			List<File> fileList = fileMap.get(type);
			if(fileList.size()>0){
				ILineCounter counter = CounterFactory.getCounter(type);
				counter.count(fileList);
				System.out.println("********"+type+"文件********");
				System.out.println("文件数："+fileList.size());
				counter.printResult();
				System.out.println("");
				sum += fileList.size();
			}else{
				System.out.println("********项目中无"+type+"文件********");
				System.out.println("");
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("共统计文件数："+sum+",用时："+((end-begin)/1000.0)+"s");
	}
	
	public void traversalFiles(File file){
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File subfile : files){
				traversalFiles(subfile);
			}
		}else if(file.isFile()){
			String fileName = file.getName();
			String fileSuffix = fileName.substring(fileName.lastIndexOf(".")+1);
			List<File> fileList = fileMap.get(fileSuffix);
			if(fileList != null){
				fileList.add(file);
				fileMap.put(fileSuffix, fileList);
			}
		}
	}
	
}

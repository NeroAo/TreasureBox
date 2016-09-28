package neroao.treasurebox.linescounter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		File project = new File(projectPath);
		File[] files = project.listFiles();
		for(File file : files){
			traversalFiles(file);
		}
		Set<String> fileTypes = fileMap.keySet();
		for(String type : fileTypes){
			List<File> fileList = fileMap.get(type);
			ILineCounter counter = CounterFactory.getCounter(type);
			counter.count(fileList);
			System.out.println("********"+type+"文件********");
			System.out.println("文件数："+fileList.size());
			counter.printResult();
			System.out.println("\n\n");
		}
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

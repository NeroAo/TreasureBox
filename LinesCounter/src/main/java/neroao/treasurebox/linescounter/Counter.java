package neroao.treasurebox.linescounter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Counter {
	
	private String filter;
	private String[] fileTypes;
	private List<CountInfo> countInfos;
	private Map<String,List<File>> fileMap;
	private String projectPath;
	
	public Counter(){
		
	}
	
	public Counter(String projectPath){
		this.projectPath = projectPath;
	}
	
	public Counter(String projectPath,String filter){
		this.projectPath = projectPath;
		this.filter = filter;
		parseFilter(filter);
	}
	
	private void parseFilter(String filter){
		fileTypes = filter.trim().split(",");
	}
	
	public List<CountInfo> linesCount(){
		countInfos = new ArrayList<CountInfo>();
		LineCounterForFile counter = new LineCounterForFile();
		File project = new File(projectPath);
		extractFiles(project);
		if(!fileMap.isEmpty()){
			Set<String> keySet = fileMap.keySet();
			for(String fileType : keySet){
				CountInfo countInfo = new CountInfo(fileType);
				List<File> files = fileMap.get(fileType);
				for(File file : files){
					counter.setFile(file);
					counter.count();
					countInfo.addAnnotationLiens(counter.getAnnotationLines());
					countInfo.addBlankLiens(counter.getBlankLines());
					countInfo.addCondeLiens(counter.getCodeLines());
				}
				countInfos.add(countInfo);
			}
		}
		return countInfos;
	}
	
	private void extractFiles(File project){
		fileMap = new HashMap<String,List<File>>();
		File[] files = project.listFiles();
		for(File file : files){
			if(file.isDirectory()){
				extractFiles(file);
			}else if(file.isFile()){
				for(String fileType : fileTypes){
					if(file.getName().endsWith(fileType)){
						List<File> list = fileMap.get(fileType);
						if(list == null){
							list = new ArrayList<File>();
							list.add(file);
						}else{
							list.add(file);
						}
						fileMap.put(fileType, list);
					}
				}
			}
		}
	}
}

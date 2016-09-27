package neroao.treasurebox.linescounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LineCounterForFile {
	
	private int annotationLines = 0;
	private int blankLines = 0;
	private int codeLines = 0;
	private File file;
	
	public LineCounterForFile(){
		
	}
	
	public void setFile(File file){
		this.file = file;
		cleanNumber();
	}
	
	private void cleanNumber(){
		this.annotationLines = 0;
		this.blankLines = 0;
		this.codeLines = 0;
	}
	
	public void count(){
		cleanNumber();
		try{
			FileReader fr = new FileReader(this.file);
			BufferedReader bf = new BufferedReader(fr);
			String str = "";
			boolean isNote = false;
			while((str = bf.readLine()) != null){
				str = str.trim();
				if(isBlankLine(str)){
					blankLines++;
				}else if(str.startsWith("//")){
					annotationLines++;
				}else if(str.startsWith("/*") && isNote == false){
					annotationLines++;
					isNote = true;
				}else if(str.startsWith("*/") && isNote == true){
					annotationLines++;
					isNote = false;
				}else if(isNote){
					annotationLines++;
				}else{
					codeLines++;
				}
			}
		}catch(Exception e){
			
		}
	}
	
	private boolean isBlankLine(String str){
		if(str.length() == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public int getAnnotationLines(){
		return this.annotationLines;
	}

	public int getBlankLines() {
		return blankLines;
	}

	public int getCodeLines() {
		return codeLines;
	}
	
	
}

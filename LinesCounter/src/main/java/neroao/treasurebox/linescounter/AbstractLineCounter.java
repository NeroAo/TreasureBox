package neroao.treasurebox.linescounter;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractLineCounter implements ILineCounter {
	
	protected int annotationCount = 0;
	protected int blankCount = 0;
	protected int codeCount = 0;

	public void count(List<File> files) {
		
	}
	

	public int getAnnotationCount() {
		return annotationCount;
	}

	public int getBlankCount() {
		return blankCount;
	}

	public int getCodeCount() {
		return codeCount;
	}
	
	public void addAnnotationCount(){
		annotationCount++;
	}
	
	public void addBlankCount(){
		blankCount++;
	}
	
	public void addCodeCount(){
		codeCount++;
	}
	
	public void countClean(){
		annotationCount = 0;
		blankCount = 0;
		codeCount = 0;
	}
	
	public void printResult(){
		System.out.println("注释行:"+annotationCount);
		System.out.println("空白行:"+blankCount);
		System.out.println("代码行:"+codeCount);
	}

}

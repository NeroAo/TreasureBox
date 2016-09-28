package neroao.treasurebox.linescounter;

import java.io.File;
import java.util.List;

public interface ILineCounter {
	
	public void count(List<File> files);
	
	public int getAnnotationCount();
	
	public int getBlankCount();
	
	public int getCodeCount();
	
	public void printResult();

}

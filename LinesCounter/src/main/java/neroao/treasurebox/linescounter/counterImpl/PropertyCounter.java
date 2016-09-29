package neroao.treasurebox.linescounter.counterImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import neroao.treasurebox.linescounter.AbstractLineCounter;
import neroao.treasurebox.linescounter.CommonUtils;

public class PropertyCounter extends AbstractLineCounter {
	FileReader fr;
	BufferedReader bf;
	
	public void count(List<File> files){
		countClean();
		for(File file : files){
			try{
				fr= new FileReader(file);
				bf = new BufferedReader(fr);
				String str = "";
				while((str = bf.readLine()) != null){
					str = str.trim();
					if(CommonUtils.isBlankLine(str)){
						addBlankCount();
					}else if(str.startsWith("#")){
						addAnnotationCount();
					}else{
						addCodeCount();
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(fr != null){
					try {
						fr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(bf != null){
					try {
						bf.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}

package neroao.treasurebox.linescounter;

public class CounterFactory {
	
	private static String JAVA_FILE = "java";
	private static String JS_FILE = "js";
	
	public static ILineCounter getCounter(String fileType){
		if(JAVA_FILE.equals(fileType)){
			return new JavaJsCounter();
		}else if(JS_FILE.equals(fileType)){
			return new JavaJsCounter();
		}
		return null;
	}

}

package neroao.treasurebox.linescounter;

import neroao.treasurebox.linescounter.counterImpl.HtmlXmlCounter;
import neroao.treasurebox.linescounter.counterImpl.JavaJsCounter;
import neroao.treasurebox.linescounter.counterImpl.PropertyCounter;

public class CounterFactory {
	
	private static String JAVA_FILE = "java";
	private static String JS_FILE = "js";
	private static String JSP_FILE = "jsp";
	private static String HTML_FILE = "html";
	private static String XML_FILE = "xml";
	private static String PROPERTY_FILE = "properties";
	
	public static ILineCounter getCounter(String fileType){
		if(JAVA_FILE.equals(fileType)||JS_FILE.equals(fileType)||
				JSP_FILE.equals(fileType)){
			return new JavaJsCounter();
		}else if(HTML_FILE.equals(fileType)||XML_FILE.equals(fileType)){
			return new HtmlXmlCounter();
		}else if(PROPERTY_FILE.endsWith(fileType)){
			return new PropertyCounter();
		}
		return null;
	}

}

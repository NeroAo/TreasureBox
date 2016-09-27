package neroao.treasurebox.linescounter;

public class CountInfo {
	private String type;
	private int annotationLines = 0;
	private int blankLines = 0;
	private int codeLines = 0;
	
	public CountInfo(){
		
	}
	
	public CountInfo(String type){
		this.type = type;
	}
	
	public CountInfo(String type,int annotationLines,int blankLines,
			int codeLines){
		this.type = type;
		this.annotationLines = annotationLines;
		this.blankLines = blankLines;
		this.codeLines = codeLines;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAnnotationLines() {
		return annotationLines;
	}

	public void setAnnotationLines(int annotationLines) {
		this.annotationLines = annotationLines;
	}

	public int getBlankLines() {
		return blankLines;
	}

	public void setBlankLines(int blankLines) {
		this.blankLines = blankLines;
	}

	public int getCodeLines() {
		return codeLines;
	}

	public void setCodeLines(int codeLines) {
		this.codeLines = codeLines;
	}
	
	public void addAnnotationLiens(int count){
		this.annotationLines+=count;
	}
	public void addBlankLiens(int count){
		this.blankLines+=count;
	}
	public void addCondeLiens(int count){
		this.codeLines+=count;
	}
	
	
}

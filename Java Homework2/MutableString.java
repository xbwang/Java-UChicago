import java.lang.String;

class MutableString{
	private String string;
	
	MutableString(){
		this.string = "";
	}
	MutableString(String s_in){
		this.string = s_in;
	}
	//set value
	public void setValue(String s_in){
		this.string = s_in;
	}
	//get value
	public String getValue(){
		return this.string;
	}
	//charAt
	public char charAt(int index){
		return this.string.charAt(index);
	}
	//concat
	public MutableString concat(MutableString s_in){
		String tmpS;
		tmpS = this.string.concat(s_in.string);
		this.setValue(tmpS);
		return this;
	}
	//isEmpty
	public boolean isEmpty(){
		return this.string.isEmpty();
	}
	//equals
	public boolean equals(Object anObject_in){
		return this.string.equals(anObject_in);
	}
	//replace
	public MutableString replace(char oldChar_in, char newChar_in){
		String tmpS;
		tmpS = this.string.replace(oldChar_in, newChar_in);
		this.setValue(tmpS);
		return this;
	}
}
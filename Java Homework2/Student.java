class Student{
	private String stuName;
	private int studentID;
	private double gpa;
	private String major;
	
	//constructors
	Student(){
		stuName = null;
		studentID = 0;
		gpa = 0.0;
		major = null;
	}
	Student(String stuName_in, int studentID_in){
		this.stuName = stuName_in;
		this.studentID = studentID_in;
	}
	Student(String stuName_in, int studentID_in, String major_in){
		this.stuName = stuName_in;
		this.studentID = studentID_in;
		this.major = major_in;
	}
	
	//methods
	public void setMajor(String major_in){
		this.major = major_in;
	}
	public void setGPA(double gpa_in){
		this.gpa = gpa_in;
	}
	public String getName(){
		return this.stuName;
	}
	public int getSID(){
		return this.studentID;
	}
	public String getMajor(){
		return this.major;
	}
	public double getGPA(){
		return this.gpa;
	}
}
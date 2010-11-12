import java.util.Arrays;
import java.util.Comparator; 

class SortStudent{
	public static void main(String[] args){
		int stuNum = args.length;
		if(stuNum <= 0){
			System.out.println("- error: too few/many input value");
			System.exit(0);
		}
		Student[] studentArray = new Student[stuNum];
		//orignial array
		System.out.println("Original Array:\t");
		for(int i = 0; i < stuNum; i++){
			double gpa = Double.parseDouble(args[i]);
			studentArray[i] = new Student(Character.toString((char)('A'+i)), 201000+i, "Computer Science");
			studentArray[i].setGPA(gpa);
			System.out.print( "("+(i+1)+")" + "Name:" + studentArray[i].getName()+" GPA:" +studentArray[i].getGPA()+"|");
		}
		System.out.print("\n");
		//normal sort
		System.out.println("Normal Sort:\t");
		Arrays.sort(studentArray, new ByGPANormal());
		for(int i = 0; i < stuNum; i++){
			System.out.print( "("+(i+1)+")" + "Name:" + studentArray[i].getName()+" GPA:" +studentArray[i].getGPA()+"|");
		}
		System.out.print("\n");
		//random sort
		System.out.println("Random Sort:\t");
		Arrays.sort(studentArray, new ByGPARandom());
		for(int i = 0; i < stuNum; i++){
			System.out.print( "("+(i+1)+")" + "Name:" + studentArray[i].getName()+" GPA:" +studentArray[i].getGPA()+"|");
		}
		System.out.print("\n");
	}
}
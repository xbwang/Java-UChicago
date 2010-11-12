import java.util.Comparator;
import java.lang.Comparable;
import java.util.Random;

class SimpleSort{
	public static void BubbleSort(int[] inArray){
		for(int i = 0; i < inArray.length; i++){
			for(int j = (inArray.length-1); j > i; j--){
				if(inArray[j] < inArray[j-1]){
					int temp = inArray[j];
					inArray[j] = inArray[j-1];
					inArray[j-1] = temp;
				}
			}
		}
	}
	public static void BubbleSort(float[] inArray){
		for(int i = 0; i < inArray.length; i++){
			for(int j = (inArray.length-1); j > i; j--){
				if(inArray[j] < inArray[j-1]){
					float temp = inArray[j];
					inArray[j] = inArray[j-1];
					inArray[j-1] = temp;
				}
			}
		}
	}
	public static void BubbleSort(double[] inArray){
		for(int i = 0; i < inArray.length; i++){
			for(int j = (inArray.length-1); j > i; j--){
				if(inArray[j] < inArray[j-1]){
					double temp = inArray[j];
					inArray[j] = inArray[j-1];
					inArray[j-1] = temp;
				}
			}
		}
	}
	public static void BubbleSort(long[] inArray){
		for(int i = 0; i < inArray.length; i++){
			for(int j = (inArray.length-1); j > i; j--){
				if(inArray[j] < inArray[j-1]){
					long temp = inArray[j];
					inArray[j] = inArray[j-1];
					inArray[j-1] = temp;
				}
			}
		}
	}

	public static void BubbleSort(Object[] inArray){
		for(int i = 0; i < inArray.length; i++){
			for(int j = (inArray.length-1); j > i; j--){
				if(((Comparable)inArray[j]).compareTo(inArray[j-1]) < 0){
					Object temp = inArray[j];
					inArray[j] = inArray[j-1];
					inArray[j-1] = temp;
				}
			}
		}
	}
	
	public static void BubbleSort(Object[] inArray, Comparator c){
		for(int i = 0; i < inArray.length; i++){
			for(int j = (inArray.length-1); j > i; j--){
				if(c.compare(inArray[j], inArray[j-1]) < 0){
					Object temp = inArray[j];
					inArray[j] = inArray[j-1];
					inArray[j-1] = temp;
				}
			}
		}
	}
	
	public static <T extends Comparable<? super T>> void BubbleSortGeneric(T[] inArray){
		for(int i = 0; i < inArray.length; i++){
			for(int j = (inArray.length-1); j > i; j--){
				if(inArray[j].compareTo(inArray[j-1]) < 0){
					T temp = inArray[j];
					inArray[j] = inArray[j-1];
					inArray[j-1] = temp;
				}
			}
		}
	}
	
	public static <T> void BubbleSortGeneric(T[] inArray, Comparator<? super T> c){
		for(int i = 0; i < inArray.length; i++){
			for(int j = (inArray.length-1); j > i; j--){
				if(c.compare(inArray[j], inArray[j-1]) < 0){
					T temp = inArray[j];
					inArray[j] = inArray[j-1];
					inArray[j-1] = temp;
				}
			}
		}
	}
	
	//testing
	public static void main(String[] args){
		//test int
		int[] testArray = new int[5];
		Random ranGenerator = new Random();
		for(int i = 0; i < 5; i ++){
			testArray[i] = ranGenerator.nextInt(10);
			System.out.print(testArray[i]+" ");
		}
		System.out.print("\n");
		BubbleSort(testArray);
		for(int i = 0; i < 5; i ++){
			System.out.print(testArray[i]+" ");
		}
		System.out.print("\n");
		//test Student
		int stuNum = 5;
		Student[] studentArray = new Student[stuNum];
		System.out.println("Original Array:\t");
		for(int i = 0; i < stuNum; i++){
			studentArray[i] = new Student(Character.toString((char)('A'+i)), 201000+i, "Computer Science");
			studentArray[i].setGPA(ranGenerator.nextInt(100)/25.00);
			System.out.print( "("+(i+1)+")" + "Name:" + studentArray[i].getName()+" GPA:" +studentArray[i].getGPA()+"|");
		}
		System.out.print("\n");
		System.out.println("Normal Sort:\t");
		BubbleSortGeneric(studentArray, new ByGPANormal());
		for(int i = 0; i < stuNum; i++){
			System.out.print( "("+(i+1)+")" + "Name:" + studentArray[i].getName()+" GPA:" +studentArray[i].getGPA()+"|");
		}
		System.out.print("\n");
	}

}
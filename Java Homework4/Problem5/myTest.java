import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Hashtable;
import java.util.Arrays;
import java.util.Collections;

class myTest{
	public static void main(String[] args){
		/***initialization***/
		int totalNum = 500000;
		Integer[] ranInt = new Integer[totalNum];
		for(int i = 0; i < totalNum; i++){
			ranInt[i] = new Integer(i);
		}
		Collections.shuffle(Arrays.asList(ranInt));
		/***insertion testing***/
		//ArrayList time
		ArrayList<Integer> testArrayList = new ArrayList<Integer>();
		long start = System.currentTimeMillis();
		for(int i = 0; i < totalNum; i++){
			testArrayList.add(ranInt[i]);
		}
		long end = System.currentTimeMillis();
		long elapsedTime = end - start;
		System.out.println("- Time spent for insertion by ArrayList is: "+elapsedTime);
		//LinkedList time
		LinkedList<Integer> testLinkedList = new LinkedList<Integer>();
		start = System.currentTimeMillis();
		for(int i = 0; i < totalNum; i++){
			testLinkedList.add(ranInt[i]);
		}
		end = System.currentTimeMillis();
		elapsedTime = end - start;
		System.out.println("- Time spent for insertion by LinkedList is: "+elapsedTime);
		//HashSet time
		Hashtable<Integer, Integer> testHashSet = new Hashtable<Integer, Integer>();
		start = System.currentTimeMillis();
		for(int i = 0; i < totalNum; i++){
			testHashSet.put(ranInt[i], i);
		}
		end = System.currentTimeMillis();
		elapsedTime = end - start;
		System.out.println("- Time spent for insertion by HashSet is: "+elapsedTime);
		
		/***retrieval testing***/
		//Collections.shuffle(Arrays.asList(ranInt));
		//Integer obj = new Integer(500000);
		//ArrayList time
		start = System.currentTimeMillis();
		//for(int i = 0; i < 100; i++){
			testArrayList.contains(1);
		//}
		end = System.currentTimeMillis();
		elapsedTime = end - start;
		System.out.println("- Time spent for retrieval by ArrayList is: "+elapsedTime);
		//LinkedList time
		start = System.currentTimeMillis();
		//for(int i = 0; i < 100; i++){
			testLinkedList.contains(1);
		//}
		end = System.currentTimeMillis();
		elapsedTime = end - start;
		System.out.println("- Time spent for retrieval by LinkedList is: "+elapsedTime);
		//Hashtable time
		start = System.currentTimeMillis();
		//for(int i = 0; i < 100; i++){
			testHashSet.contains(1);
		//}
		end = System.currentTimeMillis();
		elapsedTime = end - start;
		System.out.println("- Time spent for retrieval by HashSet is: "+elapsedTime);
	}
}
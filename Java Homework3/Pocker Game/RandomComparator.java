import java.util.Comparator;
import java.util.Random;

class RandomComparator implements Comparator<Object>{
	public final int compare(Object a, Object b){
		Random ranGenerator = new Random();
		int aData = ranGenerator.nextInt();
		int bData = ranGenerator.nextInt();
		if(aData > bData){
			return 1;
		}
		else if(aData < bData){
			return -1;
		}
		else{
			return 0;	
		}
	}
}
import java.util.Comparator;

class ReverseComparator implements Comparator<Object>{
	public final int compare(Object a, Object b){
		Card aCard = (Card)a;
		Card bCard = (Card)b;
		if(aCard.getNumber() > bCard.getNumber()){
			return -1;
		}
		else if(aCard.getNumber() == bCard.getNumber()){
			return 0;
		}
		else{
			return 1;
		}
	}
}
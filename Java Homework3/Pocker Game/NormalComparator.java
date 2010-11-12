import java.util.Comparator;

class NormalComparator implements Comparator<Object>{
	public final int compare(Object a, Object b){
		Card aCard = (Card)a;
		Card bCard = (Card)b;
		if(aCard.getNumber() > bCard.getNumber()){
			return 1;
		}
		else if(aCard.getNumber() == bCard.getNumber()){
			if(aCard.getSuit() > bCard.getSuit()){
				return 1;
			}
			else if(aCard.getSuit() < bCard.getSuit()){
				return -1;
			}
			else{
				return 0;
			}
		}
		else{
			return -1;
		}
	}
}
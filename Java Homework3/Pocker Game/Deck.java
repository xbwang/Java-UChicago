import java.util.Arrays;

class Deck extends Object{
	private Card[] newCards = new Card[52];
	//initialize a deck
	Deck(){
		for(int i = 0; i < 52; i++){
			if(0 <= i && i < 13)
				newCards[i] = new Card(Card.DIAMOND, i+1);
			if(13 <= i && i < 26)
				newCards[i] = new Card(Card.HEART, i+1-13);
			if(26 <= i && i < 39)
				newCards[i] = new Card(Card.SPADE, i+1-26);
			if(39 <= i && i < 52)
				newCards[i] = new Card(Card.CLUB, i+1-39);
		}
	}
	//sort
	public void sort(){
		Arrays.sort(newCards, new NormalComparator());
	}
	//shuffle
	public void shuffle(){
		Arrays.sort(newCards, new RandomComparator());
	}
	//deal
	public void deal(Player p, int n){
		Card[] pCards = new Card[n];
		int j = 0;
		for(int i = newCards.length-1; i > newCards.length-1-n; i--){
			//try{
				pCards[j] = newCards[i];
				//System.out.println("$$$$$$$$$$$$$"+newCards[i].toString());
			/*}catch(CloneNotSupportedException e){
				System.out.println(e);
				System.exit(0);
			}*/
			j++;
		}
		p.updateCard(pCards, n);
		updateDeck(n);
	}
	
	private void updateDeck(int n){
		Card[] temp = new Card[newCards.length - n];
		for(int i = 0; i < newCards.length - n; i++){
			//try{
				temp[i] = newCards[i];
			/*}catch(CloneNotSupportedException e){
				System.out.println(e);
				System.exit(0);
			}*/
		}
		newCards = temp;
	}

	public String toString(){
		String temp = null;
		temp = newCards[0].toString();
		for(int i = 1; i < newCards.length; i++){
			temp = temp.concat(","+newCards[i].toString());
		}
		return temp;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	public boolean equals(Deck d){
		return this.toString().equals(d.toString());
	}

}
//card done
class Card extends Object{
	private int suit, number;
	static final int DIAMOND = 4, HEART = 3, SPADE = 2, CLUB = 1;
	static final int K = 13, Q = 12, J = 11, A = 1;
	Card(int suit, int number){
		this.suit = suit;
		this.number = number;
	}
	public int getSuit(){
		return this.suit;
	}
	public int getNumber(){
		return this.number;
	}
	public String toString(){
		String temp = null;
		if(this.suit == DIAMOND){
			temp = "["+"DIAMOND";
		}
		if(this.suit == HEART){
			temp = "["+"HEART";
		}
		if(this.suit == SPADE){
			temp = "["+"SPADE";
		}
		if(this.suit == CLUB){
			temp = "["+"CLUB";
		}
		if(number == 11){
			temp = temp.concat("."+"J]");
		}
		else if(number == 12){
			temp = temp.concat(".Q]");
		}
		else if(number == 13){
			temp = temp.concat(".K]");
		}
		else if(number == 1){
			temp = temp.concat(".A]");
		}
		else{
			temp = temp.concat("."+Integer.toString(number)+"]");
		}
		return temp;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	public boolean equals(Card c){
		if(this.getSuit() == c.getSuit() && this.getNumber() == c.getNumber())
			return true;
		else
			return false;
	}
}
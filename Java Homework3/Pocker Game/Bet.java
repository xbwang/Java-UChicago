class Bet{
	private int currentBet;
	
	Bet(){
		setValue(0);
	}
	
	private void setValue(int betIn){
		currentBet = betIn;
	}
	
	public void addBet(int betIn){
		currentBet = currentBet + betIn;
	}
	
	public int getValue(){
		return currentBet;
	}
	
}
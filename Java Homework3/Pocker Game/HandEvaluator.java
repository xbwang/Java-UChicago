class HandEvaluator{
	static final int HighCards = 1, OnePair = 2, TwoPair = 3,
		ThreeOfaKind = 4, Straight = 5, Flush = 6, FullHouse = 7,
		FourOfaKind = 8, StraightFlush = 9;
	
	public static int getValue(Player p){
		int value = 0;
		Card[] cards = p.getCard();
		int n1, n2, n3, n4, n5;
		int s1, s2, s3, s4, s5;
		n1 = cards[0].getNumber();
		n2 = cards[1].getNumber();
		n3 = cards[2].getNumber();
		n4 = cards[3].getNumber();
		n5 = cards[4].getNumber();
		s1 = cards[0].getSuit();
		s2 = cards[1].getSuit();
		s3 = cards[2].getSuit();
		s4 = cards[3].getSuit();
		s5 = cards[4].getSuit();
		if(n1==n2+1 && n2==n3+1 && n3==n4+1 && n4==n5+1){
			if(s1==s2 && s2==s3 && s3==s4 && s4==s5){
				value = StraightFlush;
				//System.out.println("!!!!!!!!!!!!!!");
			}
			else{
				value = Straight;
			}
		}
		else if(n1==n2 && n2==n3 && n3==n4){
			value = FourOfaKind;
		}
		else if(n1==n2 && n2==n3){
			if(n4==n5){
				value = FullHouse;
			}
			else{
				value = ThreeOfaKind;
			}
		}
		else if(s1==s2 && s2==s3 && s3==s4 && s4==s5){
			if(n1==n2+1 && n2==n3+1 && n3==n4+1 && n4==n5+1){
				value = StraightFlush;
			}
			else{
				value = Flush;
			}
		}
		else if(n1==n2){
			if(n3==n4){
				value = TwoPair;
			}
			else{
				value = OnePair;
			}
		}
		else{
			value = HighCards;
		}
		return value;
	}
}
Problem 1
	File: Histogram.java
	Usage: java Histogram <number of samples> <number of bins>
	Exit: exit
	Example: java Histogram 1000 10
	
Problem 2
	File: Card.java, Deck.java, Bet.java, Player.java, HandEvaluator.java, Game.java
			NormalComparator.java, RandomComparator.java, ReverseComparator.java
	Usage: java Game <number of player> //the number of player cannot exceed 6
	Output: 2 rounds stats and the final results
	Example: java Game 3
	
	description:
	class Bet
		Bet();
		private void setValue(int betIn);
		public void addBet(int betIn);
		public int getValue();
	
	class Card
		Card();
		public int getSuit();
		public int getNumber();
		public String toString();
		public Object clone();
		public boolean equals(Card c);
		
	class Deck
		Deck();
		private void updateDeck(int n);
		public void sort();
		public void shuffle();
		public void deal(Player p, int n);
		public String toString();
		public Object clone();
		public boolean equals(Deck d);
	
	class HandEvaluator
		public static int getValue(Player p);
		
	class Player
		Player();
		private void setName(String nameIn);
		private void setScore(int scoreIn);
		private Card[] cardSort(Card[] cardsIn);
		public String getName();
		public int getScore();
		public void updateScore(int changeIn);
		public Card[] getCard();
		public void updateCard(Card[] cardIn, int n);
		public void placeBet(int betIn);
		
	I defined 	HighCards = 1, OnePair = 2, TwoPair = 3,
				ThreeOfaKind = 4, Straight = 5, Flush = 6, FullHouse = 7,
				FourOfaKind = 8, StraightFlush = 9
	For every round, each player will bet the value which equals to the value of the cards' in their hands
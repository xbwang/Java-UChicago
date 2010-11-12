class Game{
	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("- error: too many/few input value");
			System.exit(0);
		}
		if(!args[0].matches("\\d+")){
			System.out.println("- error: invalid input value");
			System.exit(0);
		}
		
		//initialize game
		int numOfPlayer = Integer.parseInt(args[0]);
		if(numOfPlayer > 6){
			System.out.println("- error: number of players cannot exceed 6");
			System.exit(0);
		}
		System.out.println("[Game Start]");
		Bet betPool = new Bet();
		Deck gameDeck = new Deck();
		System.out.println("[SHUFFLE CARDS]");
		gameDeck.shuffle();
		//System.out.println(gameDeck.toString());
		System.out.println("[DEAL CARDS]");
		Player[] playerAry = new Player[numOfPlayer];
		for(int i = 0; i < numOfPlayer; i++){
			playerAry[i] = new Player("Player" + Integer.toString(i+1));
		}
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < numOfPlayer; j++){
				gameDeck.deal(playerAry[j], 1);
			}
		}
		System.out.println("[1ST ROUND]");
		for(int i = 0; i < numOfPlayer;i++){
			Card[] c = playerAry[i].getCard();
			System.out.print("Player["+(i+1)+"]: ");
			for(int j = 0; j < c.length; j++)
				System.out.print(c[j].toString()+" ");
			System.out.print("\n");
		}
		//place bet
		System.out.println("[1ST BET]");
		for(int i = 0; i < numOfPlayer;i++){
			playerAry[i].placeBet(HandEvaluator.getValue(playerAry[i]));
			System.out.println("Player["+(i+1)+"]: "+ HandEvaluator.getValue(playerAry[i]));
			betPool.addBet(HandEvaluator.getValue(playerAry[i]));
		}
		System.out.println("BetPool Current Value: "+ betPool.getValue());
		//draw cards
		System.out.println("[DRAW CARDS]");
		for(int i = 0; i < numOfPlayer;i++){
			if(HandEvaluator.getValue(playerAry[i]) == HandEvaluator.ThreeOfaKind){
				gameDeck.deal(playerAry[i], 2);
				System.out.println("Player["+(i+1)+"] asked for 2 cards");
			}
			if(HandEvaluator.getValue(playerAry[i]) == HandEvaluator.TwoPair){
				gameDeck.deal(playerAry[i], 1);
				System.out.println("Player["+(i+1)+"] asked for 1 cards");
			}
			if(HandEvaluator.getValue(playerAry[i]) == HandEvaluator.OnePair){
				gameDeck.deal(playerAry[i], 3);
				System.out.println("Player["+(i+1)+"] asked for 3 cards");
			}
			if(HandEvaluator.getValue(playerAry[i]) == HandEvaluator.HighCards){
				gameDeck.deal(playerAry[i], 3);
				System.out.println("Player["+(i+1)+"] asked for 3 cards");
			}
		}
		System.out.println("[2ND ROUND]");
		for(int i = 0; i < numOfPlayer;i++){
			Card[] c = playerAry[i].getCard();
			System.out.print("Player["+(i+1)+"]: ");
			for(int j = 0; j < c.length; j++)
				System.out.print(c[j].toString()+" ");
			System.out.print("\n");
		}
		System.out.println("[2ND BET]");
		for(int i = 0; i < numOfPlayer;i++){
			playerAry[i].placeBet(HandEvaluator.getValue(playerAry[i]));
			System.out.println("Player["+(i+1)+"]: "+ HandEvaluator.getValue(playerAry[i]));
			betPool.addBet(HandEvaluator.getValue(playerAry[i]));
		}
		System.out.println("BetPool Current Value: "+ betPool.getValue());
		System.out.println("[RESULT]");
		int max = -1;
		for(int i = 0; i < numOfPlayer;i++){
			if(HandEvaluator.getValue(playerAry[i]) > max){
				max = HandEvaluator.getValue(playerAry[i]);
			}
		}
		int[] pWinners = new int[numOfPlayer];
		int count = 0;
		for(int i = 0; i < numOfPlayer;i++){
			if(HandEvaluator.getValue(playerAry[i]) == max){
				pWinners[count] = i;
				count++;
			}
		}
		Card[] tempCard;
		int subMax = -1;
		int subCount = 0;
		int[] winners = new int[numOfPlayer];
		if(count == 1){
			playerAry[pWinners[0]].updateScore(betPool.getValue());
		}else{
			if(max == HandEvaluator.StraightFlush || max == HandEvaluator.FourOfaKind
					|| max == HandEvaluator.FullHouse || max == HandEvaluator.Straight
					|| max == HandEvaluator.ThreeOfaKind){
				for(int i = 0; i < count; i++){
					tempCard = playerAry[pWinners[i]].getCard();
					if(tempCard[0].getNumber() > subMax)
						subMax = tempCard[0].getNumber();
				}
				for(int i = 0; i < count;i++){
					tempCard = playerAry[pWinners[i]].getCard();
					if(tempCard[0].getNumber() == subMax){
						winners[subCount] = pWinners[i];
						subCount++;
					}
				}
				int subBet = (int)(betPool.getValue()/subCount);
				for(int i = 0; i < subCount; i++){
					playerAry[winners[i]].updateScore(subBet);
				}
			}
			if(max == HandEvaluator.Flush || max == HandEvaluator.HighCards){
				//System.out.println(count + "|" + max);
				for(int i = 0; i < count; i++){
					tempCard = playerAry[pWinners[i]].getCard();
					if(tempCard[0].getNumber() > subMax)
						subMax = tempCard[0].getNumber();
				}
				for(int i = 0; i < count;i++){
					tempCard = playerAry[pWinners[i]].getCard();
					if(tempCard[0].getNumber() == subMax){
						winners[subCount] = pWinners[i];
						subCount++;
					}
				}
				int m = 1;
				while(m < 5 && subCount > 1){
					//System.out.println(subCount + "|" + subMax);
					count = subCount;
					subCount = 0;
					subMax = 0;
					pWinners = winners;
					for(int i = 0; i < count; i++){
						tempCard = playerAry[pWinners[i]].getCard();
						if(tempCard[m].getNumber() > subMax)
							subMax = tempCard[m].getNumber();
					}
					for(int i = 0; i < count;i++){
						tempCard = playerAry[pWinners[i]].getCard();
						if(tempCard[m].getNumber() == subMax){
							winners[subCount] = pWinners[i];
							subCount++;
						}
					}
					m++;
				}
				//System.out.println(subCount);
				int subBet = (int)(betPool.getValue()/subCount);
				for(int i = 0; i < subCount; i++){
					playerAry[winners[i]].updateScore(subBet);
				}
			}
			if(max == HandEvaluator.TwoPair){
				for(int i = 0; i < count; i++){
					tempCard = playerAry[pWinners[i]].getCard();
					if(tempCard[0].getNumber() > subMax)
						subMax = tempCard[0].getNumber();
				}
				for(int i = 0; i < count;i++){
					tempCard = playerAry[pWinners[i]].getCard();
					if(tempCard[0].getNumber() == subMax){
						winners[subCount] = pWinners[i];
						subCount++;
					}
				}
				int m = 2;
				while(m < 5 && subCount > 1){
					count = subCount;
					subCount = 0;
					subMax = 0;
					pWinners = winners;
					for(int i = 0; i < count; i++){
						tempCard = playerAry[pWinners[i]].getCard();
						if(tempCard[m].getNumber() > subMax)
							subMax = tempCard[m].getNumber();
					}
					for(int i = 0; i < count;i++){
						tempCard = playerAry[pWinners[i]].getCard();
						if(tempCard[m].getNumber() == subMax){
							winners[subCount] = pWinners[i];
							subCount++;
						}
					}
					m = m+2;
				}
				int subBet = (int)(betPool.getValue()/subCount);
				for(int i = 0; i < subCount; i++){
					playerAry[winners[i]].updateScore(subBet);
				}
			}
			if(max == HandEvaluator.OnePair){
				for(int i = 0; i < count; i++){
					tempCard = playerAry[pWinners[i]].getCard();
					if(tempCard[1].getNumber() > subMax)
						subMax = tempCard[0].getNumber();
				}
				for(int i = 0; i < count;i++){
					tempCard = playerAry[pWinners[i]].getCard();
					if(tempCard[1].getNumber() == subMax){
						winners[subCount] = pWinners[i];
						subCount++;
					}
				}
				int m = 2;
				while(m < 5 && subCount > 1){
					count = subCount;
					subCount = 0;
					subMax = 0;
					pWinners = winners;
					for(int i = 0; i < count; i++){
						tempCard = playerAry[pWinners[i]].getCard();
						if(tempCard[m].getNumber() > subMax)
							subMax = tempCard[m].getNumber();
					}
					for(int i = 0; i < count;i++){
						tempCard = playerAry[pWinners[i]].getCard();
						if(tempCard[m].getNumber() == subMax){
							winners[subCount] = pWinners[i];
							subCount++;
						}
					}
					m++;
				}
				int subBet = (int)(betPool.getValue()/subCount);
				for(int i = 0; i < subCount; i++){
					playerAry[winners[i]].updateScore(subBet);
				}
			}
		}
		for(int i = 0; i < numOfPlayer; i++){
			System.out.println("Player["+(i+1)+"] current score: "+ playerAry[i].getScore());
		}
	}
	/*test
	 public static void main(String[] args){
		Card n1 = new Card(4,2);
		Card n2 = new Card(4,3);
		Card n3 = new Card(4,4);
		Card n4 = new Card(4,5);
		Card n5 = new Card(4,6);
		Card[] test = new Card[5];
		test[4] = n1;
		test[3] = n2;
		test[2] = n3;
		test[1] = n4;
		test[0] = n5;
		Player p = new Player("test", test);
		System.out.println(HandEvaluator.getValue(p));
	}
	*/
}
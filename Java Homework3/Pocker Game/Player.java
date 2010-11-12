import java.util.Arrays;

class Player{
	private String name;
	private int score;
	private Card[] currentCards;
	
	Player(String nameIn){
		setScore(20);
		setName(nameIn);
		currentCards = null;
	}
	
	private void setName(String nameIn){
		name = nameIn;
	}
	
	private void setScore(int scoreIn){
		score = scoreIn;
	}
	
	public String getName(){
		return name;
	}
	
	public int getScore(){
		return score;
	}
	
	public void updateScore(int changeIn){
		score = score + changeIn;
	}
	
	public Card[] getCard(){
		if(currentCards.length == 5){
			 Arrays.sort(currentCards, new ReverseComparator());
			/*for(int i = 0; i < 5; i++)
				for(int l = 4; l >= i+1; l--){
					if(currentCards[l].getNumber() > currentCards[l-1].getNumber()){
						Card temp = currentCards[l];
						currentCards[l] = currentCards[l-1];
						currentCards[l-1] = temp;
					}
				}
				*/
			 currentCards = cardSort(currentCards);
			 return currentCards;
		}
		return currentCards;
	}
	
	public void updateCard(Card[] cardIn, int n){
		if(currentCards == null){
			currentCards = cardIn;
			if(currentCards.length == 5){
				Arrays.sort(currentCards, new ReverseComparator());
				currentCards = cardSort(currentCards);
			}
		}else if(currentCards.length < 5){
			Card[] temp = new Card[currentCards.length+n];
			int m,k;
			for(m = 0; m < currentCards.length; m++){
				temp[m] = currentCards[m];
			}
			for(k = 0; k < n; k++){
				temp[m] = cardIn[k];
				m++;
			}
			currentCards = temp;
			if(currentCards.length == 5){
				Arrays.sort(currentCards, new ReverseComparator());
				currentCards = cardSort(currentCards);
			}
		}
		else{
			int j = 0;
			for(int i = currentCards.length-1; i > currentCards.length-1-n; i--){
				currentCards[i] = cardIn[j];
				j++;
			}
			if(currentCards.length == 5){
				Arrays.sort(currentCards, new ReverseComparator());
				/*
				for(int i = 0; i < 5; i++)
					for(int l = 4; l >= i+1; l--){
						if(currentCards[l].getNumber() > currentCards[l-1].getNumber()){
							Card temp = currentCards[l];
							currentCards[l] = currentCards[l-1];
							currentCards[l-1] = temp;
						}
					}
					*/
				currentCards = cardSort(currentCards);
			}
			
		}
	}
	

	public void placeBet(int betIn){
		updateScore((-1)*betIn);
	}
	
	private Card[] cardSort(Card[] cardsIn){
		Card[] sortedCard = new Card[5];
		int count = 0;
		for(int i = 0; i < 4; i++){
			if(cardsIn[i].getNumber() == cardsIn[i+1].getNumber())
				count = count + 1;
		}
		int start = 0;
		if(count == 3){
			boolean FourofAKind = false;
			for(int i = 0; i < 4; i++){
				if(cardsIn[i].getNumber() == cardsIn[i+1].getNumber()){
					start = i;
					if(cardsIn[i+1].getNumber()==cardsIn[i+2].getNumber()&&cardsIn[i+2].getNumber()==cardsIn[i+3].getNumber())
						FourofAKind = true;
					break;
				}
			}
			if(FourofAKind == true){
				if(start == 0){
					//sortedCard = cardsIn;
					return cardsIn;
				}else{
					sortedCard[0] = cardsIn[1];
					sortedCard[1] = cardsIn[2];
					sortedCard[2] = cardsIn[3];
					sortedCard[3] = cardsIn[4];
					sortedCard[4] = cardsIn[0];
					return sortedCard;
				}
			}else{
				if(cardsIn[0].getNumber() == cardsIn[1].getNumber() && cardsIn[1].getNumber() == cardsIn[2].getNumber()){
					//sortedCard = cardsIn;
					return cardsIn;
				}else{
					sortedCard[0] = cardsIn[2];
					sortedCard[1] = cardsIn[3];
					sortedCard[2] = cardsIn[4];
					sortedCard[3] = cardsIn[0];
					sortedCard[4] = cardsIn[1];
					return sortedCard;
				}
			}
		}
		if(count == 1){
			for(int i = 0; i < 4; i++){
				if(cardsIn[i].getNumber() == cardsIn[i+1].getNumber()){
					start = i;
					break;
				}
			}
			if(start == 0){
				//sortedCard = cardsIn;
				return cardsIn;
			}else{
				sortedCard[0] = cardsIn[start];
				sortedCard[1] = cardsIn[start+1];
				int j = 0;
				for(int i = 2; i < 2+start; i++){
					sortedCard[i] = cardsIn[j];
					j++;
				}
				j = start + 2;
				for(int i = 2+start; i < 5; i++){
					sortedCard[i] = cardsIn[j];
					j++;
				}
				return sortedCard;
			}
		}
		if(count == 2){
			boolean threeAKind = false;
			for(int i = 0; i < 4; i++){
				if(cardsIn[i].getNumber() == cardsIn[i+1].getNumber()){
					start = i;
					if(i < 3 && cardsIn[i+1].getNumber() == cardsIn[i+2].getNumber()){
						threeAKind = true;
					}
				}
			}
			if(threeAKind == true){
				if(start == 0){
					//sortedCard = cardsIn;
					return cardsIn;
				}else{
					if(start == 1){
						sortedCard[0] = cardsIn[1];
						sortedCard[1] = cardsIn[2];
						sortedCard[2] = cardsIn[3];
						sortedCard[3] = cardsIn[0];
						sortedCard[4] = cardsIn[4];
						return sortedCard;
					}else{
						sortedCard[0] = cardsIn[2];
						sortedCard[1] = cardsIn[3];
						sortedCard[2] = cardsIn[4];	
						sortedCard[3] = cardsIn[0];
						sortedCard[4] = cardsIn[1];
						return sortedCard;
					}
				}
			}else{
				if(start == 0){
					if(cardsIn[1].getNumber() != cardsIn[2].getNumber() && cardsIn[2].getNumber() != cardsIn[3].getNumber()){
						sortedCard[0] = cardsIn[0];
						sortedCard[1] = cardsIn[1];
						sortedCard[2] = cardsIn[3];
						sortedCard[3] = cardsIn[4];
						sortedCard[4] = cardsIn[2];
						return sortedCard;
					}else{
						//sortedCard = cardsIn;
						return cardsIn;
					}
				}else{
					sortedCard[0] = cardsIn[1];
					sortedCard[1] = cardsIn[2];
					sortedCard[2] = cardsIn[3];
					sortedCard[3] = cardsIn[4];
					sortedCard[4] = cardsIn[0];
					return sortedCard;
				}
			}
		}
		else{
			//sortedCard = cardsIn;
			return cardsIn;
		}
		//return sortedCard;
	}
}
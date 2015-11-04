package gameProcessing;
import java.util.ArrayList;

public class GamePlay {
	private Players players;
	private Deck deck;
	private Card burnCard;
	private ArrayList<Card> burnPile;

	public GamePlay(int playerCount){
		deck = new Deck();
		burnPile = new ArrayList<Card>();
		players = new Players(playerCount);
		burnPile();
		dealFirstCard();
	}
//--------game play functions
	public void burnPile(){
		if (players.getPlayerCount() == 2){		//if two players, make a burn pile to show
			for (int i=0; i<3; i++){		//size of burn pile, 3
				burnPile.add(deck.deal());
			}
		}
		burnCard = deck.deal();		//mystery card, always hidden
	}
	public void dealFirstCard(){
		for (int i=0; i<players.getPlayerCount(); i++){
			players.getRoster(i).takeCard(deck.deal());	//deals everyone their first card
		}
	}
	public void dealSecondCard(){
		players.dealSecondCard(deck.deal());
	}
	public ArrayList<Card> getCurrentHand(){
		return getCurrentPlayer().getHand();
	}

	public void endOfTurn(){
		players.rotatePlayer();
	}

	//---------checks for end of round conditions
	public boolean checkToContinueRound(){	//checks for end of round
		if (checkForEnoughPlayers() && checkForEnoughCards()){
			return true;
		}
		else {
			players.setLastWinner();
			return false;
		}
	}
	public boolean checkForEnoughPlayers(){
		int playerCount = 0;
		for (int i=0; i<players.getPlayerCount(); i++){
			if (players.getRoster(i).getActive()){
				playerCount++;
			}
		}
		if (playerCount <= 1){
			return false;
		}
		else {
			return true;
		}
	}
	public boolean checkForEnoughCards(){
		return deck.checkDeck();
	}

//---------getters and setters

	public int getDeckSize(){
		return deck.deckSize();
	}
	public Player getCurrentPlayer(){
		return players.getCurrentPlayer();
	}
	public Player getRosterPlayer(int choice){
		return players.getRoster(choice);
	}
	public int getPlayerCount(){
		return players.getPlayerCount();
	}
	public Player getLastWinner(){
		return players.getRoster(players.getLastWinner());
	}

	public boolean getShield(int playerNumber){
	return players.getRoster(playerNumber).getShield();}
	public boolean getActive(int playerNumber){
	return players.getRoster(playerNumber).getActive();}

}

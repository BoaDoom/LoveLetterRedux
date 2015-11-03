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

	public void playCardAction(int playerTargetted){// a card played onto another player
		Card cardPlayed = getCurrentPlayer().getDiscardedCard();// card played against target
		Player targettedPlayer = players.getRoster(playerTargetted);	//target of card played
		CardActions.Action(cardPlayed.getValue(), players.getCurrentPlayer(), targettedPlayer, deck);

	}
//---------getters and setters
	public Player getCurrentPlayer(){
		return players.getCurrentPlayer();
	}
	public Player getRosterPlayer(int choice){
		return players.getRoster(choice);
	}
	public int getPlayerCount(){
		return players.getPlayerCount();
	}

	public boolean getShield(int playerNumber){
	return players.getRoster(playerNumber).getShield();}
	public boolean getActive(int playerNumber){
	return players.getRoster(playerNumber).getActive();}

}

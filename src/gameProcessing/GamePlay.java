package gameProcessing;
import java.util.ArrayList;

public class GamePlay {
	private Players players;
	private Deck deck;
	private ArrayList<Card> burnPile;

	public GamePlay(int playerCount){
		deck = new Deck();
		players = new Players(playerCount);
	}
//--------game play functions
	public void dealSecondCard(){
		players.dealSecondCard(deck.deal());
	}

//---------getters and setters
	public Player getCurrentPlayer(){
		return players.getCurrentPlayer();
	}
	public int getPlayerCount(){
		return players.getPlayerCount();
	}
}

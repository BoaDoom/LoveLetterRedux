package gameProcessing;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Players {
	private int playerCount;
	private int lastWinner;
	private int currentPlayer;
	private static int winRequirement;
	private ArrayList<Player> roster;
	Players(int playerCount){
		lastWinner = 0;
		currentPlayer = 0;
		this.playerCount = playerCount;
		roster = new ArrayList<Player>();
		for (int i=0; i <playerCount; i++){	//creates all the players needed and adds them to the list array
			roster.add(new Player(i));}
	  switch (playerCount){ //assigns the number of rounds to win the game
	      	case 2:winRequirement = 7;break;
	      	case 3:winRequirement = 5;break;
	      	case 4:winRequirement = 4;break;
	  }
	}
	public void dealSecondCard(Card card){
		roster.get(currentPlayer).takeCard(card);
	}

	public int getLastWinner(){
		return lastWinner;
	}
	public int getPlayerCount(){
		return playerCount;
	}
	public Player getCurrentPlayer(){
		return roster.get(currentPlayer);
	}
	public Player getRoster(int playerNumber){
		return roster.get(playerNumber);
	}
	public boolean getShield(int playerNumber){
	return roster.get(playerNumber).getShield();}
	public boolean getActive(int playerNumber){
	return roster.get(playerNumber).getActive();}
}

package gameProcessing;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Players {
	private int playerCount;
	private int lastWinner;
	private static int winRequirement;
	private ArrayList<Player> list;
	private ArrayList<String> statusList;
	Players(int playerCount){
		lastWinner = 0;
		this.playerCount = playerCount;
		list = new ArrayList<Player>();
		for (int i=0; i <playerCount; i++){	//creates all the players needed and adds them to the list array
			list.add(new Player(i));}
	    switch (playerCount){ //assigns the number of rounds to win the game
	      	case 2:winRequirement = 7;break;
	      	case 3:winRequirement = 5;break;
	      	case 4:winRequirement = 4;break;
	    }
	}

	public int getPlayerCount() {
		return playerCount;}
	public boolean checkIfWin() {	//check to see if someone has scored the required amount for the game to end
		if (winRequirement == list.get(lastWinner).getScore()){
			return true;}
		else {
			return false;}
	}

	public ArrayList<String> getStatusList(){
		statusList = new ArrayList<String>();
		for (int i=0; i<playerCount; i++){
			if (!getPlayer(i).getActive()){
				statusList.add("Out of round");}
			else if (getPlayer(i).getShield()){
				statusList.add("Handmaid shield");}
			else{
				statusList.add("Use card");}
		}
		return statusList;
	}
	public boolean checkIfActive(){	//checks for minumum players to continue game. greater than 2
		int check = 0;
		for (int i=0; i<playerCount; i++){
			if(list.get(i).getActive()){
				check++;}
		}
		if (check >= 2){
			return true;}
		else{
			return false;}
	}
	public Player getPlayer(int choice){
		return list.get(choice);}
	public ArrayList<Player> getList(){
		return list;}

	public JLabel getCardImage(int playerNumber){
		return list.get(playerNumber).getCard(0).getImage();
	}

	public void setLastWinner(int playerNumber){
		lastWinner = playerNumber;}
	public int getLastWinner(){
		return lastWinner;}
}

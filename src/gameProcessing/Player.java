package gameProcessing;
import java.util.ArrayList;

public class Player {
	private int playerNumber;
	private int score;
	private boolean active = true;
	private boolean shielded = false;
	private ArrayList<Card> hand;
	private ArrayList<Card> discards;
	Player(int playerNumber){
		this.playerNumber = playerNumber;
		hand = new ArrayList<Card>();
		discards = new ArrayList<Card>();
		score = 0;
	}
	public void takeCard(Card card){
		hand.add(card);}
	public void discardCard(){
		if (hand.size()>0){
			discards.add(hand.remove(0));}
		}
	public void discardCard(int choice){
		discards.add(hand.remove(choice));}

	public Card getCard(int choice){
		return hand.get(choice);}
	public ArrayList<Card> getHand(){
		return hand;}
	public Card removeCard(){
		return hand.remove(0);
	}

	public boolean getActive(){
		return active;}
	public void setActive(){
		active = true;}
	public void eliminate(){
		active = false;
		discardCard();
	}


	public int getPlayerNumber() {
		return playerNumber;}
	public Card getDiscardedCard(){
		return discards.get(discards.size()-1);
	}
	public int getScore(){
		return score;}
	public void scoreAPoint(){
		score++;}

	public void shieldOn(){
		shielded = true;}
	public void shieldOff(){
		shielded = false;}
	public boolean getShield(){
		return shielded;}

	public int getDiscardPileValue(){
		int totalValue = 0;
		for (int i=0; i<discards.size(); i++){
			totalValue =+ discards.get(i).getValue();
		}
		return totalValue;
	}

	public void resetRound(){
		hand.clear();
		discards.clear();
		setActive();
		shieldOff();
	}
}

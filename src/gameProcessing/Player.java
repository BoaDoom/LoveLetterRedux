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

	public void discardCard(int choice){
		discards.add(hand.remove(choice));}
	public void discardCard(){
		discards.add(hand.remove(0));}
	public Card getTopDiscard(){
		return discards.get(0);}

	public Card getCard(int choice){
		return hand.get(choice);}
	public ArrayList<Card> getHand(){
		return hand;}

	public void setActive(){
		active = true;}
	public boolean getActive(){
		return active;}
	public void eliminate(){
		active = false;
		discardCard();
	}


	public int getPlayerNumber() {
		return playerNumber;}

	public int getScore(){
		return score;}
	public void scorePoint(){
		score++;}

	public void shieldOn(){
		shielded = true;}
	public void shieldOff(){
		shielded = false;}
	public boolean getShield(){
		return shielded;}

	}

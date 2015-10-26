import java.util.ArrayList;

public class Player {
	private int playerNumber;
	private int score;
	private boolean active = false;
	private ArrayList<Card> hand;
	private ArrayList<Card> discards;	
	Player(int playerNumber){
		this.playerNumber = playerNumber;
		hand = new ArrayList<Card>();
		discards = new ArrayList<Card>();
		active = true;
		score = 0;
	}
	public void takeCard(Card card){
		hand.add(card);}
	
	public void discardCard(int choice){
		discards.add(hand.remove(choice));}
	public void discardCard(){
		discards.add(hand.remove(0));}
	
	public Card getCard(int choice){
		return hand.get(choice);}
	public ArrayList<Card> getHand(){
		return hand;}
	
	public void reset(){
		active = true;}
	public boolean checkActive(){
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
}

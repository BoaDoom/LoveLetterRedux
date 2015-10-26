import java.util.ArrayList;

public class GamePlay {
	private int playerCount;
	private int currentPlayer = 0;
	public Players players;
	private Player player;
	private Deck deck;
	private Card burnCard;
	private ArrayList<Card> burnPile;

	GamePlay(int playerCount){
		deck = new Deck();
		players = new Players(playerCount);
	}

	public void startRound(){
		deck.shuffle();
		burnCard = deck.deal();
		if (playerCount == 2){
			for (int i=0; i<3; i++){
				burnPile.add(deck.deal());}
		}
		for (int i=0; i<players.getPlayerCount(); i++){
			players.getPlayer(i).takeCard(deck.deal());
		}
	}
	public void startTurn(){
		player = players.getPlayer(currentPlayer);
		player.takeCard(deck.deal());
	}


	public void chooseCard(int choice){

	}
	public void chooseTarget(){
	}

	public void rotatePlayer(){
		currentPlayer++;
		if (currentPlayer == playerCount){
			currentPlayer = 0;
		}
	}
	public int getCurrentPlayer(){
		return currentPlayer;}
	public Card getBurnCard(){
		return burnCard;}
	public ArrayList<Card> getBurnPile(){
		return burnPile;}
	public boolean checkIfActive(){
		return players.checkIfActive();}
	public boolean checkIfWin(){
		return players.checkIfWin();}
	public Card deal(){
		return deck.deal();}
	public boolean checkDeck(){
		return deck.checkDeck();}

	public ArrayList<Card> getCardChoices(){
		return player.getHand();}

	public Card getPlayerCard(){
		return player.getCard(0);}
}

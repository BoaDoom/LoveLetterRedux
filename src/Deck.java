import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

public class Deck {
	  private ArrayList<Card> cards;
	  private ArrayList<Card> usedCards;
	  Deck(){
		  cards = new ArrayList<Card>();
		  usedCards = new ArrayList<Card>();
		  for(CardProperties card : CardProperties.values()){		//creating the cards according to the CardProperties enum. Creation of deck.
			  for (int i=0; i<card.countInDeck(); i++){
			  createCard(card.cardValue(), QuickGui.importImage(card.imageLocation()));
			  }
			  //creates deck according to values in CardProprties, giving it a Value, the amount needed to be created, and its image as JLabel
			  //from the quickGui.importImage converter
			}
	  }
	  
	  public void createCard(int cardValue, JLabel image){
		  Card card = new Card(cardValue, image);
		  cards.add(card);
	  }
	  
	  public Card deal(){
		  Card card = cards.remove(0);
		  usedCards.add(card);
		  return card;
	  }
	  
	  public ArrayList<Card> deal(int number){
		  ArrayList<Card> dealtCards = new ArrayList<Card>();
		  for (int i=0; i<number; i++){
			  Card card = cards.remove(0);
			  usedCards.add(card);
			  dealtCards.add(card);
		  }
		  return dealtCards;
	  }
	  
	  public void shuffle(){
		  while (usedCards.size() > 0){
			  cards.add(usedCards.remove(0));}
		  Random ran = new Random();
		  ArrayList<Card> tempDeck = new ArrayList<Card>();		//makes temp deck for shuffling
		  while (cards.size() > 0){ 	//takes all the cards and shuffles them together randomly
			  Card card = cards.remove(ran.nextInt(cards.size()));
			  tempDeck.add(card);
		  }
		  cards = tempDeck;		//transfers randomized cards back into deck of cards 
	  }
	  
	  public boolean checkDeck(){
		  if (cards.size() == 0){
			  return false;}
		  else{return true;}
	  }
	
}

package gameProcessing;

import java.io.File;

public enum CardProperties {
	GUARDCARD		(1, "lovelettercards_Guard_small.jpg", 5, "Guard"),
	PRIESTCARD		(2, "lovelettercards_Priest_small.jpg", 2, "Priest"),
	BARONCARD		(3, "lovelettercards_Baron_small.jpg", 2, "Baron"),
	HANDMAIDCARD	(4, "lovelettercards_Handmaid_small.jpg", 2, "Handmaid"),
	PRINCECARD		(5, "lovelettercards_Prince_small.jpg", 2, "Prince"),
	KINGCARD		(6, "lovelettercards_King_small.jpg", 1, "King"),
	COUNTESSCARD	(7, "lovelettercards_Countess_small.jpg", 1, "Countess"),
	PRINCESSCARD	(8, "lovelettercards_Princess_small.jpg", 1, "Princess");
	// GUARDCARD		(1, "C:/Java Work folder/LoveLetterRedux/Pictures/lovelettercards_Guard_small.jpg", 5),
	// PRIESTCARD		(2, "C:/Java Work folder/LoveLetterRedux/Pictures/lovelettercards_Priest_small.jpg", 2),
	// BARONCARD		(3, "C:/Java Work folder/LoveLetterRedux/Pictures/lovelettercards_Baron_small.jpg", 2),
	// HANDMAIDCARD	(4, "C:/Java Work folder/LoveLetterRedux/Pictures/lovelettercards_Handmaid_small.jpg", 2),
	// PRINCECARD		(5, "C:/Java Work folder/LoveLetterRedux/Pictures/lovelettercards_Prince_small.jpg", 2),
	// KINGCARD		(6, "C:/Java Work folder/LoveLetterRedux/Pictures/lovelettercards_King_small.jpg", 1),
	// COUNTESSCARD	(7, "C:/Java Work folder/LoveLetterRedux/Pictures/lovelettercards_Countess_small.jpg", 1),
	// PRINCESSCARD	(8, "C:/Java Work folder/LoveLetterRedux/Pictures/lovelettercards_Princess_small.jpg", 1);
	private int cardValue;
	private String imageLocation;
	private int countInDeck;
	private String cardName;

	CardProperties(int cardValue, String imageLocal, int cardCount, String cardName){
		File currentDir = new File("");
		this.cardValue = cardValue;
		//this.imageLocation = imageLocal;
		this.imageLocation = currentDir.getAbsolutePath() + "/Pictures/" + imageLocal;
		this.countInDeck = cardCount;
		this.cardName = cardName;
	}

	public int cardValue(){
		return cardValue;
	}
	public String imageLocation(){
		return imageLocation;
	}
	public int countInDeck(){
		return countInDeck;
	}
	public String cardName(){
		return cardName;
	}
	public String fileName(){
		File currentDir = new File("");
		return (currentDir.getAbsolutePath()+"/Pictures/"+imageLocation);
	}
}

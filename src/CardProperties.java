
public enum CardProperties {
	GUARDCARD		(1, "C:/Java Work folder/Pictures/LoveLetter/lovelettercards_Guard_small.jpg", 5),
	PRIESTCARD		(2, "C:/Java Work folder/Pictures/LoveLetter/lovelettercards_Priest_small.jpg", 2),
	BARONCARD		(3, "C:/Java Work folder/Pictures/LoveLetter/lovelettercards_Baron_small.jpg", 2),
	HANDMAIDCARD	(4, "C:/Java Work folder/Pictures/LoveLetter/lovelettercards_Handmaid_small.jpg", 2),
	PRINCECARD		(5, "C:/Java Work folder/Pictures/LoveLetter/lovelettercards_Prince_small.jpg", 2),
	KINGCARD		(6, "C:/Java Work folder/Pictures/LoveLetter/lovelettercards_King_small.jpg", 1),
	COUNTESSCARD	(7, "C:/Java Work folder/Pictures/LoveLetter/lovelettercards_Countess_small.jpg", 1),
	PRINCESSCARD	(8, "C:/Java Work folder/Pictures/LoveLetter/lovelettercards_Princess_small.jpg", 1);
	// GUARDCARD		(1, "D:/Java Projects/LoveLetterRedux/Pictures/lovelettercards_Guard_small.jpg", 5),
	// PRIESTCARD		(2, "D:/Java Projects/LoveLetterRedux/Pictures/lovelettercards_Priest_small.jpg", 2),
	// BARONCARD		(3, "D:/Java Projects/LoveLetterRedux/Pictures/lovelettercards_Baron_small.jpg", 2),
	// HANDMAIDCARD	(4, "D:/Java Projects/LoveLetterRedux/Pictures/lovelettercards_Handmaid_small.jpg", 2),
	// PRINCECARD		(5, "D:/Java Projects/LoveLetterRedux/Pictures/lovelettercards_Prince_small.jpg", 2),
	// KINGCARD		(6, "D:/Java Projects/LoveLetterRedux/Pictures/lovelettercards_King_small.jpg", 1),
	// COUNTESSCARD	(7, "D:/Java Projects/LoveLetterRedux/Pictures/lovelettercards_Countess_small.jpg", 1),
	// PRINCESSCARD	(8, "D:/Java Projects/LoveLetterRedux/Pictures/lovelettercards_Princess_small.jpg", 1);
	private int cardValue;
	private String imageLocation;
	private int countInDeck;

	CardProperties(int cardValue, String imageLocation, int cardCount){
		this.cardValue = cardValue;
		this.imageLocation = imageLocation;
		this.countInDeck = cardCount;
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

}

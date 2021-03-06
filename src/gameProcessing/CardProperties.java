package gameProcessing;

import java.io.File;

public enum CardProperties {
	GUARDCARD		(1, "lovelettercards_Guard_small.jpg", 5, "Guard", false),
	PRIESTCARD		(2, "lovelettercards_Priest_small.jpg", 2, "Priest", false),
	BARONCARD		(3, "lovelettercards_Baron_small.jpg", 2, "Baron", false),
	HANDMAIDCARD	(4, "lovelettercards_Handmaid_small.jpg", 2, "Handmaid", true),
	PRINCECARD		(5, "lovelettercards_Prince_small.jpg", 2, "Prince", false),
	KINGCARD		(6, "lovelettercards_King_small.jpg", 1, "King", false),
	COUNTESSCARD	(7, "lovelettercards_Countess_small.jpg", 1, "Countess", true),
	PRINCESSCARD	(8, "lovelettercards_Princess_small.jpg", 1, "Princess", true);
	private int cardValue;
	private String imageLocation;
	private int countInDeck;
	private String cardName;
	private boolean specialTargeting;

	CardProperties(int cardValue, String imageLocal, int cardCount, String cardName, boolean specialTargeting){
		File currentDir = new File("");
		this.cardValue = cardValue;
		this.imageLocation = currentDir.getAbsolutePath() + "/Pictures/" + imageLocal;
		this.countInDeck = cardCount;
		this.cardName = cardName;
		this.specialTargeting = specialTargeting;
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
	public boolean specialTargeting(){
		return specialTargeting;
	}
	public String fileName(){
		File currentDir = new File("");
		return (currentDir.getAbsolutePath()+"/Pictures/"+imageLocation);
	}
}

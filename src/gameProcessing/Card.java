package gameProcessing;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card {
	private int value;
	private ImageIcon image;
	private String name = "CARDNAMED";
	Card(int value, ImageIcon image){
		this.value = value;
		this.image = image;
	}
	public int getValue(){
		return value;
	}
	public ImageIcon getImage(){
		return image;
	}
	public String getName(){
		return name;
	}

}

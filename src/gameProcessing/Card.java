package gameProcessing;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card {
	private int value;
	private ImageIcon image;
	private String name;
	private boolean specialTargeting;
	Card(int value, ImageIcon image, String name, boolean specialTargeting){
		this.value = value;
		this.image = image;
		this.name = name;
		this.specialTargeting = specialTargeting;
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
	public boolean getSpecialTargeting(){
		return specialTargeting;
	}

}

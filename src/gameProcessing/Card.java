package gameProcessing;
import javax.swing.JLabel;

public class Card {
	private int value;
	private JLabel image;
	Card(int value, JLabel image){
		this.value = value;
		this.image = image;
	}
	public int getValue(){
		return value;
	}
	public JLabel getImage(){
		return image;
	}

}

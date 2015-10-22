import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class QuickGui {
	QuickGui(){
	}
	Integer playerXCord = 198;
	Integer playerYCord = 461;
	Integer buttonSpacing = 145;

	
	ArrayList<JButton> playerButtons = new ArrayList<JButton>();
	public ArrayList<JButton> numOfPlayerButtons(){
		for (int i=MainGui.MIN_PLAYER_NUMBER; i<MainGui.MAX_PLAYER_NUMBER+1; i++){
			JButton pButton = new JButton();
			int xCord = playerXCord + ((i-2)*buttonSpacing);	//spacing the buttons by a set interval
			pButton.setBounds(xCord, playerYCord, MainGui.BUTTON_WIDTH, MainGui.BUTTON_HEIGHT);
			pButton.setText(i + " Players");
			playerButtons.add(pButton);
		}
		return playerButtons;
	}
	
	public static final int CARD_WIDTH = 118;
	public static final int CARD_HEIGHT = 167;
	BufferedImage loadImage = null;
	public static JLabel importImage(String fileLocation){
		BufferedImage loadImage = null;
		try {
	    	loadImage = ImageIO.read(new File(fileLocation));
	    } 
		catch (IOException e) {
	    	e.printStackTrace();
	    }
	    JLabel cardImage = new JLabel(new ImageIcon(loadImage));
	    cardImage.setBounds(0, 0, CARD_WIDTH, CARD_HEIGHT);
	    return cardImage;
		
	}
}

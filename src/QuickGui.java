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
	ArrayList<JButton> targetButtons = new ArrayList<JButton>();
	ArrayList<JLabel> targetNames = new ArrayList<JLabel>();

	public ArrayList<JButton> numOfPlayerButtons(){
		for (int i=MainGui.MIN_PLAYER_NUMBER; i<=MainGui.MAX_PLAYER_NUMBER; i++){
			JButton pButton = new JButton();
			int xCord = playerXCord + ((i-2)*buttonSpacing);	//spacing the buttons by a set interval
			pButton.setBounds(xCord, playerYCord, MainGui.BUTTON_WIDTH, MainGui.BUTTON_HEIGHT);
			pButton.setText(i + " Players");
			playerButtons.add(pButton);
		}
		return playerButtons;
	}
	public ArrayList<JButton> targetButtons(int playerCount){
		int xCord = 0;
		switch(playerCount){
			case 2: xCord = 290; break;
			case 3: xCord = 218; break;
			case 4: xCord = 145; break;
		}
		for (int i=0; i<playerCount; i++){
			JButton pButton = new JButton();
			JLabel tempLabel = new JLabel();
			int tempXCord = (xCord + (i*buttonSpacing));
			pButton.setBounds(tempXCord, playerYCord, MainGui.BUTTON_WIDTH, MainGui.BUTTON_HEIGHT);
			tempLabel.setBounds(tempXCord+25, playerYCord+25, MainGui.BUTTON_WIDTH, MainGui.BUTTON_HEIGHT);
			pButton.setText("Attack");
			tempLabel.setText("Player "+ (i+1));
			targetButtons.add(pButton);
			targetNames.add(tempLabel);
		}
		return targetButtons;
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

	public ArrayList<JLabel> getTargetNames(){
		return targetNames;
	}
}

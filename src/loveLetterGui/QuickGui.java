package loveLetterGui;
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

	ArrayList<JButton> playerButtons = new ArrayList<JButton>();
	ArrayList<JButton> targetButtons = new ArrayList<JButton>();
	ArrayList<JLabel> targetNames = new ArrayList<JLabel>();

	public static final int CARD_WIDTH = 118;
	public static final int CARD_HEIGHT = 167;
	public static ImageIcon importImage(String fileLocation){
		BufferedImage loadImage = null;
		File imageFile = new File(fileLocation);
		try {
			loadImage = ImageIO.read(imageFile);
	    }
		catch (IOException e) {
	    	e.printStackTrace();
	    }
		ImageIcon icon = new ImageIcon(loadImage);
	    return icon;
	}

	public ArrayList<JLabel> getTargetNames(){
		return targetNames;
	}
}

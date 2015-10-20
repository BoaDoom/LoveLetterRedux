import java.awt.Color;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainGui extends JPanel{
	private static final long serialVersionUID = -7956644469997364946L;
	//list of private items created for basic GUI
	private JFrame outterWindow;
	private JPanel gameBoard;
	private JButton nextButton;
	private JButton chooseLeft;
	private JButton chooseRight;
	private JTextField dialogBox;
	private JTextField inputBox;
	QuickGui quickGui;
	
	public static final Integer BUTTONWIDTH = 85;
	public static final Integer BUTTONHEIGHT = 23;
	
	MainGui(){ 
		quickGui = new QuickGui(); //small non-main GUI
		
		//constructor for main GUI screen
		outterWindow = new JFrame();
		gameBoard = new JPanel();
		nextButton = new JButton("Next");
		chooseLeft = new JButton("ChooseL");
		chooseRight = new JButton("ChooseR");
		dialogBox = new JTextField();
		inputBox = new JTextField();
		
		//start up settings for the beginning of a game
		outterWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outterWindow.setBounds(300, 150, 786, 593);
		outterWindow.getContentPane().add(gameBoard);
		outterWindow.setVisible(true);
		
		gameBoard.setLayout(null);
		gameBoard.setBackground(new Color(39,134,39)); //color green
		gameBoard.add(nextButton);
		gameBoard.add(chooseLeft);
		gameBoard.add(chooseRight);
		gameBoard.add(inputBox);
		gameBoard.add(dialogBox);
		
		nextButton.setBounds(367, 520, BUTTONWIDTH, BUTTONHEIGHT);
		chooseLeft.setBounds(254, 401, BUTTONWIDTH, BUTTONHEIGHT);
		chooseRight.setBounds(442, 401, BUTTONWIDTH, BUTTONHEIGHT);
		turnChoiceOff();							//turn off choice buttons until choice needs to be made
		inputBox.setBounds(360, 492, 86, 20);
		inputBox.setVisible(false);
		dialogBox.setBounds(294, 431, 216, 20);
	}
	
	public void startGame(){
		dialogBox.setText("Choose the number of players");
		gameBoard.add(quickGui.numOfPlayerButtons());
		
	}
	
	
	
	public void turnChoiceOn(){		//turns choice buttons both on
		chooseLeft.setVisible(true);
		chooseRight.setVisible(true);
	}
	public void turnChoiceOff(){		//turns choice buttons both off
		chooseLeft.setVisible(false);
		chooseRight.setVisible(false);
	}

}

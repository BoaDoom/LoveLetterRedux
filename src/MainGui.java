import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private ArrayList<JButton> playerButtons;
	private GamePlay gamePlay;
	private JLabel picture;

	//gui generalized formats
	public static final Integer BUTTON_WIDTH = 100;
	public static final Integer BUTTON_HEIGHT = 23;

	//game standard variables
	public static final Integer MAX_PLAYER_NUMBER = 4;
	public static final Integer MIN_PLAYER_NUMBER = 2;

	QuickGui quickGui;
	private int playerCount;

	MainGui(){
		quickGui = new QuickGui(); //small non-main GUI
		playerButtons = new ArrayList<JButton>();

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

		//choosing the starting player number
		playerButtons = quickGui.numOfPlayerButtons();
		for (int i=0; i<playerButtons.size(); i++){
			int counter = i;
			gameBoard.add(playerButtons.get(i));
			playerButtons.get(i).addActionListener(new ActionListener() {// action listener for button
				public void actionPerformed(ActionEvent arg0) {
					playerCount = (counter+2);
					startPlay();
				}
				});
		}

		nextButton.setBounds(343, 520, BUTTON_WIDTH, BUTTON_HEIGHT);
		chooseLeft.setBounds(254, 401, BUTTON_WIDTH, BUTTON_HEIGHT);
		chooseRight.setBounds(442, 401, BUTTON_WIDTH, BUTTON_HEIGHT);
		inputBox.setBounds(360, 492, 86, 20);
		dialogBox.setBounds(294, 431, 216, 20);


	}

	public void bootGame(){
		resetForNewGame();
		dialogBox.setText("Choose the number of players");
		refresh();
	}
	public void startPlay(){
		gamePlay = new GamePlay(playerCount);
		playerButtonsOff();
		turnChoiceOn();
		nextButton.setVisible(true);
		while (gamePlay.checkIfWin()){	//whole game loop, checks to see if anyone has enough points to win //***********is not passing here
			gamePlay.startRound();
			//startOfRound();
			picture = QuickGui.importImage("C:/Java Work folder/Pictures/LoveLetter/lovelettercards_Guard_small.jpg");
			gameBoard.add(picture);
			refresh();
			while (gamePlay.checkIfActive()){	//single round loop, check to see if enough players are active to continue round
				gamePlay.startTurn();
				gamePlay.chooseCard();
				if (!gamePlay.checkDeck()){		//checks to see if deck has a non-zero number
					break;}
			}
			//declare winner of round
			//set winner as players.setLastWinner(*absPlayerNumber*)
		}
		//declare winner of ggame
		
		//dialogBox.setText("CHOSEN CARD " + card.getValue());
	}

	public void startOfRound(){
		for (int i=0; i<playerCount; i++){
			//gameBoard.add(players.getCardImage(i));
			//gameBoard.add(players.getPlayer(0).getCard(0).getImage());
			refresh();
		}
	}

	public void turnChoiceOn(){		//turns choice buttons both on
		chooseLeft.setVisible(true);
		chooseRight.setVisible(true);
	}
	public void turnChoiceOff(){		//turns choice buttons both off
		chooseLeft.setVisible(false);
		chooseRight.setVisible(false);
	}
	public void refresh(){
		outterWindow.setVisible(false);
		outterWindow.setVisible(true);
	}
	
	public void resetForNewGame(){
		playerButtonsOn();
		turnChoiceOff();
		inputBox.setVisible(false);
		nextButton.setVisible(false);
	}
	// public void waitState(){
	// 	while(wait) {
	// 		if (press == "unpressed") {
	// 			//dialogBox.setText("unpressed B");
	// 		}
	// 		else if (press == "pressed"){
	// 		    wait = false;
	// 		    //tester();
	// 		}
	// 	}
	// 	press = "unpressed";
	// 	wait = true;
	// }
	//
	// public void pressButton(){
	// 	press = "pressed";
	// }
	public void playerButtonsOff(){
		for (int i=0; i<playerButtons.size(); i++){
			playerButtons.get(i).setVisible(false);}
	}
	public void playerButtonsOn(){
		for (int i=0; i<playerButtons.size(); i++){
			playerButtons.get(i).setVisible(true);}
	}
	
	public void tester(){
		dialogBox.setText("TRIGGERED");
	}

}

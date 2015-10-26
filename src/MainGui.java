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
	private ArrayList<JButton> targetButtons;
	private GamePlay gamePlay;
	private JLabel pictureL;
	private JLabel pictureR;
	private JLabel pictureChoice;

	//gui generalized formats
	public static final Integer BUTTON_WIDTH = 100;
	public static final Integer BUTTON_HEIGHT = 23;

	//game standard variables
	public static final Integer MAX_PLAYER_NUMBER = 4;
	public static final Integer MIN_PLAYER_NUMBER = 2;

	QuickGui quickGui;
	private int playerCount;
	private String nextState;

	MainGui(){
		nextState = "Beginning";
		quickGui = new QuickGui(); //small non-main GUI
		playerButtons = new ArrayList<JButton>();
		targetButtons = new ArrayList<JButton>();

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
					playerButtonsOff();
					startPlay();
				}
				});
		}

		nextButton.setBounds(343, 520, BUTTON_WIDTH, BUTTON_HEIGHT);
		chooseLeft.setBounds(254, 401, BUTTON_WIDTH, BUTTON_HEIGHT);
		chooseRight.setBounds(442, 401, BUTTON_WIDTH, BUTTON_HEIGHT);
		inputBox.setBounds(360, 492, 86, 20);
		dialogBox.setBounds(294, 431, 216, 20);

		nextButton.addActionListener(new NextScreenAction());
		chooseLeft.addActionListener(new ChooseButtonAction());
		chooseRight.addActionListener(new ChooseButtonAction());
	}
	private class NextScreenAction implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (nextState == "Beginning"){
					nextButton.setVisible(false);
					playerButtonsOn();
					dialogBox.setText("How many human players?");
					refresh();
			}
			else if (nextState == "NextPlayer"){
				nextButton.setVisible(false);
				turnCardChoice();
			}
		}
	}
	private class ChooseButtonAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == chooseLeft){
				gamePlay.chooseCard(0);
				turnPlayerTarget();
			}
			if (e.getSource() == chooseRight){
				gamePlay.chooseCard(1);
				turnPlayerTarget();
			}

		}
	}


	public void bootGame(){		//start of a new game
		resetForNewGame();
		playerButtonsOff();
		dialogBox.setText("Click Next to start a new Game");
		refresh();
	}
	public void startPlay(){		//lead into the new game and rotation of turns
		nextState = "NextPlayer";		//indicating if the NEXT button should lead to the next turn or the start of a new game
		gamePlay = new GamePlay(playerCount);
		targetButtons = quickGui.targetButtons(playerCount);
		addTargetButtons(targetButtons);
		startOfRound();
	}
	public void startOfRound(){
		gamePlay.startRound();
		nextPlayerTurn();
	}
	public void turnCardChoice(){
		gamePlay.startTurn();
		choosePictures();
	}
	public void turnPlayerTarget(){
		pictureL.setVisible(false);
		pictureR.setVisible(false);
		chooseTarget();
	}

	// public void startOfRound(){
	// 	int localx = 0;
	// 	int localy = 0;
	// 	for (int i=0; i<playerCount; i++){
	// 		JLabel picture = gamePlay.players.getPlayer(i).getCard(0).getImage();
	// 		picture.setLocation(localx, localy);
	// 		gameBoard.add(picture);
	// 		localx += 100;
	// 		localy += 100;
	// 		refresh();
	// 	}
	// }
	public void nextPlayerTurn(){
		nextButton.setVisible(true);
		dialogBox.setText("Player "+(gamePlay.getCurrentPlayer()+1)+", click Next to start your turn");
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
		nextState = "Beginning";
		inputBox.setVisible(false);
		nextButton.setVisible(true);
	}

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

	public void choosePictures(){
		ArrayList<Card> tempHand = gamePlay.getCardChoices();
		pictureL = (tempHand.get(0).getImage());
		pictureR = (tempHand.get(1).getImage());
		pictureL.setLocation(245, 225);
		pictureR.setLocation(435, 225);
		gameBoard.add(pictureL);
		gameBoard.add(pictureR);
		dialogBox.setText("Choose a Card to play");
		turnChoiceOn();
		refresh();
	}

	public void addTargetButtons(ArrayList<JButton> targetButtons){
		for (int i=0; i<targetButtons.size()-1; i++){
			gameBoard.add(targetButtons.get(i));
			targetButtonsOn();
		}
	}
	public void targetButtonsOff(){
		for (int i=0; i<targetButtons.size(); i++){
			targetButtons.get(i).setVisible(false);}
	}
	public void targetButtonsOn(){
		for (int i=0; i<targetButtons.size(); i++){
			targetButtons.get(i).setVisible(true);}
	}

	public void chooseTarget(){
		turnChoiceOff();
		pictureChoice = gamePlay.getPlayerCard().getImage();
		pictureChoice.setLocation(340, 225);
		gameBoard.add(pictureChoice);
		dialogBox.setText("Choose a player to play card on");
		refresh();
	}

	public boolean checkIfWin(){
		return gamePlay.checkIfWin();
	}

}





// class WaitState extends Thread{
// 	private boolean wait = true;
// 	private boolean waitTrigger;
// 	WaitState(){
// 	}
// 	public void Run(){
// 		while(wait) {
// 			if (waitTrigger = false) {
// 			}
// 			else if (waitTrigger = true){
// 			    wait = false;
// 			}
// 		}
// 		waitTrigger = false;
// 	}
// 	public void start(){
// 	}
// 	public void trigger(){
// 		waitTrigger = true;
// 	}
// }

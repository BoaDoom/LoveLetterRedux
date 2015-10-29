package loveLetterGui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gameProcessing.Card;
import gameProcessing.GamePlay;

public class NewMainGui extends JPanel{
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
	private ArrayList<JLabel> targetNames;
	private ArrayList<String> statusList;
	private GamePlay gamePlay;
	private JLabel pictureL;
	private JLabel pictureR;
	private JLabel pictureChoice;
	private JLabel tempPictureChoice;

	//gui generalized formats
	public static final Integer BUTTON_WIDTH = 100;
	public static final Integer BUTTON_HEIGHT = 23;

	//game standard variables
	public static final Integer MAX_PLAYER_NUMBER = 4;
	public static final Integer MIN_PLAYER_NUMBER = 2;

	QuickGui quickGui;
	private int playerCount;
	private int target;
	private String nextState;

	public MainGui(){
		nextState = "Beginning";
		quickGui = new QuickGui(); //small non-main GUI
		playerButtons = new ArrayList<JButton>();
		targetButtons = new ArrayList<JButton>();
		targetNames = new ArrayList<JLabel>();

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




	public void bootGame(){		//start of a new game. Step 0
		resetForNewGame();
		playerButtonsOff();
		dialogBox.setText("Click Next to start a new Game");
		refresh();
	}
	private class NextScreenAction implements ActionListener{		//initialization of players, one time thing per game
		public void actionPerformed(ActionEvent arg0) {
			if (nextState == "Beginning"){
					nextButton.setVisible(false);
					playerButtonsOn();
					dialogBox.setText("How many human players?");
					refresh();
			}
			else if (nextState == "NextPlayer"){	//confirmation that the player looking at the screen is the right one, see nextPlayerTurn()
				nextButton.setVisible(false);
				turnCardChoice();
			}
		}
	}

	public void startPlay(){		//lead into the new game and rotation of turns, step 0.5, one time play
		nextState = "NextPlayer";		//indicating if the NEXT button should lead to the next turn or the start of a new game
		gamePlay = new GamePlay(playerCount);
		targetButtons = quickGui.targetButtons(playerCount);
		targetNames = quickGui.getTargetNames();
		addTargetButtons(targetButtons);
		addTargetNames(targetNames);
		targetButtonsOff();
		startOfRound();
	}
	public void startOfRound(){ //Step 1
		gamePlay.startRound();
		nextPlayerTurn();		//confirmation that the player looking at the screen is the right one
	}

	public void turnCardChoice(){		//step 2
		gamePlay.startTurn();		//gives player a new card
		choosePictures();		//shows the players two cards and activates the choose buttons for them to select which to play
	}
	private class ChooseButtonAction implements ActionListener{	//the choose card button ActionListener
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == chooseLeft){
				gamePlay.chooseCard(1);
			}
			if (e.getSource() == chooseRight){
				gamePlay.chooseCard(0);
			}
			chooseTarget();
		}
	}

	public void chooseTarget(){		//step 3
		statusList = gamePlay.getStatusList();
		for (int i=0; i<playerCount; i++){
			targetButtons.get(i).setText(statusList.get(i));
		}
		pictureL.setVisible(false);
		pictureR.setVisible(false);
		turnChoiceOff();		//turns off card choice buttons
		tempPictureChoice = new JLabel();
		tempPictureChoice = gamePlay.getPlayerCard().getImage();		//shows chosen card to play on another player
		addNewPictureOfCardChoice(tempPictureChoice);		//puts the image of the card on the board
		dialogBox.setText("Choose a player to play card on");
		targetButtonsOn();
		refresh();
	}

	public void addTargetButtons(ArrayList<JButton> targetButtons){
		for (int i=0; i<(targetButtons.size()); i++){
			gameBoard.add(targetButtons.get(i));
			int counter = i;
			targetButtons.get(i).addActionListener(new ActionListener() {// action listener for button
				public void actionPerformed(ActionEvent arg0) {
					target(counter+1);
					targetButtonsOff();
					//gamePlay.cardAction();
				}
			});
		}
	}
	public void addTargetNames(ArrayList<JLabel> targetNames){
		for (int i=0; i<(targetNames.size()); i++){
			gameBoard.add(targetNames.get(i));
		}
	}

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

	public void addNewPictureOfCardChoice(JLabel picture){		//if the image hasn't been added to gameBoard, it adds it, else it just changes it
		if(pictureChoice == null){
			pictureChoice = picture;
			gameBoard.add(pictureChoice);
			pictureChoice.setLocation(340, 225);
		}
		pictureChoice = picture;
		pictureChoice.setVisible(true);
	}




	public void targetButtonsOff(){
		for (int i=0; i<targetButtons.size(); i++){
			targetButtons.get(i).setVisible(false);
			targetNames.get(i).setVisible(false);}	//names piggy backing on button activation
	}
	public void targetButtonsOn(){
		for (int i=0; i<targetButtons.size(); i++){
			targetButtons.get(i).setVisible(true);
			targetNames.get(i).setVisible(true);}
	}
	public void target(int temp){
		target = temp;
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

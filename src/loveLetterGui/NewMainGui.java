package loveLetterGui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gameProcessing.GamePlay;
import loveLetterGui.subJPanelGui.*;
import loveLetterGui.subJPanelGui.PlayCardSelect.CardChoiceButtons;
import loveLetterGui.subJPanelGui.PlayerCountSelect.PlayerCountButton;

import javax.swing.JPanel;
import javax.swing.JButton;

public class NewMainGui{

	private JFrame mainFrame;
	private JPanel gameBoard;
	private JLabel testBox;

	//actons done to swap between GUI pannels
	private NextAction nextAction;		//generic next button for progressing to next screen
	private PlayerCountedAction playerCountedAction;
	private ConfirmPlayerTurnAction confirmPlayerTurnAction;
	private SelectedCardAction selectedCardAction;
	private TargetSelectedAction targetSelectedAction;
	private CardGuessedAction cardGuessedAction;

	//JPanels with each interactive part of the game inside them
	private NewGameStart newGameStart;
	private PlayerCountSelect playerCountSelect;
	private NextPlayerCheck nextPlayerCheck;
	private PlayCardSelect playCardSelect;
	private TargetSelect targetSelect;
	private CardGuess cardGuess;

	//game play components and processing that interacts with GUI
	private GamePlay gamePlay;

	private int playerCount;

	public NewMainGui(){//------------constructor
		mainFrame = new JFrame();
		gameBoard = new JPanel();
		testBox = new JLabel("TEST BOX");
		testBox.setBounds(0, 0, 500, 50);
		gameBoard.setLayout(null);
		gameBoard.setBackground(new Color(39,134,39)); //color green
		gameBoard.setBounds(0, 0, 786, 593);

		//frame settings
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(300, 150, 786, 593);
		mainFrame.setVisible(true);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.getContentPane().add(gameBoard);
		gameBoard.add(testBox);

		//custom action classes for sub-gui class interactions with MainGui
		nextAction = new NextAction() ;
		playerCountedAction = new PlayerCountedAction();
		confirmPlayerTurnAction = new ConfirmPlayerTurnAction();
		selectedCardAction = new SelectedCardAction();
		targetSelectedAction = new TargetSelectedAction();
		cardGuessedAction= new CardGuessedAction();

		refresh();
		}
	//========UI panel for asking to start a new game
	public void startGame(){//----------start of game method
		newGameStart = new NewGameStart(nextAction);
		gameBoard.add(newGameStart);
		newGameStart.on();
		refresh();
	}
	public class NextAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			newGameStart.off();
			playerCount();
			refresh();
		}
	}

	//======UI panel for asking number of players
	public void playerCount(){
		playerCountSelect = new PlayerCountSelect(playerCountedAction);
		gameBoard.add(playerCountSelect);
		playerCountSelect.on();
		refresh();
	}
	public class PlayerCountedAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			playerCountSelect.off();
			Integer count = new Integer(((PlayerCountButton) e.getSource()).getCount());
			newGame(count);
		}
	}

	//==========----------====start of main game play loop and creation of all other Panel elements
	public void newGame(int playerCount){
		this.playerCount = playerCount;
		gamePlay = new GamePlay(playerCount);

		nextPlayerCheck = new NextPlayerCheck(gamePlay, confirmPlayerTurnAction); //UI panel for confirming the correct player is looking at the screen
		playCardSelect = new PlayCardSelect(gamePlay, selectedCardAction);	//UI panel for selecting between two cards to play
		targetSelect = new TargetSelect(gamePlay, targetSelectedAction);	//UI for selecting who to play a card on
		//cardGuess = new CardGuess(gamePlay);	//UI for a played guard card to guess other players card
		
		//===adding the turn rotation panels onto the gameBoard panel
		gameBoard.add(nextPlayerCheck);
		gameBoard.add(playCardSelect);
		gameBoard.add(targetSelect);
		//gameBoard.add(cardGuess);
		
		//===turning off all panels except the player check, which sets off the reaction for the rest of the panels
		nextPlayerCheck.on();
		playCardSelect.off();
		targetSelect.off();
	}
	public class ConfirmPlayerTurnAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			nextPlayerCheck.off();
			selectingCard();
		}
	}
	///===================confirmed the correct player, now the turn starts

	//=======selects which card to play
	public void selectingCard(){
		gamePlay.dealSecondCard();
		playCardSelect.on();
	}
	public class SelectedCardAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Integer count = new Integer(((CardChoiceButtons) e.getSource()).getChoice());
			gamePlay.getCurrentPlayer().discardCard(count);
			playCardSelect.off();
			selectingTarget();
		}
	}
	//=====================selects which target to play card against, if any
	public void selectingTarget(){
		targetSelect.on();
		targetSelect.askForTarget();
	}
	public void guessingTargetCard(){

	}



	public class TargetSelectedAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

		}
	}
	public class CardGuessedAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

		}
	}

	public void refresh(){
		gameBoard.validate();
		gameBoard.repaint();
	}
}

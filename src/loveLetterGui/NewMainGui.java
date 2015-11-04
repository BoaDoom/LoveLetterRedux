package loveLetterGui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gameProcessing.GamePlay;
import loveLetterGui.cardPanels.*;
import loveLetterGui.subJPanelGui.*;
import loveLetterGui.subJPanelGui.PlayCardSelect.CardChoiceButtons;
import loveLetterGui.subJPanelGui.PlayerCountSelect.PlayerCountButton;
import loveLetterGui.subJPanelGui.TargetSelect.PlayerTargetButtons;

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
	private CardUseAction cardUseAction;

	private EndOfRoundAction endOfRoundAction;


	//JPanels with each interactive part of the game inside them
	private NewGameStart newGameStart;
	private PlayerCountSelect playerCountSelect;
	private NextPlayerCheck nextPlayerCheck;
	private PlayCardSelect playCardSelect;
	private TargetSelect targetSelect;
	private EndOfRound endOfRound;

	//panels for each of the card's abilities
	// private GenericCardPanel genericCardPanel;
	private GuardPanel guardPanel;
	// private PriestPanel priestPanel;
	// private HandmaidPanel handmaidPanel;
	// private BaronPanel baronPanel;
	// private PrincePanel princePanel;
	// private KingPanel kingPanel;
	// private CountessPanel countessPanel;
	// private PrincessPanel princessPanel;

	//game play components and processing that interacts with GUI
	private GamePlay gamePlay;

	private int playerCount;

	public NewMainGui(){//=====================constructor
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
		cardUseAction= new CardUseAction();

		refresh();
		}
	//=====================UI panel for asking to start a new game. offial start of game, not inside of game loop
	public void startGame(){//----------start of game method
		newGameStart = new NewGameStart(nextAction);
		gameBoard.add(newGameStart);
		newGameStart.on();
		refresh();
	}
	public class NextAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			newGameStart.off();
			playerCountSelect = new PlayerCountSelect(playerCountedAction);
			gameBoard.add(playerCountSelect);
			playerCountSelect.on();
			refresh();
		}
	}
	public class PlayerCountedAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			playerCountSelect.off();
			Integer count = new Integer(((PlayerCountButton) e.getSource()).getCount());

			//=====================start of main game play loop and creation of all other Panel elements
			gamePlay = new GamePlay(count);

			nextPlayerCheck = new NextPlayerCheck(gamePlay, confirmPlayerTurnAction); //UI panel for confirming the correct player is looking at the screen
			playCardSelect = new PlayCardSelect(gamePlay, selectedCardAction);	//UI panel for selecting between two cards to play
			targetSelect = new TargetSelect(gamePlay, targetSelectedAction);	//UI for selecting who to play a card on
			endOfRound = new EndOfRound(gamePlay, endOfRoundAction);

			// genericCardPanel = new GenericCardPanel(gamePlay, cardUseAction);
			guardPanel = new GuardPanel(gamePlay, cardUseAction);
			// priestPanel = new PriestPanel(gamePlay, cardUseAction);
			// handmaidPanel = new HandmaidPanel(gamePlay, cardUseAction);
			// baronPanel = new BaronPanel(gamePlay, cardUseAction);
			// princePanel = new PrincePanel(gamePlay, cardUseAction);
			// kingPanel = new KingPanel(gamePlay, cardUseAction);
			// countessPanel = new CountessPanel(gamePlay, cardUseAction);
			// princessPanel = new PrincessPanel(gamePlay, cardUseAction);

			//adding the turn rotation panels onto the gameBoard panel
			gameBoard.add(nextPlayerCheck);
			gameBoard.add(playCardSelect);
			gameBoard.add(targetSelect);
			gameBoard.add(endOfRound);

			// gameBoard.add(genericCardPanel);
			gameBoard.add(guardPanel);
			// gameBoard.add(priestPanel);
			// gameBoard.add(handmaidPanel);
			// gameBoard.add(baronPanel);
			// gameBoard.add(princePanel);
			// gameBoard.add(kingPanel);
			// gameBoard.add(countessPanel);
			// gameBoard.add(princessPanel);



			//turning off all panels except the player check, which sets off the reaction for the rest of the panels
			nextPlayerCheck.on();
			playCardSelect.off();
			targetSelect.off();
			endOfRound.off();
			cardUsePanelsOff();

			// testCardGui.off();
		}
	}
	//=====================confirmed the correct player, after this the turn rotation starts
	public class ConfirmPlayerTurnAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			nextPlayerCheck.off();

			gamePlay.dealSecondCard();
			testBox.setText(gamePlay.checkForEnoughCards()+" "+gamePlay.getDeckSize()+" "+gamePlay.checkToContinueRound());
			//=====================selects which card to play
			playCardSelect.on();
		}
	}
	public class SelectedCardAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Integer count = new Integer(((CardChoiceButtons) e.getSource()).getChoice());	//collects which button was pressed between the two options
			gamePlay.getCurrentPlayer().discardCard(count);
			playCardSelect.off();
			//=====================selects which target to play card against, if any
			targetSelect.on();
			targetSelect.askForTarget();		//checks targets and labels buttons, populates the card image being targeted at someone
		}
	}
	public class TargetSelectedAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			targetSelect.off();
			Integer target = new Integer(((PlayerTargetButtons) e.getSource()).getChoice()); //collects which target was chosen by the buytton pressed
			int cardUsed = gamePlay.getCurrentPlayer().getDiscardedCard().getValue();		//turns on the appropriate card action panel
			switch(cardUsed){
				case 1:      //Guard
				guardPanel.action(target);
				guardPanel.on();
				break;
				case 2:      //Priest
				// priestPanel.on();
				// priestPanel.action(targetChoice);
				// break;
				case 3:      //Baron
				// baronPanel.on();
				// baronPanel.action(targetChoice);
				// break;
				case 4:      //Handmaid
				// handmaidPanel.on();
				// handmaidPanel.action(targetChoice);
				// break;
				case 5:      //Prince
				// princePanel.on();
				// princePanel.action(targetChoice);
				// break;
				case 6:      //King
				// kingPanel.on();
				// kingPanel.action(targetChoice);
				// break;
				case 7:      //Countess
				// countessPanel.on();
				// countessPanel.action(targetChoice);
				// break;
				case 8:      //Princess
				// princessPanel.on();
				// princessPanel.action(targetChoice);
				// break;

				//temp tester block


				cardUsePanelsOff();
				gamePlay.endOfTurn();
				nextPlayerCheck.on();
			}
		}

	}
	public class CardUseAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			cardUsePanelsOff();
			if (gamePlay.checkToContinueRound()){
				gamePlay.endOfTurn();	//rotates to next player
				nextPlayerCheck.on();	//starts next players turn if the round isn't over
			}
			else {
				endOfRound.on();
			}
		}
	}



	public class EndOfRoundAction implements ActionListener{
		public void actionPerformed(ActionEvent e){

		}
	}




	public void cardUsePanelsOff(){
		guardPanel.off();
		// priestPanel.off();
		// baronPanel.off();
		// handmaidPanel.off();
		// princePanel.off();
		// kingPanel.off();
		// countessPanel.off();
		// princessPanel.off();
	}



	public void refresh(){
		gameBoard.validate();
		gameBoard.repaint();
	}
}

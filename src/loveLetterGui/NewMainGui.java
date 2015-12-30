package loveLetterGui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gameProcessing.Card;
import gameProcessing.GamePlay;
import loveLetterGui.cardPanels.*;
import loveLetterGui.playerPanels.*;
import loveLetterGui.subJPanelGui.*;
import loveLetterGui.subJPanelGui.PlayCardSelect.CardChoiceButtons;
import loveLetterGui.subJPanelGui.PlayerCountSelect.PlayerCountButton;
import loveLetterGui.subJPanelGui.TargetSelect.PlayerTargetButtons;

import javax.swing.JPanel;
import javax.swing.JButton;

public class NewMainGui{

	public final static int MAINFRAME_WIDTH = 786;
	public final static int MAINFRAME_HEIGHT = 593;

	private JFrame mainFrame;
	private JPanel gameBoard;
	private JLabel testBox;

	private LeftPlayerPanel leftPlayerPanel;
	private RightPlayerPanel rightPlayerPanel;
	private TopPlayerPanel topPlayerPanel;
	private ArrayList<PlayerPanelTemplate> playerBoards;

	private MainPlayerPanel mainPlayerPanel;

	//actons done to swap between GUI pannels
	private NextAction nextAction;		//generic next button for progressing to next screen
	private PlayerCountedAction playerCountedAction;
	private ConfirmPlayerTurnAction confirmPlayerTurnAction;
	private SelectedCardAction selectedCardAction;
	private TargetSelectedAction targetSelectedAction;
	private CardUseAction cardUseAction;
	private EndOfRoundAction endOfRoundAction;
	private EndOfGameCheckAction endOfGameCheckAction;

	private BackOutOfTargettingAction backOutOfTargettingAction;

	//JPanels with each interactive part of the game inside them
	private NewGameStart newGameStart;
	private PlayerCountSelect playerCountSelect;
	private NextPlayerCheck nextPlayerCheck;
	private PlayCardSelect playCardSelect;
	private TargetSelect targetSelect;
	private EndOfRound endOfRound;
	private EndOfGameCheck endOfGameCheck;

	//panels for each of the card's abilities
	private GuardPanel guardPanel;
	private PriestPanel priestPanel;
	private BaronPanel baronPanel;
	private HandmaidPanel handmaidPanel;
	private PrincePanel princePanel;
	private KingPanel kingPanel;
	private CountessPanel countessPanel;
	private PrincessPanel princessPanel;

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
		gameBoard.setBounds(0, 0, MAINFRAME_WIDTH, MAINFRAME_HEIGHT);

		//frame settings
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(300, 150, MAINFRAME_WIDTH, MAINFRAME_HEIGHT);
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
		endOfRoundAction = new EndOfRoundAction();
		endOfGameCheckAction = new EndOfGameCheckAction();

		backOutOfTargettingAction = new BackOutOfTargettingAction();

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
			targetSelect = new TargetSelect(gamePlay, targetSelectedAction, backOutOfTargettingAction);	//UI for selecting who to play a card on
			endOfRound = new EndOfRound(gamePlay, endOfRoundAction);
			endOfGameCheck = new EndOfGameCheck(gamePlay, endOfGameCheckAction);

			guardPanel = new GuardPanel(gamePlay, cardUseAction);
			priestPanel = new PriestPanel(gamePlay, cardUseAction);
			baronPanel = new BaronPanel(gamePlay, cardUseAction);
			handmaidPanel = new HandmaidPanel(gamePlay, cardUseAction, backOutOfTargettingAction);
			princePanel = new PrincePanel(gamePlay, cardUseAction);
			kingPanel = new KingPanel(gamePlay, cardUseAction);
			countessPanel = new CountessPanel(gamePlay, cardUseAction, backOutOfTargettingAction);
			princessPanel = new PrincessPanel(gamePlay, cardUseAction, backOutOfTargettingAction);

			mainPlayerPanel = new MainPlayerPanel(gamePlay, 0);
			playerBoards = new ArrayList<PlayerPanelTemplate>();
			switch (count){
				case 2:
				topPlayerPanel = new TopPlayerPanel(gamePlay, 1);
				playerBoards.add(topPlayerPanel);
				break;
				case 3:
				rightPlayerPanel = new RightPlayerPanel(gamePlay, 1);
				leftPlayerPanel = new LeftPlayerPanel(gamePlay, 2);
				playerBoards.add(rightPlayerPanel);
				playerBoards.add(leftPlayerPanel);
				break;
				case 4:
				topPlayerPanel = new TopPlayerPanel(gamePlay, 2);
				rightPlayerPanel = new RightPlayerPanel(gamePlay, 1);
				leftPlayerPanel = new LeftPlayerPanel(gamePlay, 3);
				playerBoards.add(rightPlayerPanel);
				playerBoards.add(topPlayerPanel);
				playerBoards.add(leftPlayerPanel);
				break;
			}

			//adding the turn rotation panels onto the gameBoard panel
			gameBoard.add(nextPlayerCheck);
			gameBoard.add(playCardSelect);
			gameBoard.add(targetSelect);
			gameBoard.add(endOfRound);
			gameBoard.add(endOfGameCheck);

			gameBoard.add(guardPanel);
			gameBoard.add(priestPanel);
			gameBoard.add(baronPanel);
			gameBoard.add(handmaidPanel);
			gameBoard.add(princePanel);
			gameBoard.add(kingPanel);
			gameBoard.add(countessPanel);
			gameBoard.add(princessPanel);

			gameBoard.add(mainPlayerPanel);
//			gameBoard.add(topPlayerPanel);
			for (int i=0; i<playerBoards.size(); i++){
				gameBoard.add(playerBoards.get(i));
				playerBoards.get(i).on();
			}

			//turning off all panels except the player check, which sets off the reaction for the rest of the panels
			nextPlayerCheck.on();
			playCardSelect.off();
			targetSelect.off();
			endOfRound.off();
			endOfGameCheck.off();
			cardUsePanelsOff();
			mainPlayerPanel.on();
			refresh();
		}
	}
	//=====================confirmed the correct player, after this the turn rotation starts
	public class ConfirmPlayerTurnAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			nextPlayerCheck.off();

			gamePlay.getCurrentPlayer().shieldOff();
			gamePlay.dealSecondCard();
			// ArrayList<Card> testStack = new ArrayList<Card>();
			// testStack = gamePlay.getDiscardPile();
			mainPlayerPanel.updatePlayer();
			for (int i=0; i<playerBoards.size(); i++){
				playerBoards.get(i).updatePlayer();
			}


			String testString = new String();
			for (int i=0; i< gamePlay.getPlayerCount(); i++){
				testString += (" "+(i+1)+": "+ gamePlay.getRosterPlayer(i).getScore());
			}
			testBox.setText(gamePlay.getLastWinner()+"");
			//=====================selects which card to play
			playCardSelect.on();
		}
	}
	public class SelectedCardAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Integer count = new Integer(((CardChoiceButtons) e.getSource()).getChoice());	//collects which button was pressed between the two options
			gamePlay.getCurrentPlayer().playCard(count);
			playCardSelect.off();
							//special action for non target cards
			if (gamePlay.getCurrentPlayer().getPlayedCard().getSpecialTargeting()){	//if the card doesn't have the common targeting action, i.e. self targeting only
				specialTargetingCards();
			}
			else{
				//=====================selects which target to play card against, if any
				targetSelect.on();
				targetSelect.askForTarget();		//checks targets and labels buttons, populates the card image being targeted at someone
			}
		}
	}
	public class BackOutOfTargettingAction implements ActionListener{//backing out of the targeting menu back button action
		public void actionPerformed(ActionEvent e){
			targetSelect.off();
			cardUsePanelsOff();
			playCardSelect.on();
		}
	}

	public class TargetSelectedAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			targetSelect.off();
			Integer target = new Integer(((PlayerTargetButtons) e.getSource()).getChoice()); //collects which target was chosen by the button pressed
			gamePlay.getCurrentPlayer().discardChoice();	//discards the card played and whos action is used
			if (target == -1){		//if the card was played without any action or target
				endOfTurn();
			}
			else{
				int cardUsed = gamePlay.getCurrentPlayer().getPlayedCard().getValue();		//turns on the appropriate card action panel
				switch(cardUsed){
					case 1:      //Guard
					guardPanel.on();
					guardPanel.action(target);
					break;
					case 2:      //Priest
					priestPanel.on();
					priestPanel.action(target);
					break;
					case 3:      //Baron
					baronPanel.on();
					baronPanel.action(target);
					break;
					case 5:      //Prince
					princePanel.on();
					princePanel.action(target);
					break;
					case 6:      //King
					kingPanel.on();
					kingPanel.action(target);
					break;
				}
			}
		}
	}
	public void specialTargetingCards(){
		int cardUsed = gamePlay.getCurrentPlayer().getPlayedCard().getValue();
		switch(cardUsed){
			case 4:
			handmaidPanel.on();
			break;
			case 7:
			countessPanel.on();
			break;
			case 8:
			princessPanel.on();
			break;
		}
	}
	public void specialTargetingCardsAction(){
		int cardUsed = gamePlay.getCurrentPlayer().getPlayedCard().getValue();
		switch(cardUsed){
			case 4:
			gamePlay.getCurrentPlayer().discardChoice();	//discards the card played and whos action is used
			handmaidPanel.action();
			break;
			case 7:
			gamePlay.getCurrentPlayer().discardChoice();	//discards the card played and whos action is used
			break;
			case 8:
			gamePlay.getCurrentPlayer().discardChoice();	//discards the card played and whos action is used
			princessPanel.action();
			break;
		}
	}
	public class CardUseAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			specialTargetingCardsAction();	//performs the action of self-use only cards after the card is confirmed
			cardUsePanelsOff();
			if (gamePlay.checkToContinueRound()){
				endOfTurn();
			}
			else {
//				mainPlayerPanel.off();
				repaint();
				endOfRound.on();
				gamePlay.endOfRound();//resets deck, players cards and players states
				mainPlayerPanel.resetPlayerBoard();
				int tempInt = gamePlay.getLastWinner();
				for (int i=0; i<playerBoards.size(); i++){
					playerBoards.get(i).resetPlayerBoard();
					tempInt += 1;
					if (tempInt == gamePlay.getPlayerCount()){
						tempInt = 0;
					}
					playerBoards.get(i).resetAfterRound(tempInt);
				}
			}
		}
	}

	public class EndOfRoundAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			endOfRound.off();
			if (!gamePlay.checkForEnoughScore()){
				nextPlayerCheck.on();	//starts next round if the game isn't over
			}
			else {
				endOfGameCheck.on();
				endOfGameCheck.action();
			}
		}
	}

	public class EndOfGameCheckAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			gameBoard.removeAll();
			startGame();
		}
	}



	public void cardUsePanelsOff(){
		guardPanel.off();
		priestPanel.off();
		baronPanel.off();
		handmaidPanel.off();
		princePanel.off();
			princePanel.princessDiscardOff(); //extra dialog if the princess was discarded
		kingPanel.off();
		countessPanel.off();
		princessPanel.off();
	}


	public void endOfTurn(){
		gamePlay.endOfTurn();	//rotates to next player
		// mainPlayerPanel.rotatePlayer();
		for (int i=0; i<playerBoards.size(); i++){
			playerBoards.get(i).rotatePlayer();
		}
		if (!gamePlay.getCurrentPlayer().getActive()){
			endOfTurn();
		}
		else{
			nextPlayerCheck.on();	//starts next players turn if the round isn't over
		}
	}

	public void repaint() {
		mainFrame.repaint();

	}
	public void refresh(){
		gameBoard.validate();
		gameBoard.repaint();
	}
}

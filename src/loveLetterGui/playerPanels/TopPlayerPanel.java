package loveLetterGui.playerPanels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import gameProcessing.GamePlay;

public class TopPlayerPanel extends PlayerPanelTemplate{
	int playerNumber;
	GamePlay gamePlay;
	protected int DISCARD_PILE_XCORD;
	protected int DISCARD_PILE_YCORD;
	protected int SCORE_XCORD;
	protected int SCORE_YCORD;
	protected int PLAYERTABLE_HEIGHT;
	protected int PLAYERTABLE_WIDTH;

	public TopPlayerPanel(GamePlay gamePlay, int playerNumber) {
		super(gamePlay, playerNumber);
	    this.playerNumber = playerNumber;
	    this.gamePlay = gamePlay;

		int DISCARD_PILE_XCORD = 300;
		int DISCARD_PILE_YCORD = 50;

		int SCORE_XCORD = 700;
		int SCORE_YCORD = 15;

	  int PLAYERTABLE_HEIGHT = 150;
	  int PLAYERTABLE_WIDTH = 786;

	  discardPile = new JLabel[MAX_SHOWN_DISCARD_COUNT];
	    scoreCircle = new JRadioButton[gamePlay.getWinRequirement()];
	    scoreText = new JLabel();    ///change to dynamic name changing later
//	    scoreText.setText("Player "+ (gamePlay.getCurrentPlayer().getPlayerNumber()+1) +" Score:");
//	    scoreText.setBounds(5,0,100, 15);
	    this.add(scoreText);


	    this.setLayout(null);
	    this.setBackground(new Color(39,75,39)); //color green
	    this.setBounds(0, 0, PLAYERTABLE_WIDTH, PLAYERTABLE_HEIGHT);
	    this.setVisible(true);

	    for (int i=0; i<gamePlay.getWinRequirement(); i++){
	      scoreCircle[i] = new JRadioButton();
	      scoreCircle[i].setEnabled(false);
	      scoreCircle[i].setBackground(new Color(39,75,39));
	      scoreCircle[i].setBounds((SCORE_XCORD-(i*SCORE_X_DISPLACEMENT)), SCORE_YCORD, 21, 21);
	      this.add(scoreCircle[i]);
	    }


	    for (int e=0; e<MAX_SHOWN_DISCARD_COUNT; e++){  //adding and displaying the discard pile JLabels
	    	int f = ((MAX_SHOWN_DISCARD_COUNT-1)-e);
	      discardPile[f] = new JLabel();
	      this.add(discardPile[f]);
	      discardPile[f].setSize(CARD_LENGTH, CARD_HEIGHT);
	      discardPile[f].setLocation((DISCARD_PILE_XCORD + (f*DISCARD_PILE_X_DISPLACEMENT)), DISCARD_PILE_YCORD);
	      if (f >= 5){
	    	  discardPile[f].setLocation((DISCARD_PILE_XCORD + ((f-5)*DISCARD_PILE_X_DISPLACEMENT) + 8), (DISCARD_PILE_YCORD + DISCARD_PILE_Y_DISPLACEMENT));
	      }

		// TODO Auto-generated constructor stub
	    }
	}
//	public void resetBoardAfterRound(){
//	    for (int i=0; i<gamePlay.getWinRequirement(); i++){
//	        scoreCircle[i].setSelected(false);
//	    }
//	    for (int i=0; i<MAX_SHOWN_DISCARD_COUNT; i++){
//	      discardPile[i].setIcon(null);
//	    }
//	    this.playerNumber =
//	}
}

package loveLetterGui.playerPanels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import gameProcessing.GamePlay;

public class LeftPlayerPanel extends PlayerPanelTemplate{
	int playerNumber;
	GamePlay gamePlay;
	int PLAYERTABLE_HEIGHT = 200;
	int PLAYERTABLE_WIDTH = 200;

	private final static int ORIGIN_X =10;
	private final static int ORIGIN_Y =10;

	private final static int LOCATION_X =0;
	private final static int LOCATION_Y =200;

	public LeftPlayerPanel(GamePlay gamePlay, int playerNumber) {
		super(gamePlay, playerNumber, ORIGIN_X, ORIGIN_Y);
	  this.playerNumber = playerNumber;
	  this.gamePlay = gamePlay;

		discardPile = new JLabel[MAX_SHOWN_DISCARD_COUNT];
    scoreCircle = new JRadioButton[gamePlay.getWinRequirement()];

		scoreText = new JLabel();    ///change to dynamic name changing later
		scoreText.setText("SCORE: ");
		scoreText.setBounds((SCORE_TEXT_XCORD),(SCORE_TEXT_YCORD),100, 15);
		this.add(scoreText);

    playerText = new JLabel();    ///change to dynamic name changing later
    playerText.setText("Player "+ (playerNumber+1));
    playerText.setBounds(NAME_XCORD,NAME_YCORD,100, 15);
		this.add(playerText);

    this.gamePlay = gamePlay;
    this.setLayout(null);
    this.setBackground(new Color(39,75,39)); //color green
    this.setBounds(LOCATION_X, LOCATION_Y, PLAYERTABLE_WIDTH, PLAYERTABLE_HEIGHT);
    this.setVisible(true);

    for (int i=0; i<gamePlay.getWinRequirement(); i++){
      scoreCircle[i] = new JRadioButton();
      scoreCircle[i].setEnabled(false);
      scoreCircle[i].setBackground(new Color(39,75,39));
      scoreCircle[i].setBounds((SCORE_XCORD+(i*SCORE_X_DISPLACEMENT)), SCORE_YCORD, 21, 21);
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
    }
  }
}

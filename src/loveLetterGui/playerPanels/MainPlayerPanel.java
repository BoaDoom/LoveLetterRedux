package loveLetterGui.playerPanels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import gameProcessing.GamePlay;
import loveLetterGui.NewMainGui;

public class MainPlayerPanel extends PlayerPanelTemplate{
	int playerNumber;
	GamePlay gamePlay;
	static int PLAYERTABLE_HEIGHT = 200;
	static int PLAYERTABLE_WIDTH = 200;

	private final static int ORIGIN_X =15;
	private final static int ORIGIN_Y =0;

	private final static int LOCATION_X =0;
	private final static int LOCATION_Y = NewMainGui.MAINFRAME_HEIGHT - PLAYERTABLE_HEIGHT;


	public MainPlayerPanel(GamePlay gamePlay, int playerNumber) {
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
	public void updatePlayer(){
		resetPlayerBoard();
		this.on();
		playerText.setText("Player "+ (gamePlay.getCurrentPlayer().getPlayerNumber()+1));
		for (int i=0; i<gamePlay.getDiscardPile().size(); i++){
			discardPile[i].setIcon(gamePlay.getDiscardPile().get(i).getImage());
		}
		for (int i=1; i<(MAX_SHOWN_DISCARD_COUNT-gamePlay.getDiscardPile().size()); i++){
			discardPile[MAX_SHOWN_DISCARD_COUNT-i].setIcon(null);
		}

		for (int i=0; i<gamePlay.getWinRequirement(); i++){
			scoreCircle[i].setSelected(false);
			if ((i+1)<=gamePlay.getCurrentPlayer().getScore()){
				scoreCircle[i].setSelected(true);
			}
		}
		this.repaint();
	}

}

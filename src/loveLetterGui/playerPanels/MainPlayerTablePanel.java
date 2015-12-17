package loveLetterGui.playerPanels;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gameProcessing.Card;
import gameProcessing.GamePlay;
import loveLetterGui.NewMainGui;
import loveLetterGui.QuickGui;
import javax.swing.JRadioButton;

public class MainPlayerTablePanel extends JPanel{
	private final int DISCARD_PILE_XCORD = 600;
	private final int DISCARD_PILE_YCORD = 15;
	final static int DISCARD_PILE_X_DISPLACEMENT = 20;
	final static int DISCARD_PILE_Y_DISPLACEMENT = 20;

	private final int SCORE_XCORD = 6;
	private final int SCORE_YCORD = 15;
	final static int SCORE_X_DISPLACEMENT = 21;

  final static int MAX_SHOWN_DISCARD_COUNT = 10; //the size of the discards shown in a game

  private final int PLAYERTABLE_HEIGHT = 395;
  private final int PLAYERTABLE_WIDTH = 786;

  public static final int CARD_LENGTH = 122/2;
  public static final int CARD_HEIGHT = 166/2;

  JLabel scoreText;
  JLabel[] discardPile;
  JRadioButton[] scoreCircle;
  GamePlay gamePlay;


  public MainPlayerTablePanel(GamePlay gamePlay){
    discardPile = new JLabel[MAX_SHOWN_DISCARD_COUNT];
    scoreCircle = new JRadioButton[gamePlay.getWinRequirement()];

    scoreText = new JLabel();    ///change to dynamic name changing later
    scoreText.setText("Player "+ (gamePlay.getCurrentPlayer().getPlayerNumber()+1) +" Score:");
    scoreText.setBounds(5,0,100, 15);
    this.add(scoreText);

    this.gamePlay = gamePlay;
    this.setLayout(null);
    this.setBackground(new Color(39,75,39)); //color green
    this.setBounds(0, PLAYERTABLE_HEIGHT, PLAYERTABLE_WIDTH, PLAYERTABLE_HEIGHT);
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
//      discardPile[i].setIcon(QuickGui.importImage("C:/Java Work folder/LoveLetterRedux/Pictures/lovelettercards_Guard_small.jpg"));
    }
  }

  public void updatePlayer(){
    resetPlayerBoard();
	  this.on();
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

  public void resetPlayerBoard(){
    for (int i=0; i<gamePlay.getWinRequirement(); i++){
      scoreCircle[i].setSelected(false);
    }
    for (int i=0; i<MAX_SHOWN_DISCARD_COUNT; i++){
      discardPile[i].setIcon(null);
    }

  }
  public void on(){
	  this.setVisible(true);
  }
  public void off(){
	  this.setVisible(false);
  }
  public void refresh(){
    this.repaint();
  }
}

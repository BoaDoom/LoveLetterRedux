package loveLetterGui.playerPanels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import gameProcessing.GamePlay;

public class PlayerPanelTemplate extends JPanel{

	// protected final int DISCARD_PILE_X_DISPLACEMENT = MainPlayerTablePanel.DISCARD_PILE_X_DISPLACEMENT;
	// protected final int DISCARD_PILE_Y_DISPLACEMENT = MainPlayerTablePanel.DISCARD_PILE_Y_DISPLACEMENT;
	//
	// protected final int SCORE_Y_DISPLACEMENT= MainPlayerTablePanel.SCORE_X_DISPLACEMENT;
	// protected final int SCORE_X_DISPLACEMENT = MainPlayerTablePanel.SCORE_X_DISPLACEMENT;
	//
	// final static int origin_X =15;
	// final static int origin_Y =0;
	//
	// final static int ORIGIN_TO_NAME_X_GAP =0;
	// final static int ORIGIN_TO_SCORE_TEXT_X_GAP =0;
	// final static int ORIGIN_TO_SCORE_X_GAP =45;
	// final static int ORIGIN_TO_DISCARD_X_GAP =0;
	//
	// final static int ORIGIN_TO_NAME_Y_GAP =0;
	// final static int ORIGIN_TO_SCORE_TEXT_Y_GAP =18;
	// final static int ORIGIN_TO_SCORE_Y_GAP =15;
	// final static int ORIGIN_TO_DISCARD_Y_GAP =40;
	//
	// private final int DISCARD_PILE_XCORD = origin_X+ORIGIN_TO_DISCARD_X_GAP;
	// private final int DISCARD_PILE_YCORD = origin_Y+ORIGIN_TO_DISCARD_Y_GAP;
	//
	// private final int NAME_XCORD = origin_X+ORIGIN_TO_NAME_X_GAP;
	// private final int NAME_YCORD = origin_Y+ORIGIN_TO_NAME_Y_GAP;
	//
	// private final int SCORE_TEXT_XCORD = origin_X+ORIGIN_TO_SCORE_TEXT_X_GAP;
	// private final int SCORE_TEXT_YCORD = origin_Y+ORIGIN_TO_SCORE_TEXT_Y_GAP;
	//
	// private final int SCORE_XCORD = origin_X+ORIGIN_TO_SCORE_X_GAP;
	// private final int SCORE_YCORD = origin_Y+ORIGIN_TO_SCORE_Y_GAP;
	//
  // final static int MAX_SHOWN_DISCARD_COUNT = 10; //the size of the discards shown in a game
	//
  // public static final int CARD_LENGTH = MainPlayerTablePanel.CARD_LENGTH;
  // public static final int CARD_HEIGHT = MainPlayerTablePanel.CARD_HEIGHT;
	///////////////////////////
	protected int origin_X;
	protected int origin_Y;
	protected int PLAYERTABLE_HEIGHT;
	protected int PLAYERTABLE_WIDTH;

	protected int DISCARD_PILE_XCORD;
	protected int DISCARD_PILE_YCORD;
	protected int SCORE_XCORD;
	protected int SCORE_YCORD;
	protected int NAME_XCORD;
	protected int NAME_YCORD;
	protected int SCORE_TEXT_XCORD;
	protected int SCORE_TEXT_YCORD;

	static final int ORIGIN_TO_NAME_X_GAP =0;
	static final int ORIGIN_TO_SCORE_TEXT_X_GAP =0;
	static final int ORIGIN_TO_SCORE_X_GAP =45;
	static final int ORIGIN_TO_DISCARD_X_GAP =0;

	static final int ORIGIN_TO_NAME_Y_GAP =0;
	static final int ORIGIN_TO_SCORE_TEXT_Y_GAP =18;
	static final int ORIGIN_TO_SCORE_Y_GAP =15;
	static final int ORIGIN_TO_DISCARD_Y_GAP =40;

	static final int DISCARD_PILE_X_DISPLACEMENT = 20;
	static final int DISCARD_PILE_Y_DISPLACEMENT = 20;
	static final int SCORE_X_DISPLACEMENT = 21;

  static final int MAX_SHOWN_DISCARD_COUNT = 10; //the size of the discards shown in a game

  public static final int CARD_LENGTH = 122/2;
  public static final int CARD_HEIGHT = 166/2;
	////////////////////

  JLabel scoreText;
	JLabel playerText;
  JLabel[] discardPile;
  JRadioButton[] scoreCircle;
  GamePlay gamePlay;

  protected int playerNumber;


  public PlayerPanelTemplate(GamePlay gamePlay, int playerNumber, int origin_X, int origin_Y){
	this.playerNumber = playerNumber;
	this.gamePlay = gamePlay;
	DISCARD_PILE_XCORD = origin_X+ORIGIN_TO_DISCARD_X_GAP;
	DISCARD_PILE_YCORD = origin_Y+ORIGIN_TO_DISCARD_Y_GAP;

	NAME_XCORD = origin_X+ORIGIN_TO_NAME_X_GAP;
	NAME_YCORD = origin_Y+ORIGIN_TO_NAME_Y_GAP;

	SCORE_TEXT_XCORD = origin_X+ORIGIN_TO_SCORE_TEXT_X_GAP;
	SCORE_TEXT_YCORD = origin_Y+ORIGIN_TO_SCORE_TEXT_Y_GAP;

	SCORE_XCORD = origin_X+ORIGIN_TO_SCORE_X_GAP;
	SCORE_YCORD = origin_Y+ORIGIN_TO_SCORE_Y_GAP;
//      discardPile[i].setIcon(QuickGui.importImage("C:/Java Work folder/LoveLetterRedux/Pictures/lovelettercards_Guard_small.jpg"));
    }

  public void updatePlayer(){
    resetPlayerBoard();
	  this.on();
		playerText.setText("Player "+ (playerNumber+1));
    for (int i=0; i<gamePlay.getPlayerDiscardPile(playerNumber).size(); i++){
      discardPile[i].setIcon(gamePlay.getPlayerDiscardPile(playerNumber).get(i).getImage());
      }
    for (int i=1; i<(MAX_SHOWN_DISCARD_COUNT-gamePlay.getPlayerDiscardPile(playerNumber).size()); i++){
      discardPile[MAX_SHOWN_DISCARD_COUNT-i].setIcon(null);
    }

    for (int i=0; i<gamePlay.getWinRequirement(); i++){
      scoreCircle[i].setSelected(false);
      if ((i+1)<=gamePlay.getRosterPlayer(playerNumber).getScore()){
        scoreCircle[i].setSelected(true);
      }
    }
    this.repaint();
  }
  public void rotatePlayer(){
    this.playerNumber++;
    if (playerNumber >= gamePlay.getPlayerCount()){
      this.playerNumber = 0;
    }
  }

  public void resetPlayerBoard(){
    for (int i=0; i<gamePlay.getWinRequirement(); i++){
      scoreCircle[i].setSelected(false);
    }
    for (int i=0; i<MAX_SHOWN_DISCARD_COUNT; i++){
      discardPile[i].setIcon(null);
    }
  }
  public void resetAfterRound(int playerNumber){
	  this.playerNumber = playerNumber;
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

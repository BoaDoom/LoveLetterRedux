package loveLetterGui.playerPanels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import gameProcessing.GamePlay;

public class PlayerPanelTemplate extends JPanel{

	protected final int DISCARD_PILE_X_DISPLACEMENT = MainPlayerTablePanel.DISCARD_PILE_X_DISPLACEMENT;
	protected final int DISCARD_PILE_Y_DISPLACEMENT = MainPlayerTablePanel.DISCARD_PILE_Y_DISPLACEMENT;


	protected final int SCORE_Y_DISPLACEMENT= MainPlayerTablePanel.SCORE_X_DISPLACEMENT;
	protected final int SCORE_X_DISPLACEMENT = MainPlayerTablePanel.SCORE_X_DISPLACEMENT;

  protected final int MAX_SHOWN_DISCARD_COUNT = MainPlayerTablePanel.MAX_SHOWN_DISCARD_COUNT; //the size of the discards shown in a game



  public static final int CARD_LENGTH = MainPlayerTablePanel.CARD_LENGTH;
  public static final int CARD_HEIGHT = MainPlayerTablePanel.CARD_HEIGHT;

  JLabel scoreText;
  JLabel[] discardPile;
  JRadioButton[] scoreCircle;
  GamePlay gamePlay;

  int playerNumber;


  public PlayerPanelTemplate(GamePlay gamePlay, int playerNumber){
	this.playerNumber = playerNumber;
	this.gamePlay = gamePlay;
    
//      discardPile[i].setIcon(QuickGui.importImage("C:/Java Work folder/LoveLetterRedux/Pictures/lovelettercards_Guard_small.jpg"));
    }

  public void updatePlayer(){
    resetPlayerBoard();
	  this.on();
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
    playerNumber++;
    if (playerNumber >= gamePlay.getPlayerCount()){
      playerNumber = 0;
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

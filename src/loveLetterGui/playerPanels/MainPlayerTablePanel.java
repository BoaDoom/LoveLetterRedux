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

public class MainPlayerTablePanel extends JPanel{
  //mainFrame.setBounds(300, 150, 786, 593);
	private final int DISCARD_PILE_XCORD = 600;
	private final int DISCARD_PILE_YCORD = 15;
	private final int DISCARD_PILE_X_DISPLACEMENT = 20;
	private final int DISCARD_PILE_Y_DISPLACEMENT = 20;

  private final int MAX_SHOWN_DISCARD_COUNT = 10; //the size of the discards shown in a game

  private final int PLAYERTABLE_HEIGHT = 593/3;
  private final int PLAYERTABLE_WIDTH = 786;

  public static final int CARD_LENGTH = 122/2;
  public static final int CARD_HEIGHT = 166/2;

  JLabel[] discardPile;
  GamePlay gamePlay;


  public MainPlayerTablePanel(GamePlay gamePlay){
    discardPile = new JLabel[MAX_SHOWN_DISCARD_COUNT];

    this.gamePlay = gamePlay;
    this.setLayout(null);
    this.setBackground(new Color(39,75,39)); //color green
    this.setBounds(0, PLAYERTABLE_HEIGHT*2, PLAYERTABLE_WIDTH, PLAYERTABLE_HEIGHT);
    this.setVisible(true);


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
	  this.on();
     for (int i=0; i<gamePlay.getDiscardPile().size(); i++){
       discardPile[i].setIcon(gamePlay.getDiscardPile().get(i).getImage());
     }
     for (int i=1; i<(MAX_SHOWN_DISCARD_COUNT-gamePlay.getDiscardPile().size()); i++){
       discardPile[MAX_SHOWN_DISCARD_COUNT-i].setIcon(null);
     }
    this.repaint();
  }
  public void resetPlayerBoard(){
    for (int i=0; i<MAX_SHOWN_DISCARD_COUNT; i++){
      discardPile[i].setIcon(null);
      //     discardPile[i].setIcon(QuickGui.importImage("C:/Java Work folder/LoveLetterRedux/Pictures/lovelettercards_Guard_small.jpg"));
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

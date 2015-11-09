package loveLetterGui.cardPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gameProcessing.GamePlay;
import gameProcessing.Player;
import gameProcessing.Card;
import gameProcessing.CardProperties;

public class KingPanel extends CardPanelTemplate{
  Card playersCard;
  Card opponentsCard;
  public KingPanel(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;

    dialog1.setText("You will swap cards with your target");
    nextButton.addActionListener(action);

    this.add(dialog1);
    this.add(dialog2);
    this.add(dialog3);
    this.add(cardImage1);
    this.add(cardImage2);
    this.add(nextButton);

    dialog1.setVisible(true);
    dialog2.setVisible(true);
    dialog3.setVisible(true);
    cardImage1.setVisible(true);
    cardImage2.setVisible(true);
    nextButton.setVisible(true);
  }
  public void action(int targetChoice){
    this.playersCard = gamePlay.getCurrentPlayer().getCard(0);
    cardImage1.setIcon(playersCard.getImage());
    this.opponentsCard = gamePlay.getRosterPlayer(targetChoice).getCard(0);
    cardImage2.setIcon(opponentsCard.getImage());
    String player1 = ""+(gamePlay.getRosterPlayer(targetChoice).getPlayerNumber()+1);
    String player2 = ""+(gamePlay.getCurrentPlayer().getPlayerNumber()+1);
    dialog1.setText("You've swapped cards with your target");
    dialog2.setText(player1 + " now owns " + player2 +"'s "+gamePlay.getCurrentPlayer().getCard(0).getName());
    dialog3.setText(player2 + " now owns " + player1 +"'s "+gamePlay.getRosterPlayer(targetChoice).getCard(0).getName());

    Card yourCard = gamePlay.getCurrentPlayer().removeCard();
    Card theirCard = gamePlay.getRosterPlayer(targetChoice).removeCard();

    gamePlay.getCurrentPlayer().takeCard(theirCard);
    gamePlay.getRosterPlayer(targetChoice).takeCard(yourCard);

  }
}

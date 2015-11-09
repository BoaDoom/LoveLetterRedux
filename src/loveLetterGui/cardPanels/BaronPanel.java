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

public class BaronPanel extends CardPanelTemplate{
  Card playersCard;
  Card opponentsCard;
  public BaronPanel(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;

    dialog1.setText("You are in a duel, high card wins");
    nextButton.addActionListener(action);

    this.add(dialog0);
    this.add(dialog1);
    this.add(dialog2);
    this.add(dialog3);
    this.add(cardImage1);
    this.add(cardImage2);
    this.add(nextButton);

    dialog0.setVisible(true);
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
    dialog0.setText("Player "+ (gamePlay.getCurrentPlayer().getPlayerNumber()+1)+" vs Player "+ (gamePlay.getRosterPlayer(targetChoice).getPlayerNumber()+1));
    if (playersCard.getValue() > opponentsCard.getValue()){
      dialog2.setText("Player "+ (gamePlay.getCurrentPlayer().getPlayerNumber()+1) + " has the high card");
      dialog3.setText("Player "+ (gamePlay.getRosterPlayer(targetChoice).getPlayerNumber()+1) + " is knocked out");
      gamePlay.getRosterPlayer(targetChoice).eliminate();
    }
    else if (playersCard.getValue() < opponentsCard.getValue()){
      dialog2.setText("Player " + (gamePlay.getRosterPlayer(targetChoice).getPlayerNumber()+1) + " has the high card");
      dialog3.setText("Player " + (gamePlay.getCurrentPlayer().getPlayerNumber()+1) + " is knocked out");
      gamePlay.getCurrentPlayer().eliminate();
    }
    else if (playersCard.getValue() == opponentsCard.getValue()){
      dialog2.setText("Players have the same card!");
      dialog3.setText("nobody is knocked out");
    }
  }
}

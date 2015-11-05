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
  GamePlay gamePlay;
  JLabel dialog2;
  JLabel dialog3;
  Card playersCard;
  Card opponentsCard;
  JLabel playersCardImage;
  JLabel opponentsCardImage;
  private int targetChoice;
  public KingPanel(GamePlay gamePlay, ActionListener action){
    nextButton = new JButton();
    dialog = new JLabel();
    dialog2 = new JLabel();
    dialog3 = new JLabel();
    this.gamePlay = gamePlay;

    playersCardImage = new JLabel();
    opponentsCardImage = new JLabel();

    this.add(playersCardImage);
    this.add(opponentsCardImage);

    playersCardImage.setBounds(50,50,118,167);
    opponentsCardImage.setBounds(250,50,118,167);

    dialog = new JLabel("You've swapped cards with your target");
    dialog.setBounds(125, dialogLocationY+40, dialogWidth, dialogHeight);

    dialog2 = new JLabel("");
    dialog2.setBounds(125, dialogLocationY+60, dialogWidth, dialogHeight);
    dialog3 = new JLabel("");
    dialog3.setBounds(125, dialogLocationY+80, dialogWidth, dialogHeight);

    nextButton.setBounds(150, buttonLocationY+60, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);
    nextButton.setText("Next");

    this.add(dialog);
    this.add(dialog2);
    this.add(dialog3);
    this.add(playersCardImage);
    this.add(opponentsCardImage);
    this.add(nextButton);
  }
  public void action(int targetChoice){
    this.playersCard = gamePlay.getCurrentPlayer().getCard(0);
    playersCardImage.setIcon(playersCard.getImage());
    this.opponentsCard = gamePlay.getRosterPlayer(targetChoice).getCard(0);
    opponentsCardImage.setIcon(opponentsCard.getImage());
    String player1 = ""+(gamePlay.getRosterPlayer(targetChoice).getPlayerNumber()+1);
    String player2 = ""+(gamePlay.getCurrentPlayer().getPlayerNumber()+1);
    dialog2.setText(player1 + " now owns " + player2 +"'s "+gamePlay.getCurrentPlayer().getCard(0).getName());
    dialog3.setText(player2 + " now owns " + player1 +"'s "+gamePlay.getRosterPlayer(targetChoice).getCard(0).getName());

    Card yourCard = gamePlay.getCurrentPlayer().removeCard();
    Card theirCard = gamePlay.getRosterPlayer(targetChoice).removeCard();

    gamePlay.getCurrentPlayer().takeCard(theirCard);
    gamePlay.getRosterPlayer(targetChoice).takeCard(yourCard);

  }
}
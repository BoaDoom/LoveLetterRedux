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

public class PriestPanel extends CardPanelTemplate{
  GamePlay gamePlay;
  Card hiddenCard;
  JLabel hiddenCardImage;
  private int targetChoice;
  public PriestPanel(GamePlay gamePlay, ActionListener action){
    nextButton = new JButton();
    dialog = new JLabel();
    this.gamePlay = gamePlay;

    hiddenCardImage = new JLabel();
    hiddenCardImage.setBounds(150,15,118,167);

    dialog = new JLabel("This is your target's card");
    dialog.setBounds(125, dialogLocationY+15, dialogWidth, dialogHeight);

    nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);
    nextButton.setText("Next");

    this.add(dialog);
    this.add(hiddenCardImage);
    this.add(nextButton);
  }
  public void action(int targetChoice){
    this.hiddenCard = gamePlay.getRosterPlayer(targetChoice).getCard(0);
    hiddenCardImage.setIcon(hiddenCard.getImage()); //turns the discarded/selected card that is being used against someone
  }
}

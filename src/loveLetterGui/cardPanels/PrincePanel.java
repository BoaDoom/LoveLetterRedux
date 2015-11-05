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

public class PrincePanel extends CardPanelTemplate{
  GamePlay gamePlay;
  Card chosenCard;
  JLabel chosenCardImage;
  private int targetChoice;
  public PrincePanel(GamePlay gamePlay, ActionListener action){
    nextButton = new JButton();
    dialog = new JLabel();
    this.gamePlay = gamePlay;

    chosenCardImage = new JLabel();
    chosenCardImage.setBounds(150,15,118,167);

    dialog = new JLabel("Your target is forced to discard this card");
    dialog.setBounds(125, dialogLocationY+15, dialogWidth, dialogHeight);

    nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);
    nextButton.setText("Next");

    this.add(dialog);
    this.add(chosenCardImage);
    this.add(nextButton);
  }
  public void action(int targetChoice){
    this.chosenCard = gamePlay.getRosterPlayer(targetChoice).getCard(0);
    chosenCardImage.setIcon(chosenCard.getImage()); //turns the discarded/selected card that is being used against someone
    gamePlay.getRosterPlayer(targetChoice).discardCard();
    if (gamePlay.checkForEnoughCards()){
      gamePlay.getRosterPlayer(targetChoice).takeCard(gamePlay.dealExtraCard());
    }
    else{
      gamePlay.getRosterPlayer(targetChoice).takeCard(gamePlay.getBurnCard());
    }
  }
}

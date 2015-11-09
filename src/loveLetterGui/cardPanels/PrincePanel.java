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
  // GamePlay gamePlay;
  Card chosenCard;
  // JLabel cardImageCenter;
  // JLabel dialog2;
  // private int targetChoice;
  public PrincePanel(GamePlay gamePlay, ActionListener action){
    // nextButton = new JButton();
    // dialog = new JLabel();
    // dialog2 = new JLabel();
    this.gamePlay = gamePlay;

    // cardImageCenter = new JLabel();
    // cardImageCenter.setBounds(150,15,118,167);

    dialog1.setText("Your target is forced to discard this card");
    // dialog.setBounds(125, dialogLocationY+15, dialogWidth, dialogHeight);
    dialog2.setText("It's the Princess! they are knocked out");
    // dialog2.setBounds(125, dialogLocationY+25, dialogWidth, dialogHeight);
    princessDiscardOff();

    // nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);
    // nextButton.setText("Next");

    this.add(dialog1);
    this.add(dialog2);
    this.add(cardImageCenter);
    this.add(nextButton);

    dialog1.setVisible(true);
    dialog2.setVisible(true);
    cardImageCenter.setVisible(true);
    nextButton.setVisible(true);
  }
  public void action(int targetChoice){
    this.chosenCard = gamePlay.getRosterPlayer(targetChoice).getCard(0);
    cardImageCenter.setIcon(chosenCard.getImage()); //turns the discarded/selected card that is being used against someone
    gamePlay.getRosterPlayer(targetChoice).discardCard();
    if (gamePlay.getRosterPlayer(targetChoice).getDiscardedCard().getValue() == 8){ //checks if the forced card is a princess, which loses the person the round
      princessDiscardOn();
      gamePlay.getRosterPlayer(targetChoice).eliminate();
    }
    else{   //player is forced to discard but must imediately draw another card
      if (gamePlay.checkForEnoughCards()){  //as long as there are enough cards left in the deck they get one normally
        gamePlay.getRosterPlayer(targetChoice).takeCard(gamePlay.dealExtraCard());
      }
      else{ //else they get the very first burn 'hidden' card and the round ends
        gamePlay.getRosterPlayer(targetChoice).takeCard(gamePlay.getBurnCard());
      }
    }
  }
  public void princessDiscardOn(){
    dialog2.setVisible(true);
  }
  public void princessDiscardOff(){
    dialog2.setVisible(false);
  }
}

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
  // GamePlay gamePlay;
  Card opponentsCard;
  // JLabel cardImageCenter;
  // private int targetChoice;
  public PriestPanel(GamePlay gamePlay, ActionListener action){
    // nextButton = new JButton();
    // dialog1 = new JLabel();
    this.gamePlay = gamePlay;

    // cardImageCenter = new JLabel();
    // cardImageCenter.setBounds(150,15,118,167);

    dialog1.setText("This is your target's card");
    // dialog1.setBounds(125, dialog1LocationY+15, dialog1Width, dialog1Height);

    // nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);
    // nextButton.setText("Next");

    this.add(dialog1);
    this.add(cardImageCenter);
    this.add(nextButton);

    dialog1.setVisible(true);
    cardImageCenter.setVisible(true);
    nextButton.setVisible(true);
  }
  public void action(int targetChoice){
    this.opponentsCard = gamePlay.getRosterPlayer(targetChoice).getCard(0);
    cardImageCenter.setIcon(opponentsCard.getImage()); //turns the discarded/selected card that is being used against someone
  }
}

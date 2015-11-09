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
  Card opponentsCard;
  public PriestPanel(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;

    dialog1.setText("This is your target's card");
    nextButton.addActionListener(action);

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

package loveLetterGui.cardPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gameProcessing.GamePlay;
import gameProcessing.Player;
import loveLetterGui.QuickGui;
import gameProcessing.Card;
import gameProcessing.CardProperties;

public class HandmaidPanel extends CardPanelTemplate{
  // GamePlay gamePlay;
  String handmaidImageLocation;
  // JLabel cardImageCenter;
  // private int targetChoice;
  // JButton backButton;
  public HandmaidPanel(GamePlay gamePlay, ActionListener action, ActionListener backButtonAction){
    // nextButton = new JButton();
    // dialog = new JLabel();
    this.gamePlay = gamePlay;

    // backButton = new JButton();
    backButton.addActionListener(backButtonAction);
    // backButton.setBounds(20, buttonLocationY+80, buttonWidth-15, buttonHeight-10);

    // cardImageCenter = new JLabel();
	  File currentDir = new File("");
    handmaidImageLocation = currentDir.getAbsolutePath() + "/Pictures/lovelettercards_Handmaid_small.jpg";
    cardImageCenter.setIcon(QuickGui.importImage(handmaidImageLocation));
    // cardImageCenter.setBounds(150,15,118,167);

    dialog1.setText("The Handmaiden will protecting you for one round");
    // dialog.setBounds(125, dialogLocationY+15, dialogWidth, dialogHeight);

    // nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);
    // nextButton.setText("Next");
    this.add(dialog1);
    this.add(cardImageCenter);
    this.add(nextButton);
    this.add(backButton);

    dialog1.setVisible(true);
    cardImageCenter.setVisible(true);
    nextButton.setVisible(true);
    backButton.setVisible(true);


  }
  public void action(){
    gamePlay.getCurrentPlayer().shieldOn();
  }
}

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
  GamePlay gamePlay;
  String handmaidImageLocation;
  JLabel handmaidCardImage;
  private int targetChoice;
  public HandmaidPanel(GamePlay gamePlay, ActionListener action){
    nextButton = new JButton();
    dialog = new JLabel();
    this.gamePlay = gamePlay;

    handmaidCardImage = new JLabel();
	  File currentDir = new File("");
    handmaidImageLocation = currentDir.getAbsolutePath() + "/Pictures/lovelettercards_Handmaid_small.jpg";
    handmaidCardImage.setIcon(QuickGui.importImage(handmaidImageLocation));
    handmaidCardImage.setBounds(150,15,118,167);

    dialog = new JLabel("The Handmaiden is now protecting you for one round");
    dialog.setBounds(125, dialogLocationY+15, dialogWidth, dialogHeight);

    nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);
    nextButton.setText("Next");
    this.add(dialog);
    this.add(handmaidCardImage);
    this.add(nextButton);

  }
  public void action(){
    gamePlay.getCurrentPlayer().shieldOn();
  }
}

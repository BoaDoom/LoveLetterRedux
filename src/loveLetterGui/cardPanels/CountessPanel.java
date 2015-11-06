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

public class CountessPanel extends CardPanelTemplate{
  GamePlay gamePlay;
  String countessImageLocation;
  JLabel countessCardImage;
  private int targetChoice;
  public CountessPanel(GamePlay gamePlay, ActionListener action){
    nextButton = new JButton();
    dialog = new JLabel();
    this.gamePlay = gamePlay;

    countessCardImage = new JLabel();
	  File currentDir = new File("");
    countessImageLocation = currentDir.getAbsolutePath() + "/Pictures/lovelettercards_Countess_small.jpg";
    countessCardImage.setIcon(QuickGui.importImage(countessImageLocation));
    countessCardImage.setBounds(150,15,118,167);

    dialog = new JLabel("The Countessen is leaves your hand with no effect");
    dialog.setBounds(125, dialogLocationY+15, dialogWidth, dialogHeight);

    nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);
    nextButton.setText("Next");
    this.add(dialog);
    this.add(countessCardImage);
    this.add(nextButton);

  }
  public void action(){
  }
}

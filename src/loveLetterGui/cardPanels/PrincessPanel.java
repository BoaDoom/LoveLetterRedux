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

public class PrincessPanel extends CardPanelTemplate{
  GamePlay gamePlay;
  String princessImageLocation;
  JLabel princessCardImage;
  JButton backButton;
  private int targetChoice;
  public PrincessPanel(GamePlay gamePlay, ActionListener action, ActionListener backButtonAction){
    nextButton = new JButton();
    dialog = new JLabel();
    this.gamePlay = gamePlay;

    backButton = new JButton();
    backButton.addActionListener(backButtonAction);
    backButton.setBounds(20, buttonLocationY+80, buttonWidth-15, buttonHeight-10);

    princessCardImage = new JLabel();
	  File currentDir = new File("");
    princessImageLocation = currentDir.getAbsolutePath() + "/Pictures/lovelettercards_Princess_small.jpg";
    princessCardImage.setIcon(QuickGui.importImage(princessImageLocation));
    princessCardImage.setBounds(150,15,118,167);

    dialog = new JLabel("The Princess has been discarded, you are eliminated");
    dialog.setBounds(125, dialogLocationY+15, dialogWidth, dialogHeight);

    nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);
    nextButton.setText("Next");
    this.add(dialog);
    this.add(princessCardImage);
    this.add(nextButton);
    this.add(backButton);

  }
  public void action(){
    gamePlay.getCurrentPlayer().eliminate();
  }
  public void action(int player){
    gamePlay.getRosterPlayer(player).eliminate();
  }
}

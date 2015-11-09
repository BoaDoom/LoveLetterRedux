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
  String princessImageLocation;
  public PrincessPanel(GamePlay gamePlay, ActionListener action, ActionListener backButtonAction){
    this.gamePlay = gamePlay;

    backButton.addActionListener(backButtonAction);
	  File currentDir = new File("");
    princessImageLocation = currentDir.getAbsolutePath() + "/Pictures/lovelettercards_Princess_small.jpg";
    cardImageCenter.setIcon(QuickGui.importImage(princessImageLocation));

    dialog1.setText("The Princess has been discarded, you are eliminated");
    nextButton.addActionListener(action);
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
    gamePlay.getCurrentPlayer().eliminate();
  }
  public void action(int player){
    gamePlay.getRosterPlayer(player).eliminate();
  }
}

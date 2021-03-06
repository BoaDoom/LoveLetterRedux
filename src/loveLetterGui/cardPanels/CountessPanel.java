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
  String countessImageLocation;

  public CountessPanel(GamePlay gamePlay, ActionListener action, ActionListener backButtonAction){

    this.gamePlay = gamePlay;

    backButton.addActionListener(backButtonAction);

	  File currentDir = new File("");
    countessImageLocation = currentDir.getAbsolutePath() + "/Pictures/lovelettercards_Countess_small.jpg";
    cardImageCenter.setIcon(QuickGui.importImage(countessImageLocation));

    dialog1.setText("The Countess is leaves your hand with no effect");
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
  }
}

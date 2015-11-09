package loveLetterGui.subJPanelGui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gameProcessing.GamePlay;

import loveLetterGui.cardPanels.CardPanelTemplate;

public class NextPlayerCheck extends CardPanelTemplate{
  public NextPlayerCheck(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;
    nextButton.setText("Next");
    nextButton.addActionListener(action);

    this.add(nextButton);
    this.add(dialog0);
    nextButton.setVisible(true);
    dialog0.setVisible(true);
    askPlayerToGo();
  }
  public void askPlayerToGo(){
    dialog0.setText("Player " + (gamePlay.getCurrentPlayer().getPlayerNumber()+1) + ", press Next to start your turn");
  }
  public void on(){
	  askPlayerToGo();
	  this.setVisible(true);
  }
}

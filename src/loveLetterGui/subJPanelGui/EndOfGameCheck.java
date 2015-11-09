package loveLetterGui.subJPanelGui;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gameProcessing.GamePlay;
import gameProcessing.Player;
import gameProcessing.Players;

import loveLetterGui.cardPanels.CardPanelTemplate;

public class EndOfGameCheck extends CardPanelTemplate{
  public EndOfGameCheck(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;
    nextButton.setText("New Game");
    nextButton.addActionListener(action);

    this.add(nextButton);
    this.add(dialog1);
    nextButton.setVisible(true);
    dialog1.setVisible(true);
  }
  public void action(){
    dialog1.setText("The game is over, Player "+ (gamePlay.getLastWinner()+1) + " won");
  }



}

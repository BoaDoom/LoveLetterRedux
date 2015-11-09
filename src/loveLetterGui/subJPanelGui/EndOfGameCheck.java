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
  GamePlay gamePlay;
  // JButton nextButton;
  public EndOfGameCheck(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;
    // nextButton = new JButton();
    nextButton.setText("New Game");
    // nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);
    // dialog1 = new JLabel();
    // dialog1.setText("");
    // dialog1.setHorizontalAlignment(SwingConstants.CENTER);
    // dialog1.setBounds(100, dialog1LocationY, dialog1Width, dialog1Height);

    this.add(nextButton);
    this.add(dialog1);
    nextButton.setVisible(true);
    dialog1.setVisible(true);
  }
  public void action(){
    dialog1.setText("The game is over, Player "+ (gamePlay.getLastWinner()+1) + " won");
  }



}

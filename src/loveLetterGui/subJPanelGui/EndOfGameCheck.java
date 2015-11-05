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

public class EndOfGameCheck extends JPanelTemplate{
  GamePlay gamePlay;
  JButton nextButton;
  public EndOfGameCheck(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;
    nextButton = new JButton();
    nextButton.setText("New Game");
    nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);
    dialog = new JLabel();
    dialog.setText("");
    dialog.setHorizontalAlignment(SwingConstants.CENTER);
    dialog.setBounds(100, dialogLocationY, dialogWidth, dialogHeight);

    this.add(nextButton);
    this.add(dialog);
  }
  public void action(){
    dialog.setText("The game is over, Player "+ (gamePlay.getLastWinner()+1) + " won");
  }



}

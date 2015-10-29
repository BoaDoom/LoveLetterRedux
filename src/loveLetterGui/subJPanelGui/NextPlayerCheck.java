package loveLetterGui.subJPanelGui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gameProcessing.GamePlay;

public class NextPlayerCheck extends JPanelTemplate{
  GamePlay gamePlay;
  JButton nextButton;
  public NextPlayerCheck(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;
    nextButton = new JButton();
    nextButton.setText("Next");
    nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);

    dialogText = new String();
    askPlayerToGo();

    dialog = new JLabel();
    dialog.setText(dialogText);
    dialog.setHorizontalAlignment(SwingConstants.CENTER);
    dialog.setBounds(100, dialogLocationY, dialogWidth, dialogHeight);

    this.add(nextButton);
    this.add(dialog);
  }
  public void askPlayerToGo(){
    dialogText = "Player " + (gamePlay.getCurrentPlayer().getPlayerNumber()+1) + ", press Next to start your turn";
  }
}

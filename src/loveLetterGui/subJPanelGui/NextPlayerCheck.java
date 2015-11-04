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
    dialog = new JLabel();
    dialog.setText("");
    dialog.setHorizontalAlignment(SwingConstants.CENTER);
    dialog.setBounds(100, dialogLocationY, dialogWidth, dialogHeight);
    
    this.add(nextButton);
    this.add(dialog);
    
    askPlayerToGo();

  }
  public void askPlayerToGo(){
    dialog.setText("Player " + (gamePlay.getCurrentPlayer().getPlayerNumber()+1) + ", press Next to start your turn");
  }
  public void on(){
	  askPlayerToGo();
	  this.setVisible(true);
	  this.repaint();
  }
}

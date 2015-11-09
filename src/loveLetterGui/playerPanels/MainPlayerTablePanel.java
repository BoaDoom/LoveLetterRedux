package loveLetterGui.playerPanels;

import java.awt.Color;

import javax.swing.JPanel;

import gameProcessing.GamePlay;
import loveLetterGui.NewMainGui;

public class MainPlayerTablePanel extends JPanel{
  //mainFrame.setBounds(300, 150, 786, 593);
  private final int PLAYERTABLE_HEIGHT = 593/3;
  private final int PLAYERTABLE_WIDTH = 7863;

  GamePlay gamePlay;

  
  public MainPlayerTablePanel(GamePlay gamePlay){
    this.gamePlay = gamePlay;
    this.setLayout(null);
    this.setBackground(new Color(39,75,39)); //color green
    this.setBounds(0, PLAYERTABLE_HEIGHT*2, PLAYERTABLE_WIDTH, PLAYERTABLE_HEIGHT);
    this.setVisible(true);
  }
}

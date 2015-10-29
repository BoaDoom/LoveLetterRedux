package loveLetterGui.subJPanelGui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PlayerCountSelect extends JPanelTemplate{
  private JLabel dialog;
  private PlayerCountButton twoPlayers;
  private PlayerCountButton threePlayers;
  private PlayerCountButton fourPlayers;
  public PlayerCountSelect(ActionListener action){
    dialog = new JLabel("Select the amount of players");
    dialog.setBounds(125, dialogLocationY, dialogWidth, dialogHeight);
    this.add(dialog);

    twoPlayers = new PlayerCountButton("Two players", 2);
    threePlayers = new PlayerCountButton("Three players", 3);
    fourPlayers = new PlayerCountButton("Four players", 4);
    twoPlayers.setBounds(0, buttonLocationY, buttonWidth, buttonHeight);
    threePlayers.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    fourPlayers.setBounds(300, buttonLocationY, buttonWidth, buttonHeight);
    twoPlayers.addActionListener(action);
    threePlayers.addActionListener(action);
    fourPlayers.addActionListener(action);
    this.add(twoPlayers);
    this.add(threePlayers);
    this.add(fourPlayers);
  }
  public class PlayerCountButton extends JButton{
    int count;
    PlayerCountButton(String name, int playerCount){
      this.setText(name);
      this.count = playerCount;
    }
    public int getCount(){
      return count;
    }
  }
}

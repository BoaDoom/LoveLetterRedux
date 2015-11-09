package loveLetterGui.subJPanelGui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import loveLetterGui.cardPanels.CardPanelTemplate;

public class PlayerCountSelect extends CardPanelTemplate{    //slecting the amount of players in the game
  private PlayerCountButton twoPlayers;
  private PlayerCountButton threePlayers;
  private PlayerCountButton fourPlayers;
  public PlayerCountSelect(ActionListener action){
    dialog0.setText("Select the amount of players");
    this.add(dialog0);
    dialog0.setVisible(true);

    twoPlayers = new PlayerCountButton("Two players", 2);
    threePlayers = new PlayerCountButton("Three players", 3);
    fourPlayers = new PlayerCountButton("Four players", 4);
    twoPlayers.setBounds((panelLength/6)-(BUTTON_WIDTH/2), BUTTON_CHOICE_YCORD, BUTTON_WIDTH, BUTTON_HEIGHT);
    threePlayers.setBounds(((panelLength/6)*3)-(BUTTON_WIDTH/2), BUTTON_CHOICE_YCORD, BUTTON_WIDTH, BUTTON_HEIGHT);
    fourPlayers.setBounds(((panelLength/6)*5)-(BUTTON_WIDTH/2), BUTTON_CHOICE_YCORD, BUTTON_WIDTH, BUTTON_HEIGHT);
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

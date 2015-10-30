package loveLetterGui.subJPanelGui;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameProcessing.Card;
import gameProcessing.GamePlay;

public class TargetSelect extends JPanelTemplate{
  GamePlay gamePlay;
  Card playedCard;
  JLabel playedCardImage;
  ArrayList<PlayerTargetButtons> targetButtons;
  ArrayList<JLabel> playerNames;
  public TargetSelect(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;
    targetButtons = new ArrayList<PlayerTargetButtons>();
    playerNames = new ArrayList<JLabel>();

    playedCardImage = new JLabel();
    playedCardImage.setBounds(150,15,118,167);

    dialog = new JLabel("Choose a player to play card on");
    dialog.setBounds(125, dialogLocationY+15, dialogWidth, dialogHeight);
    this.add(dialog);
    this.add(playedCardImage);
    int split = (panelLength/gamePlay.getPlayerCount());
    for (int i=0; i<gamePlay.getPlayerCount(); i++){
      PlayerTargetButtons player = new PlayerTargetButtons(i);
      JLabel playerName = new JLabel("Player "+(i+1));
      targetButtons.add(player);
      targetButtons.get(i).setBounds((split*i)+((split/2)-(buttonWidth-25)/2), 250, buttonWidth-25, buttonHeight);
      playerNames.add(playerName);
      playerNames.get(i).setBounds((split*i)+((split/2)-(buttonWidth-25)/2)+25, 280, buttonWidth-25, buttonHeight);
      this.add(targetButtons.get(i));
      this.add(playerNames.get(i));
    }
   }
  public void askForTarget(){
	this.playedCard = gamePlay.getCurrentPlayer().getDiscardedCard();
    playedCardImage.setIcon(playedCard.getImage());
  }
  public class PlayerTargetButtons extends JButton{
    int choice;
    PlayerTargetButtons(int choice){
      this.choice = choice;
    }
    public int getChoice(){
      return choice;
    }
    public void setDialogText(String text){
      this.setText(text);
	  }
	}
}

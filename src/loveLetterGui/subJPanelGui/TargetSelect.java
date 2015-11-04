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
  JLabel dialog;
  ArrayList<PlayerTargetButtons> targetButtons;
  ArrayList<JLabel> playerNames;
  public TargetSelect(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;
    targetButtons = new ArrayList<PlayerTargetButtons>();
    playerNames = new ArrayList<JLabel>();

    playedCardImage = new JLabel();
    playedCardImage.setBounds(150,15,118,167);

    dialog = new JLabel(""); //default dialog
    dialog.setBounds(125, dialogLocationY+15, dialogWidth, dialogHeight);
    this.add(dialog);
    this.add(playedCardImage);
    int split = (panelLength/gamePlay.getPlayerCount());
    for (int i=0; i<gamePlay.getPlayerCount(); i++){    //loop for placing the correct amount of buttons and corisponding playerNames
      PlayerTargetButtons player = new PlayerTargetButtons(i);
      player.addActionListener(action);
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
    playedCardImage.setIcon(playedCard.getImage()); //turns the discarded/selected card that is being used against someone
    int tempCounter = 0;    //counting to see how many targets are disabled
    for (int i=0; i<gamePlay.getPlayerCount(); i++){//sets the button names to show availibility of the targets
      targetButtons.get(i).setText("Use On");
      targetButtons.get(i).setEnabled(true);
        if (!gamePlay.getActive(i)){    //checks if player is active
          targetButtons.get(i).setText("Out");
          targetButtons.get(i).setEnabled(false);
          tempCounter++;
        }
        else if (gamePlay.getShield(i)){  //checks if player is shielded by a maiden
          targetButtons.get(i).setText("Shielded");
          targetButtons.get(i).setEnabled(false);
          tempCounter++;
        }
        else if (gamePlay.getCurrentPlayer().getPlayerNumber() == i){   //checking for self targeting
          targetButtons.get(i).setText("Yourself");
          if (playedCard.getValue() ==  5){   //5 is the prince card, only card that you can activate on yourself
            targetButtons.get(i).setEnabled(true);
          }
          else{
            targetButtons.get(i).setEnabled(false);
            tempCounter++;
          }
      }
    }
    dialog.setText("Choose a player to play card on");
  }


  public class PlayerTargetButtons extends JButton{
    int choice;
    PlayerTargetButtons(int choice){
      this.choice = choice;
    }
    public int getChoice(){
      return choice;
    }
	}
}

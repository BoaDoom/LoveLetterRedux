package loveLetterGui.subJPanelGui;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gameProcessing.Card;
import gameProcessing.GamePlay;

import loveLetterGui.cardPanels.CardPanelTemplate;

public class TargetSelect extends CardPanelTemplate{
  Card playedCard;
  PlayerTargetButtons noTargetButton;
  ArrayList<PlayerTargetButtons> targetButtons;
  ArrayList<JLabel> playerNames;
  public TargetSelect(GamePlay gamePlay, ActionListener action, ActionListener backButtonAction){
    this.gamePlay = gamePlay;
    targetButtons = new ArrayList<PlayerTargetButtons>();
    playerNames = new ArrayList<JLabel>();

    backButton.addActionListener(backButtonAction);

    noTargetButton = new PlayerTargetButtons(-1);
    noTargetButton.addActionListener(action);
    noTargetButton.setBounds(buttonNextBounds);
    noTargetButton.setText("Discard");
    noTargetButton.setVisible(false);
    noTargetButton.setFont(BUTTON_FONT);

    this.add(dialog0);
    this.add(cardImageCenter);
    this.add(noTargetButton);
    this.add(backButton);
    dialog0.setVisible(true);
    cardImageCenter.setVisible(true);
    noTargetButton.setVisible(true);
    backButton.setVisible(true);

    int split = (panelLength/gamePlay.getPlayerCount());
    for (int i=0; i<gamePlay.getPlayerCount(); i++){    //loop for placing the correct amount of buttons and corisponding playerNames
      PlayerTargetButtons player = new PlayerTargetButtons(i);
      player.addActionListener(action);
      JLabel playerName = new JLabel("Player "+(i+1));
      targetButtons.add(player);
      targetButtons.get(i).setBounds((split*i)+((split/2)-(BUTTON_WIDTH-25)/2), buttonChoice1LocationY, BUTTON_WIDTH-25, BUTTON_HEIGHT);
      playerNames.add(playerName);
      playerNames.get(i).setBounds((split*i)+((split/2)-(BUTTON_WIDTH-25)/2), buttonChoice1LocationY+25, BUTTON_WIDTH-25, BUTTON_HEIGHT);
      this.add(targetButtons.get(i));
      this.add(playerNames.get(i));
    }
    for (int i=0; i<gamePlay.getPlayerCount(); i++){    //loop for placing the correct amount of buttons and corisponding playerNames
      playerNames.get(i).setHorizontalAlignment(SwingConstants.CENTER);
    }
   }
  public void askForTarget(){
  	noTargetButton.setVisible(false);
    targetButtonsOn();
    this.playedCard = gamePlay.getCurrentPlayer().getPlayedCard();
    cardImageCenter.setIcon(playedCard.getImage()); //turns the discarded/selected card that is being used against someone
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
    if (tempCounter >= gamePlay.getPlayerCount()){
      targetButtonsOff();
      dialog0.setText("You have no one to use this card on");
      noTargetButton.setVisible(true);

    }
    else{
      dialog0.setText("Choose a player to play card on");
    }
  }


  public void targetButtonsOff(){
    for (int i=0; i<gamePlay.getPlayerCount(); i++){//sets the button names to show availibility of the targets
      targetButtons.get(i).setVisible(false);
      playerNames.get(i).setVisible(false);
    }
  }
  public void targetButtonsOn(){
    for (int i=0; i<gamePlay.getPlayerCount(); i++){//sets the button names to show availibility of the targets
      targetButtons.get(i).setVisible(true);
      playerNames.get(i).setVisible(true);
    }
  }

  public class PlayerTargetButtons extends JButton{
    int choice;
    PlayerTargetButtons(int choice){
      this.choice = choice;
      this.setFont(BUTTON_FONT);
    }
    public int getChoice(){
      return choice;
    }
	}
}

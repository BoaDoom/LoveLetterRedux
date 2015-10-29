package loveLetterGui.subJPanelGui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameProcessing.GamePlay;

public class PlayCardSelect extends JPanelTemplate{
  GamePlay gamePlay;
  JLabel leftCard;
  JLabel rightCard;
  CardChoiceButtons leftButton;
  CardChoiceButtons rightButton;
  PlayCardSelect(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;
    leftButton = new CardChoiceButtons("Choose", 0);
    rightButton = new CardChoiceButtons("Choose", 1);
  }

  public class CardChoiceButtons extends JButton{
    int choice;
    CardChoiceButtons(String text, int choice){
      this.setText(text);
      this.choice = choice;
    }
    public int getChoice(){
      return choice;
    }
    public void setText(String text){
      this.setText(text);
    }
    public void setCardPictures(){
      
    }

  }
}

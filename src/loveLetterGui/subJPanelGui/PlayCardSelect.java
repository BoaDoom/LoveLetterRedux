package loveLetterGui.subJPanelGui;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
  public PlayCardSelect(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;
    leftButton = new CardChoiceButtons("Choose", 0);
    rightButton = new CardChoiceButtons("Choose", 1);
    leftButton.setBounds(50, (buttonLocationY+50), buttonWidth, buttonHeight);
    rightButton.setBounds(250, (buttonLocationY+50), buttonWidth, buttonHeight);
    leftButton.addActionListener(action);
    rightButton.addActionListener(action);
    this.add(leftButton);
    this.add(rightButton);

    rightCard = new JLabel();
    leftCard = new JLabel();

    this.add(leftCard);
    this.add(rightCard);

    rightCard.setBounds(50,75,118,167);
    leftCard.setBounds(250,75,118,167);
    }
  public void on(){
    rightCard.setIcon(gamePlay.getCurrentHand().get(0).getImage());
    leftCard.setIcon(gamePlay.getCurrentHand().get(1).getImage());
    this.setVisible(true);
  }

  public class CardChoiceButtons extends JButton{
    int choice;
    CardChoiceButtons(String text, int choice){
      this.setDialogText(text);
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

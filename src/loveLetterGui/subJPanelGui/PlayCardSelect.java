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
    dialog = new JLabel("You are forced to discard the Countess");
    dialog.setBounds(125, dialogLocationY+145, dialogWidth, dialogHeight);

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

    this.add(dialog);
    this.add(leftCard);
    this.add(rightCard);

    leftCard.setBounds(50,75,118,167);
    rightCard.setBounds(250,75,118,167);
    }
  public void on(){
    leftButton.choiceEnable();  //turns it back on incase it was disabled previously
    rightButton.choiceEnable(); //turns it back on incase it was disabled previously
    dialog.setVisible(false);   //instruction dialog turned off by default
    leftCard.setIcon(gamePlay.getCurrentHand().get(0).getImage());
    rightCard.setIcon(gamePlay.getCurrentHand().get(1).getImage());
    checkForCountess(); //check to see if it needs you to force a countess play if king or prince are in hand
    this.setVisible(true);
  }
  public void checkForCountess(){
    int card1 = gamePlay.getCurrentHand().get(0).getValue();  //left card
    int card2 = gamePlay.getCurrentHand().get(1).getValue();  //right card
    // if ((card1 == 7)){
    //    leftButton.choiceDisable();   //sets it as disabled
    // }
    // if ((card2 == 7)){
    //    rightButton.choiceDisable();   //sets it as disabled
    // }

    if (card1 == 7 && ((card2 == 5)||(card2 == 6))){ //left card button
      rightButton.choiceDisable();   //sets other card as disabled
      dialog.setVisible(true);
    }
    else if (card2 == 7 && ((card1 == 5)||(card1 == 6))){ //right card button
      leftButton.choiceDisable();   //sets other card as disabled
      dialog.setVisible(true);
    }
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
    public void choiceDisable(){
      this.setEnabled(false);
    }
    public void choiceEnable(){
      this.setEnabled(true);
    }
  }
}

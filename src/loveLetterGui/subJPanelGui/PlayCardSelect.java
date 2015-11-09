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

import loveLetterGui.cardPanels.CardPanelTemplate;

public class PlayCardSelect extends CardPanelTemplate{
  CardChoiceButtons cardButtonChoice1;
  CardChoiceButtons cardButtonChoice2;
  public PlayCardSelect(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;
    dialog3.setText("You are forced to discard the Countess");

    cardButtonChoice1 = new CardChoiceButtons("Choose", 0);
    cardButtonChoice2 = new CardChoiceButtons("Choose", 1);
    cardButtonChoice1.setBounds(buttonChoice1Bounds);
    cardButtonChoice2.setBounds(buttonChoice2Bounds);
    cardButtonChoice1.addActionListener(action);
    cardButtonChoice2.addActionListener(action);
    this.add(cardButtonChoice1);
    this.add(cardButtonChoice2);
    cardButtonChoice1.setVisible(true);
    cardButtonChoice2.setVisible(true);

    this.add(dialog3);
    this.add(cardImage1);
    this.add(cardImage2);
    dialog3.setVisible(true);
    cardImage1.setVisible(true);
    cardImage2.setVisible(true);
    }
  public void on(){
    cardButtonChoice1.choiceEnable();  //turns it back on incase it was disabled previously
    cardButtonChoice2.choiceEnable(); //turns it back on incase it was disabled previously
    dialog3.setVisible(false);   //instruction dialog turned off by default
    cardImage1.setIcon(gamePlay.getCurrentHand().get(0).getImage());
    cardImage2.setIcon(gamePlay.getCurrentHand().get(1).getImage());
    checkForCountess(); //check to see if it needs you to force a countess play if king or prince are in hand
    this.setVisible(true);
  }
  public void checkForCountess(){
    int card1 = gamePlay.getCurrentHand().get(0).getValue();  //left card
    int card2 = gamePlay.getCurrentHand().get(1).getValue();  //right card

    if (card1 == 7 && ((card2 == 5)||(card2 == 6))){ //left card button
      cardButtonChoice2.choiceDisable();   //sets other card as disabled
      dialog3.setVisible(true);
    }
    else if (card2 == 7 && ((card1 == 5)||(card1 == 6))){ //right card button
      cardButtonChoice1.choiceDisable();   //sets other card as disabled
      dialog3.setVisible(true);
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

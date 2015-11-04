package loveLetterGui.cardPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gameProcessing.GamePlay;
import gameProcessing.Player;
import gameProcessing.CardProperties;

public class GuardPanel extends CardPanelTemplate{
  ArrayList<CardGuessButtons> cardOptions;
  GamePlay gamePlay;
  ActionListener listernerToMainGui;
  CardGuessAction cardGuessAction;
  private int targetChoice;
  public GuardPanel(GamePlay gamePlay, ActionListener action){
    nextButton = new JButton();
    dialog = new JLabel();
    listernerToMainGui = action;
    this.gamePlay = gamePlay;

    cardOptions = new ArrayList<CardGuessButtons>();
    cardGuessAction = new CardGuessAction();

    nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);
    nextButton.setText("Next");
    nextButton.setVisible(false);
    this.add(nextButton);

    int split = (panelLength/4);
    int countVar = 0;
    int yCordForButton = 250;
    for(CardProperties card : CardProperties.values()){		    //loop for placing the correct amount of buttons and corisponding card names
      if (countVar == 4){
        yCordForButton = 300;
        countVar = 0;
      }
      CardGuessButtons cardOption = new CardGuessButtons(card.cardValue()-1);
      cardOption.setText(card.cardName());
      cardOption.addActionListener(cardGuessAction);
      cardOption.setBounds((split*countVar)+((split/2)-(buttonWidth-25)/2), yCordForButton, buttonWidth-25, buttonHeight);
      cardOptions.add(cardOption);
      this.add(cardOption);
      countVar++;
    }
    cardOptions.get(0).setEnabled(false); //cannot guess guard as the card
    dialog.setHorizontalAlignment(SwingConstants.CENTER);
    dialog.setBounds(100, dialogLocationY, dialogWidth, dialogHeight);
    dialog.setText("Guess your opponent's card");
    this.add(dialog);
    this.add(nextButton);
  }
  public void action(int targetChoice){
    this.targetChoice = targetChoice;
    nextButtonOff();
    cardOptionsOn();
    dialog.setText("Guess your opponent's card");
    dialog.setText("Player chosen: "+gamePlay.getRosterPlayer(targetChoice).getPlayerNumber()+ ", Card:"+gamePlay.getRosterPlayer(targetChoice).getCard(0).getValue());

  }


  public class CardGuessAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Integer guessedCard = new Integer(((CardGuessButtons) e.getSource()).getChoice()+1); //collects which card was guessed by the buytton pressed
      if (guessedCard == gamePlay.getRosterPlayer(targetChoice).getCard(0).getValue()){ // compares the targetted player's hand with
        dialog.setText("You are correct! Player "+(targetChoice+1)+" is out of the round");
        gamePlay.getRosterPlayer(targetChoice).eliminate();
      }
      else{
        dialog.setText("You guessed incorrectly, your turn is over");
      }
      cardOptionsOff();
      nextButton.setVisible(true);
		}
	}
  public class CardGuessButtons extends JButton{
    int choice;
    CardGuessButtons(int choice){
      this.choice = choice;
    }
    public int getChoice(){
      return choice;
    }
  }
  public void cardOptionsOff(){
    for(int i=0; i<cardOptions.size(); i++){
      cardOptions.get(i).setVisible(false);
    }
  }
  public void cardOptionsOn(){
    for(int i=0; i<cardOptions.size(); i++){
      cardOptions.get(i).setVisible(true);
    }
  }

  public void nextButtonOff(){
    nextButton.setVisible(false);
  }

}

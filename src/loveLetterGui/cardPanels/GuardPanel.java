package loveLetterGui.cardPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Rectangle;

import gameProcessing.GamePlay;
import gameProcessing.Player;
import gameProcessing.CardProperties;

public class GuardPanel extends CardPanelTemplate{
  ArrayList<CardGuessButtons> cardOptions;

  // ActionListener listernerToMainGui;
  CardGuessAction cardGuessAction;
  private int targetChoice;
  public GuardPanel(GamePlay gamePlay, ActionListener action){
    // nextButton = new JButton();
    // dialog = new JLabel();
    // listernerToMainGui = action;
    this.gamePlay = gamePlay;

    cardOptions = new ArrayList<CardGuessButtons>();
    cardGuessAction = new CardGuessAction();
//
    // nextButton.setBounds(150, buttonLocationY, buttonWidth, BUTTON_HEIGHT);
    nextButton.addActionListener(action);
    // nextButton.setText("Next");
    // nextButton.setVisible(false);
    // this.add(nextButton);
    this.add(dialog0);
    this.add(nextButton);

    nextButton.setVisible(true);
    dialog0.setVisible(true);
    nextButton.setVisible(true);

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
      cardOption.setBounds((split*countVar)+(split/2)-((BUTTON_WIDTH-35)/2), yCordForButton, BUTTON_WIDTH-35, BUTTON_HEIGHT);
      cardOptions.add(cardOption);
      this.add(cardOption);
      cardOption.setVisible(true);
      countVar++;
    }
    cardOptions.get(0).setEnabled(false); //cannot guess guard as the card
    // dialog0.setHorizontalAlignment(SwingConstants.CENTER);
    // dialog0.setBounds(100, dialogLocationY, dialogWidth, dialogHeight);
    dialog0.setText("Guess your opponent's card");
  }
  public void action(int targetChoice){
    this.targetChoice = targetChoice;
    nextButtonOff();
    dialog0.setText("Guess your opponent's card");
    cardOptionsOn();
    dialog0.setText("Cheat: Player chosen: "+(gamePlay.getRosterPlayer(targetChoice).getPlayerNumber()+1)+ ", Card:"+gamePlay.getRosterPlayer(targetChoice).getCard(0).getValue());

  }


  public class CardGuessAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Integer guessedCard = new Integer(((CardGuessButtons) e.getSource()).getChoice()+1); //collects which card was guessed by the buytton pressed
      if (guessedCard == gamePlay.getRosterPlayer(targetChoice).getCard(0).getValue()){ // compares the targetted player's hand with
        dialog0.setText("You are correct! Player "+(targetChoice+1)+" is out of the round");
        gamePlay.getRosterPlayer(targetChoice).eliminate();
      }
      else{
        dialog0.setText("You guessed incorrectly, your turn is over");
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

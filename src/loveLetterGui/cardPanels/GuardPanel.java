package loveLetterGui.cardPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gameProcessing.GamePlay;
import gameProcessing.CardProperties;

public class GuardPanel extends CardPanelTemplate{
  ArrayList<JButton> cardOptions;
  GamePlay gamePlay;
  ActionListener listernerToMainGui;
  CardGuessAction cardGuessAction;
  private int targetChoice;
  public GuardPanel(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;
    nextButton = new JButton();
    dialog = new JLabel();
    listernerToMainGui = action;

    cardOptions = new ArrayList<JButton>();
    cardGuessAction = new CardGuessAction();

    nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);
    nextButton.setVisible(false);

    int split = (panelLength/4);
    int countVar = 0;
    int yCordForButton = 250;
    for(CardProperties card : CardProperties.values()){		    //loop for placing the correct amount of buttons and corisponding card names
      if (countVar == 4){
        yCordForButton = 300;
        countVar = 0;
      }
      CardGuessButtons cardOption = new CardGuessButtons(countVar);
      cardOption.setText(card.cardName());
      cardOption.addActionListener(cardGuessAction);
      cardOption.setBounds((split*countVar)+((split/2)-(buttonWidth-25)/2), yCordForButton, buttonWidth-25, buttonHeight);
      cardOptions.add(cardOption);
      this.add(cardOption);
      countVar++;
    }
    dialog.setHorizontalAlignment(SwingConstants.CENTER);
    dialog.setBounds(100, dialogLocationY, dialogWidth, dialogHeight);
    setDialog("Guess your opponent's card");
    this.add(dialog);
  }
  public void action(int targetChoice){
    this.targetChoice = targetChoice;
    nextButtonOff();
    setDialog("Guess your opponent's card");
  }


  public class CardGuessAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Integer guessedCard = new Integer(((CardGuessButtons) e.getSource()).getChoice()); //collects which card was guessed by the buytton pressed
      if (guessedCard == gamePlay.getRosterPlayer(targetChoice).getCard(0).getValue()){ // compares the targetted player's hand with
        setDialog("You guessed correctly! Player "+targetChoice+1+" is out of the round");
        gamePlay.getRosterPlayer(targetChoice).eliminate();
      }
      else{
        setDialog("You guessed incorrectly, your turn is over");
      }
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
  public void nextButtonOff(){
    nextButton.setVisible(false);
  }

}

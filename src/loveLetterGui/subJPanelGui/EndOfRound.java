package loveLetterGui.subJPanelGui;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gameProcessing.GamePlay;
import gameProcessing.Player;
import gameProcessing.Players;

import loveLetterGui.cardPanels.CardPanelTemplate;

public class EndOfRound extends CardPanelTemplate{
  GamePlay gamePlay;
  // JButton nextButton;
  // JLabel dialog2;
  public EndOfRound(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;
    // nextButton = new JButton();
    // nextButton.setText("Next");
    // nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);
    // dialog1 = new JLabel();
    // dialog1.setText("");
    // dialog1.setHorizontalAlignment(SwingConstants.CENTER);
    // dialog1.setBounds(100, dialog1LocationY, dialog1Width, dialog1Height);

    // dialog2 = new JLabel();
    // dialog2.setText("");
    // dialog2.setHorizontalAlignment(SwingConstants.CENTER);
    // dialog2.setBounds(100, (dialog1LocationY+25), dialog1Width, dialog1Height);

    this.add(nextButton);
    this.add(dialog1);
    this.add(dialog2);
    nextButton.setVisible(true);
    dialog1.setVisible(true);
    dialog2.setVisible(true);


  }
  public void endOfRoundAnnouncement(){
    if (!gamePlay.checkForEnoughPlayers()){
      int winner = 0;
      for (int i=0; i<gamePlay.getPlayerCount(); i++){
        if (gamePlay.getRosterPlayer(i).getActive()){
          winner = i;
        }
      }
      gamePlay.scorePoint(winner);
      dialog1.setText("Player " + (winner+1) + ", you win by knockout!");
    }
    else if (!gamePlay.checkForEnoughCards()){
      ArrayList<Player> remainingPlayers = new ArrayList<Player>();
      for (int i=0; i<gamePlay.getPlayerCount(); i++){
        if (gamePlay.getRosterPlayer(i).getActive()){
          remainingPlayers.add(gamePlay.getRosterPlayer(i));
        }
      }
      dialog1.setText(compareCards(remainingPlayers));
    }
  }

  ///////junk about card comparing if the deck runs out
  public String compareCards(ArrayList<Player> remainingPlayers){
    ArrayList<Player> tempList = new ArrayList<Player>();
    ArrayList<Player> tempList2 = new ArrayList<Player>();
    Player winningPlayer;
    tempList.add(remainingPlayers.get(0));
    for (int i=1; i<remainingPlayers.size(); i++){
      if (tempList.get(0).getCard(0).getValue() < remainingPlayers.get(i).getCard(0).getValue()){
        tempList.clear();
        tempList.add(remainingPlayers.get(i));
      }
      else if (tempList.get(0).getCard(0).getValue() == remainingPlayers.get(i).getCard(0).getValue()){
        tempList.add(remainingPlayers.get(i));
      }
    }
    winningPlayer = tempList.get(0);
    if (tempList.size() > 1){
      dialog2.setText("There was a tie, a run off determined the winner");
      tempList2.add(tempList.get(0));
      for (int i=1; i<tempList.size(); i++){
        if (tempList2.get(0).getDiscardPileValue() < tempList.get(i).getDiscardPileValue()){
          tempList2.clear();
          tempList2.add(tempList.get(i));
        }
      }
      winningPlayer = tempList2.get(0);
    }
    if (tempList2.size()> 1){
      dialog2.setText("nobody gets points");
      return "There was a tie, and a tie in the run off";
    }
    else{
      gamePlay.scorePoint(winningPlayer.getPlayerNumber());
      return "Player " + (winningPlayer.getPlayerNumber()+1) + ", you win by highest card!";
    }
  }
  public void on(){
    dialog2.setText("");
	  this.setVisible(true);
	  endOfRoundAnnouncement();
    this.repaint();
  }
}

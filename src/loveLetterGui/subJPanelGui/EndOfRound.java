package loveLetterGui.subJPanelGui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gameProcessing.GamePlay;

public class EndOfRound extends JPanelTemplate{
  GamePlay gamePlay;
  JButton nextButton;
  public EndOfRound(GamePlay gamePlay, ActionListener action){
    this.gamePlay = gamePlay;
    nextButton = new JButton();
    nextButton.setText("Next");
    nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);
    dialog = new JLabel();
    dialog.setText("");
    dialog.setHorizontalAlignment(SwingConstants.CENTER);
    dialog.setBounds(100, dialogLocationY, dialogWidth, dialogHeight);

    this.add(nextButton);
    this.add(dialog);

    endOfRoundAnnouncement();

  }
  public void endOfRoundAnnouncement(){
    if (!gamePlay.checkForEnoughPlayers()){
      dialog.setText("Player " + (gamePlay.getLastWinner().getPlayerNumber()+1) + ", you win by knockout!");
    }
    else if (!gamePlay.checkForEnoughCards()){
      ArrayList<Player> remainingPlayers = new ArrayList<Player>();
      for (int i=0; i<gamePlay.getPlayerCount; i++){
        if (gamePlay.getRosterPlayer(i).getActive){
          remainingPlayers.add(gamePlay.getRosterPlayer(i));
        }
      }
      compareCards(remainingPlayers);

      dialog.setText("Player " + (gamePlay.getLastWinner().getPlayerNumber()+1) + ", you win by highest card!");
    }
  }
  public Player compareCards(ArrayList<Players> remainingPlayers){
    ArrayList<Players> tempList = new ArrayList<Players>;
    Player highCardPlayer;
    highCardPlayer = remainingPlayers.get(0);
    for (int i=1; i<remainingPlayers.size(); i++){
      if (highCardPlayer.getCard(0) < remainingPlayers.get(i).getCard(0)){
        highCardPlayer = remainingPlayers.get(i);
        tempList.clear();
      }
      else if (highCardPlayer.getCard(0) == remainingPlayers.get(i).getCard(0)){
        tempList.add(highCardPlayer);
        tempList.add(remainingPlayers.get(i));
      }
    }

  }
  public void on(){
	  endOfRoundAnnouncement();
	  this.setVisible(true);
  }
}

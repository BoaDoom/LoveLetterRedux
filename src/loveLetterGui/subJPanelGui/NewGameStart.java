package loveLetterGui.subJPanelGui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class NewGameStart extends JPanelTemplate{
  private JButton startGame;
  public NewGameStart(ActionListener action){
    startGame = new JButton();
    startGame.setText("Start Game");
    startGame.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    startGame.addActionListener(action);

    dialogText = new String();
    dialogText = "Press to start a new game";

    dialog = new JLabel();
    dialog.setText(dialogText);
    dialog.setHorizontalAlignment(SwingConstants.CENTER);
    dialog.setBounds(100, dialogLocationY, dialogWidth, dialogHeight);

    this.add(startGame);
    this.add(dialog);
  }

}

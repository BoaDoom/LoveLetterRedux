package loveLetterGui.subJPanelGui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import loveLetterGui.cardPanels.CardPanelTemplate;

public class NewGameStart extends CardPanelTemplate{
  public NewGameStart(ActionListener action){
    this.add(nextButton);
    nextButton.setVisible(true);
    nextButton.setText("Start Game");
    nextButton.addActionListener(action);

    dialog1.setText("Press to start a new game");

    this.add(dialog1);
    dialog1.setVisible(true);
  }

}

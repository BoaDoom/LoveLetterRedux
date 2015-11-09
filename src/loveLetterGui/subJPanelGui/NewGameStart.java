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
    // nextButton = new JButton();
    nextButton.setText("Start Game");
    // nextButton.setBounds(150, buttonLocationY, buttonWidth, buttonHeight);
    nextButton.addActionListener(action);

    // dialog1 = new JLabel();
    dialog1.setText("Press to start a new game");
    // dialog1.setHorizontalAlignment(SwingConstants.CENTER);
    // dialog1.setBounds(100, dialog1LocationY, dialog1Width, dialog1Height);

    this.add(dialog1);
    dialog1.setVisible(true);
  }

}

package loveLetterGui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import loveLetterGui.subJPanelGui.*;

public class guiTesting {
	private JPanel gameBoard;
  private JFrame outterWindow;
  private JTextField dialog;
  private ActionListener doThing;
	public static void main(String[] args) {
    guiTesting test = new guiTesting();
  }
  guiTesting(){
    outterWindow = new JFrame();
    gameBoard = new JPanel();
    dialog = new JTextField("blank");
    doThing = new ChooseButtonAction();


    StartNewGame startNew = new StartNewGame(doThing);
    outterWindow.setBounds(300, 150, 786, 593);
    outterWindow.add(startNew);
    outterWindow.add(gameBoard);
    gameBoard.setLayout(null);
    gameBoard.setBackground(new Color(39,134,39)); //color green
    gameBoard.add(dialog);
    dialog.setBounds(500, 400, 100, 50);
    outterWindow.setVisible(true);
  }
  public void thingToDo(){
    dialog.setText("thing done");
  }
  public class ChooseButtonAction implements ActionListener{	//the choose card button ActionListener
		public void actionPerformed(ActionEvent e) {
			thingToDo();
	  }
  }
}

package loveLetterGui.cardPanels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class CardPanelTemplate extends JPanel{
  public String dialogText;
  public JLabel dialog;
  public JButton nextButton;
  public static int panelHeight = 375;
  public static int panelLength = 420;
  public static int panelLocationX = 170;
  public static int panelLocationY = 193;

  public static int dialogLocationY = 175;
  public static int dialogWidth = 221;
  public static int dialogHeight = 20;

  public static int buttonLocationY = 225;
  public static int buttonWidth = 119;
  public static int buttonHeight = 37;
  CardPanelTemplate(){
    this.setBackground(new Color(39,100,39));
    this.setBounds(panelLocationX, panelLocationY, panelLength, panelHeight);
    this.setLayout(null);
  }

  public void setDialog(String textToSet){
    dialog.setText(textToSet);
  }
  public void on(){
	  this.setVisible(true);
  }
  public void off(){
	  this.setVisible(false);
  }
}

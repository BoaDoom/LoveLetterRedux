package loveLetterGui.subJPanelGui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import loveLetterGui.cardPanels.CardPanelTemplate;

public class JPanelTemplate extends CardPanelTemplate{
  // public JLabel dialog;
  // public static int panelHeight = 375;
  // public static int panelLength = 420;
  // public static int panelLocationX = 170;
  // public static int panelLocationY = 193;
  //
  // public static int dialogLocationY = 175;
  // public static int dialogWidth = 221;
  // public static int dialogHeight = 20;
  //
  // public static int buttonLocationY = 225;
  // public static int buttonWidth = 119;
  // public static int buttonHeight = 37;
  JPanelTemplate(){
  }
  public void on(){
	  this.setVisible(true);
	  this.repaint();
  }
  public void off(){
	  this.setVisible(false);
  }

}

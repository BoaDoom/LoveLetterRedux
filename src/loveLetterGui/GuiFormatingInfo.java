package loveLetterGui;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class GuiFormatingInfo extends JPanel{

	public static final int CARD_LENGTH = 122;
	public static final int CARD_HEIGHT = 166;
	public static final int GAP_ABOVE_CARD = 52;

	public static final int HEIGHT_OF_FONT = 14;

  public static int BUTTON_WIDTH = 119;
  public static int BUTTON_HEIGHT = 37;
	public static int BUTTON_CHOICE_YCORD = 245;

  public static final int panelLocationX = 170;
  public static final int panelLocationY = 193;
  public static final int panelLength = 420;
  public static final int panelHeight = 375;
  Rectangle panelBounds = new Rectangle(panelLocationX, panelLocationY, panelLength, panelHeight);



  public static final int card1Length = CARD_LENGTH;
  public static final int card1Height = CARD_HEIGHT;
  public static final int card1LocationX = (panelLength/4)-((card1Length)/2);
  public static final int card1LocationY = GAP_ABOVE_CARD;
  Rectangle card1Bounds = new Rectangle(card1LocationX, card1LocationY, card1Length, card1Height);

  public static final int card2LocationX = ((panelLength/4)*3)-((card1Length)/2);
  Rectangle card2Bounds = new Rectangle(card2LocationX, card1LocationY, card1Length, card1Height);

  public static final int cardCenterLocationX = (panelLength/2)-((card1Length)/2);
  Rectangle cardCenterBounds = new Rectangle(cardCenterLocationX, card1LocationY, card1Length, card1Height);



	public static final int dialog0Length = panelLength;
	public static final int dialog0Height = HEIGHT_OF_FONT;
	public static final int dialog0LocationX = 0;
	public static final int dialog0LocationY = 62;
  Rectangle dialog0Bounds = new Rectangle(dialog0LocationX, dialog0LocationY, dialog0Length, dialog0Height);

	public static final int dialog1LocationY = (CARD_HEIGHT+GAP_ABOVE_CARD+HEIGHT_OF_FONT*5);
  Rectangle dialog1Bounds = new Rectangle(dialog0LocationX, dialog1LocationY, dialog0Length, dialog0Height);

	public static final int dialog2LocationY = (CARD_HEIGHT+GAP_ABOVE_CARD+(HEIGHT_OF_FONT*6));
  Rectangle dialog2Bounds = new Rectangle(dialog0LocationX, dialog2LocationY, dialog0Length, dialog0Height);

	public static final int dialog3LocationY = (CARD_HEIGHT+GAP_ABOVE_CARD+(HEIGHT_OF_FONT*7));
  Rectangle dialog3Bounds = new Rectangle(dialog0LocationX, dialog3LocationY, dialog0Length, dialog0Height);

	public static final int buttonChoice1Length = BUTTON_WIDTH;
	public static final int buttonChoice1Height = BUTTON_HEIGHT;
	public static final int buttonChoice1LocationX = (panelLength/4)-((buttonChoice1Length)/2);
	public static final int buttonChoice1LocationY = BUTTON_CHOICE_YCORD;
	Rectangle buttonChoice1Bounds = new Rectangle(buttonChoice1LocationX, buttonChoice1LocationY, buttonChoice1Length, buttonChoice1Height);

	public static final int buttonChoice2LocationX = ((panelLength/4)*3)-((buttonChoice1Length)/2);
	Rectangle buttonChoice2Bounds = new Rectangle(buttonChoice2LocationX, buttonChoice1LocationY, buttonChoice1Length, buttonChoice1Height);


	public GuiFormatingInfo() {
	    this.setBackground(new Color(39,100,39));
	    this.setBounds(panelBounds);
	    setLayout(null);

	    JLabel card1 = new JLabel("CARD1");
	    card1.setBounds(card1Bounds);
	    add(card1);

	    JLabel card2 = new JLabel("CARD2");
	    card2.setBounds(card2Bounds);
	    add(card2);

	    JLabel cardCenter = new JLabel("CARDCENTER");
	    cardCenter.setBounds(cardCenterBounds);
	    add(cardCenter);

	    JLabel dialog0 = new JLabel("this is a test for this dialog");
	    dialog0.setBounds(dialog0Bounds);
	    dialog0.setHorizontalAlignment(SwingConstants.CENTER);
	    add(dialog0);

	    JLabel dialog1 = new JLabel("this is a test for this dialog1");
	    dialog1.setHorizontalAlignment(SwingConstants.CENTER);
	    dialog1.setBounds(dialog1Bounds);
	    add(dialog1);

	    JLabel dialog2 = new JLabel("this is a test for this dialog2");
	    dialog2.setHorizontalAlignment(SwingConstants.CENTER);
	    dialog2.setBounds(dialog2Bounds);
	    add(dialog2);

	    JLabel dialog3 = new JLabel("this is a test for this dialog3");
	    dialog3.setHorizontalAlignment(SwingConstants.CENTER);
	    dialog3.setBounds(dialog3Bounds);
	    add(dialog3);

	    JButton buttonChoice1 = new JButton("Choice 1");
	    buttonChoice1.setBounds(buttonChoice1Bounds);
	    add(buttonChoice1);

	    JButton buttonChoice2 = new JButton("Choice 2");
	    buttonChoice2.setBounds(buttonChoice2Bounds);
	    add(buttonChoice2);
	}
}

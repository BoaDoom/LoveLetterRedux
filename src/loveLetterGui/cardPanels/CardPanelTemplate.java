package loveLetterGui.cardPanels;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import gameProcessing.GamePlay;

public class CardPanelTemplate extends JPanel{
  public static final int CARD_LENGTH = 122;
	public static final int CARD_HEIGHT = 166;
	public static final int GAP_ABOVE_CARD = 52;

	public static final int HEIGHT_OF_FONT = 14;

  public static int BUTTON_WIDTH = 119;
  public static int BUTTON_HEIGHT = 37;
	public static int BUTTON_CHOICE_YCORD = 245;

  //main panel properties
  public static final int panelLocationX = 170;
  public static final int panelLocationY = 193;
  public static final int panelLength = 420;
  public static final int panelHeight = 375;
  protected Rectangle panelBounds = new Rectangle(panelLocationX, panelLocationY, panelLength, panelHeight);

  //card image properties
  public static final int cardImage1Length = CARD_LENGTH;
  public static final int cardImage1Height = CARD_HEIGHT;
  public static final int cardImage1LocationX = (panelLength/4)-((cardImage1Length)/2);
  public static final int cardImage1LocationY = GAP_ABOVE_CARD;
  protected Rectangle cardImage1Bounds = new Rectangle(cardImage1LocationX, cardImage1LocationY, cardImage1Length, cardImage1Height);

  public static final int cardImage2LocationX = ((panelLength/4)*3)-((cardImage1Length)/2);
  protected Rectangle cardImage2Bounds = new Rectangle(cardImage2LocationX, cardImage1LocationY, cardImage1Length, cardImage1Height);

  public static final int cardImageCenterLocationX = (panelLength/2)-((cardImage1Length)/2);
  protected Rectangle cardImageCenterBounds = new Rectangle(cardImageCenterLocationX, cardImage1LocationY, cardImage1Length, cardImage1Height);

  //dialog and prompt properties
	public static final int dialog0Length = panelLength;
	public static final int dialog0Height = HEIGHT_OF_FONT;
	public static final int dialog0LocationX = 0;
	public static final int dialog0LocationY = 15;
  protected Rectangle dialog0Bounds = new Rectangle(dialog0LocationX, dialog0LocationY, dialog0Length, dialog0Height);

	public static final int dialog1LocationY = (CARD_HEIGHT+GAP_ABOVE_CARD+HEIGHT_OF_FONT*3);
  protected Rectangle dialog1Bounds = new Rectangle(dialog0LocationX, dialog1LocationY, dialog0Length, dialog0Height);

	public static final int dialog2LocationY = (CARD_HEIGHT+GAP_ABOVE_CARD+(HEIGHT_OF_FONT*4));
  protected Rectangle dialog2Bounds = new Rectangle(dialog0LocationX, dialog2LocationY, dialog0Length, dialog0Height);

	public static final int dialog3LocationY = (CARD_HEIGHT+GAP_ABOVE_CARD+(HEIGHT_OF_FONT*5));
  protected Rectangle dialog3Bounds = new Rectangle(dialog0LocationX, dialog3LocationY, dialog0Length, dialog0Height);

  //button properties
	public static final int buttonChoice1Length = BUTTON_WIDTH;
	public static final int buttonChoice1Height = BUTTON_HEIGHT;
	public static final int buttonChoice1LocationX = (panelLength/4)-((buttonChoice1Length)/2);
	public static final int buttonChoice1LocationY = BUTTON_CHOICE_YCORD;
	protected Rectangle buttonChoice1Bounds = new Rectangle(buttonChoice1LocationX, buttonChoice1LocationY, buttonChoice1Length, buttonChoice1Height);

	public static final int buttonChoice2LocationX = ((panelLength/4)*3)-((buttonChoice1Length)/2);
	protected Rectangle buttonChoice2Bounds = new Rectangle(buttonChoice2LocationX, buttonChoice1LocationY, buttonChoice1Length, buttonChoice1Height);

  public static final int buttonNextLength = BUTTON_WIDTH;
  public static final int buttonNextHeight = BUTTON_HEIGHT;
  public static final int buttonNextLocationX = cardImageCenterLocationX;
  public static final int buttonNextLocationY = (panelHeight-60);
  protected Rectangle buttonNextBounds = new Rectangle(buttonNextLocationX, buttonNextLocationY, buttonNextLength, buttonNextHeight);

  public static final int buttonBackLength = 89;
	public static final int buttonBackHeight = 23;
	public static final int buttonBackLocationX = 10;
	public static final int buttonBackLocationY = (panelHeight-50);
	protected Rectangle buttonBackBounds = new Rectangle(buttonBackLocationX, buttonBackLocationY, buttonBackLength, buttonBackHeight);

  // public GamePlay gamePlay;
  //
  // public JLabel dialog0;
  // public JLabel dialog1;
  // public JLabel dialog2;
  // public JLabel dialog3;
  // public JLabel cardImage1;
  // public JLabel cardImage2;
  // public JLabel cardImageCenter;
  // public JButton cardButton1;
  // public JButton cardButton2;
  // public JButton nextButton;
  // public JButton backButton;
  // public ActionListener action;

  // public static int panelHeight = 375;
  // public static int panelLength = 420;
  // public static int panelLocationX = 170;
  // public static int panelLocationY = 193;
  //
  // public static int dialogLocationY = 175;
  // public static int dialogWidth = 250;
  // public static int dialogHeight = 20;
  //
  // public static int buttonLocationY = 245;
  // public static int buttonWidth = 119;
  // public static int buttonHeight = 37;
    protected GamePlay gamePlay;
    protected int targetChoice;

    protected JLabel cardImage1 = new JLabel();
    protected JLabel cardImage2 = new JLabel();
    protected JLabel cardImageCenter = new JLabel();
    protected JLabel dialog0 = new JLabel();
    protected JLabel dialog1 = new JLabel();
    protected JLabel dialog2 = new JLabel();
    protected JLabel dialog3 = new JLabel();
    protected JButton buttonChoice1 = new JButton();
    protected JButton buttonChoice2 = new JButton();
    protected JButton backButton = new JButton();
    protected JButton nextButton = new JButton();
    public CardPanelTemplate(){
    this.setBackground(new Color(39,100,39));
    this.setBounds(panelBounds);
    setLayout(null);


    cardImage1.setBounds(cardImage1Bounds);
    cardImage2.setBounds(cardImage2Bounds);
    cardImageCenter.setBounds(cardImageCenterBounds);
    dialog0.setBounds(dialog0Bounds);
    dialog1.setBounds(dialog1Bounds);
    dialog2.setBounds(dialog2Bounds);
    dialog3.setBounds(dialog3Bounds);
    buttonChoice1.setBounds(buttonChoice1Bounds);
    buttonChoice2.setBounds(buttonChoice2Bounds);
    backButton.setBounds(buttonBackBounds);
    nextButton.setBounds(buttonNextBounds);

    dialog0.setHorizontalAlignment(SwingConstants.CENTER);
    dialog1.setHorizontalAlignment(SwingConstants.CENTER);
    dialog2.setHorizontalAlignment(SwingConstants.CENTER);
    dialog3.setHorizontalAlignment(SwingConstants.CENTER);

    cardImage1.setVisible(false);
    cardImage2.setVisible(false);
    cardImageCenter.setVisible(false);
    dialog0.setVisible(false);
    dialog1.setVisible(false);
    dialog2.setVisible(false);
    dialog3.setVisible(false);
    buttonChoice1.setVisible(false);
    buttonChoice2.setVisible(false);
    backButton.setVisible(false);
    nextButton.setVisible(false);
    nextButton.setText("Next");
    backButton.setText("Back");

    // this.setBackground(new Color(39,100,39));
    // this.setBounds(panelLocationX, panelLocationY, panelLength, panelHeight);
    // this.setLayout(null);
    // dialog = new JLabel("");
    // dialog.setBounds(125, dialogLocationY+40, dialogWidth, dialogHeight);
    //
    // dialog2 = new JLabel("");
    // dialog2.setBounds(125, dialogLocationY+60, dialogWidth, dialogHeight);
    // dialog3 = new JLabel("");
    // dialog3.setBounds(125, dialogLocationY+80, dialogWidth, dialogHeight);
  }

  //public void setDialog(String textToSet){
    //dialog.setText(textToSet);
  //}
  public void on(){
	  this.setVisible(true);
  }
  public void off(){
	  this.setVisible(false);
  }
}

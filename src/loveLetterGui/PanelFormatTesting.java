package loveLetterGui;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

public class PanelFormatTesting extends JPanel{
	  public static int panelLength = 420;
	  public static int panelHeight = 375;
	  public static int panelLocationX = 170;
	  public static int panelLocationY = 193;
	  
	  Rectangle bounds = new Rectangle(panelLocationX, panelLocationY, panelLength, panelHeight);
	  
	public PanelFormatTesting() {
	    this.setBackground(new Color(39,100,39));
	    this.setBounds(panelLocationX, panelLocationY, panelLength, panelHeight);
	    GridBagLayout gridBagLayout = new GridBagLayout();
	    gridBagLayout.columnWidths = new int[]{0};
	    gridBagLayout.rowHeights = new int[]{0};
	    gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
	    gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
	    setLayout(gridBagLayout);
	}

}

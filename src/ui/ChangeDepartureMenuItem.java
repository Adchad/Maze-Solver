package ui;
import javax.swing.*;

public class ChangeDepartureMenuItem extends JMenuItem{
	private final DrawingApp drawingApp ;
	public ChangeDepartureMenuItem(DrawingApp drawingApp)
	   {
	      super("Change Departure") ; // Text of menu item

	      this.drawingApp = drawingApp ;
	      addActionListener(drawingApp);
	   }
}

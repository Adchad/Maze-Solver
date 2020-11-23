package ui;
import javax.swing.*;

public class ChangeArrivalMenuItem extends JMenuItem{
	private final DrawingApp drawingApp ;
	public ChangeArrivalMenuItem(DrawingApp drawingApp)
	   {
	      super("Change Arrival") ; // Text of menu item

	      this.drawingApp = drawingApp ;
	      addActionListener(drawingApp);
	   }
}

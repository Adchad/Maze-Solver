package ui;
import javax.swing.*;

public class StopMenuItem extends JMenuItem{
	private final DrawingApp drawingApp ;
	public StopMenuItem(DrawingApp drawingApp)
	   {
	      super("Stop") ; // Text of menu item

	      this.drawingApp = drawingApp ;
	      addActionListener(drawingApp);
	   }
}
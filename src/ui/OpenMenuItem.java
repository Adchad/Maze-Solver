package ui;
import javax.swing.*;

public class OpenMenuItem extends JMenuItem{
	private final DrawingApp drawingApp ;
	public OpenMenuItem(DrawingApp drawingApp)
	   {
	      super("Open") ; // Text of menu item

	      this.drawingApp = drawingApp ;
	      addActionListener(drawingApp);
	   }
}

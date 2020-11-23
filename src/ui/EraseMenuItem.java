package ui;
import javax.swing.*;

public class EraseMenuItem extends JMenuItem{
	private final DrawingApp drawingApp ;
	public EraseMenuItem(DrawingApp drawingApp)
	   {
	      super("Erase") ; // Text of menu item

	      this.drawingApp = drawingApp ;
	      addActionListener(drawingApp);
	   }
}

package ui;
import javax.swing.*;

public class NewMenuItem extends JMenuItem{
	private final DrawingApp drawingApp ;
	public NewMenuItem(DrawingApp drawingApp)
	   {
	      super("New") ; // Text of menu item

	      this.drawingApp = drawingApp ;
	      addActionListener(drawingApp);
	   }
}

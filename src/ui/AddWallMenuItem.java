package ui;
import javax.swing.*;

public class AddWallMenuItem extends JMenuItem{

	private final DrawingApp drawingApp ;
	public AddWallMenuItem(DrawingApp drawingApp)
			 {
			   super("Add Wall") ; // Text of menu item

			   this.drawingApp = drawingApp ;
			   addActionListener(drawingApp);
			 }
}	
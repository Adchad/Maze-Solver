package ui;
import javax.swing.*;

public class SolveMenuItem extends JMenuItem{
	private final DrawingApp drawingApp ;
	public SolveMenuItem(DrawingApp drawingApp)
	   {
	      super("Solve") ; // Text of menu item

	      this.drawingApp = drawingApp ;
	      addActionListener(drawingApp);
	   }
}

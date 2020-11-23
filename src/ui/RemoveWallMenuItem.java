package ui;
import javax.swing.*;

public class RemoveWallMenuItem extends JMenuItem{

		private final DrawingApp drawingApp ;
		public RemoveWallMenuItem(DrawingApp drawingApp)
		   {
		      super("Remove Wall") ; // Text of menu item

		      this.drawingApp = drawingApp ;
		      addActionListener(drawingApp);
		   }
}
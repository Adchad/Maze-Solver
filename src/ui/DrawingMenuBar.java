package ui;

import javax.swing.* ;

public class DrawingMenuBar extends JMenuBar
{

	private final ActionsMenu actionsMenu ;
	private final FileMenu fileMenu;
	
	public ActionsMenu getActionsMenu() {
		return actionsMenu;
	}

	public DrawingMenuBar(DrawingApp drawingApp)
	{
		super() ;
		
		// Create and add menus
		add(fileMenu = new FileMenu(drawingApp));
		
		add(actionsMenu = new ActionsMenu(drawingApp)) ;
	}

	public FileMenu getFileMenu() {
		return fileMenu;
	}
}
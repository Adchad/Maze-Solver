package ui;
import javax.swing.*;
public class FileMenu extends JMenu {
	private final OpenMenuItem openMenuItem;
	private final NewMenuItem newMenuItem;
	private final SaveMenuItem saveMenuItem;

	public FileMenu(DrawingApp drawingApp) {
		super("File");
		add(newMenuItem = new NewMenuItem(drawingApp));
		add(openMenuItem = new OpenMenuItem(drawingApp));
		add(saveMenuItem = new SaveMenuItem(drawingApp));
	}

	public OpenMenuItem getOpenMenuItem() {
		return openMenuItem;
	}
	
	public NewMenuItem getNewMenuItem() {
		return newMenuItem;
	}

	public SaveMenuItem getSaveMenuItem() {
		return saveMenuItem;
	}
}

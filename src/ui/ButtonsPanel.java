package ui;
import maze.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.* ;

import Dijkstra.*;


public class ButtonsPanel extends JPanel 
{

	
private Maze maze;

private Dijkstra dijkstra;

private DrawingApp drawingApp;


	public ButtonsPanel(DrawingApp drawingApp, Maze maze,Dijkstra dijkstra) throws IOException
	{
		this.drawingApp = drawingApp;
		this.maze = maze;
		this.dijkstra = dijkstra;
		setVirginLayout();
	
	}
	
	public void setVirginLayout() {
		// method used for every modification applied on the maze 
		
		removeAll();
		
		setLayout(new GridLayout(maze.getMaze().size(),maze.getMaze().get(0).size())) ; 
		
		for (ArrayList<VertexInterface> line : maze.getMaze()) {
			
			for (VertexInterface Box : line) {
				String typeBox= Box.getLabel();
				switch(typeBox) {
				 case "ABox" : add(new ColorIndicator(drawingApp, Color.red , Box.getX(), Box.getY()));
				 break;
				 case "DBox" : add(new ColorIndicator(drawingApp, Color.green, Box.getX(), Box.getY()));
				 break;
				 case "EBox" : add(new ColorIndicator(drawingApp, Color.white, Box.getX(), Box.getY()));
				 break;
				 case "WBox" : add(new ColorIndicator(drawingApp, Color.black, Box.getX(), Box.getY()));
				 break;
				 }
						
			 }
			
		 }
		updateUI();
		
	}

	public void showSolvedMaze() {
		removeAll();
		ArrayList<ArrayList<VertexInterface>> mazeSolved = dijkstra.solvedMaze(maze, maze.getDeparture(), maze.getArrival());
		setLayout(new GridLayout(maze.getMaze().size(),maze.getMaze().get(0).size())) ; 
		
		for (ArrayList<VertexInterface> line : mazeSolved) {
			
			for (VertexInterface Box : line) {
				String typeBox= Box.getLabel();
				switch(typeBox) {
				 case "ABox" : add(new ColorIndicator(drawingApp, Color.red, Box.getX(), Box.getY()));
				 break;
				 case "DBox" : add(new ColorIndicator(drawingApp, Color.green, Box.getX(), Box.getY()));
				 break;
				 case "EBox" : add(new ColorIndicator(drawingApp, Color.white, Box.getX(), Box.getY()));
				 break;
				 case "WBox" : add(new ColorIndicator(drawingApp, Color.black, Box.getX(), Box.getY()));
				 break;
				 }
						
			 }
			
		 }
		updateUI();
		
	}
	
public void setMaze(Maze maze) {
	this.maze = maze;
}


}
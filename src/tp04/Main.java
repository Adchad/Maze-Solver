package tp04;
import java.io.IOException;


import ui.*;

import Dijkstra.*;

import maze.*;
public class Main {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		Maze maze = new Maze();
		maze.initFromTextFile("data/maze.txt");
		new DrawingApp(maze,new Dijkstra());
	}

}
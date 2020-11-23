package maze;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import Dijkstra.GraphInterface;
import Dijkstra.VertexInterface;
public class Maze implements GraphInterface{

	
	private ArrayList<ArrayList<VertexInterface>> maze;
	
	public void setMaze(ArrayList<ArrayList<VertexInterface>> maze) {
		this.maze = maze;
	}

	
	public Maze() {
		super();
		
	}
	
public VertexInterface getBox(int horizontal, int vertical) {
	return maze.get(horizontal).get(vertical);
	
}
public ArrayList<VertexInterface> getAllVertices(){
	ArrayList<VertexInterface> AllVertices = new  ArrayList<VertexInterface>() ;
	for (ArrayList<VertexInterface> Line : maze) {
		for (VertexInterface Box : Line) {
			AllVertices.add(Box);
			}
		}
	return AllVertices;
	}

public final void initFromTextFile(String fileName) throws IOException {
	 maze = new ArrayList<ArrayList<VertexInterface>>() ;
	 BufferedReader textFile  = new BufferedReader(new FileReader(fileName));
	 int i = 0;
	 for (String line = textFile.readLine() ; line != null ; line = textFile.readLine()) {
		 
		 maze.add(new ArrayList<VertexInterface>());
		 for(int j =0 ; j< line.length() ; j++) {
			 char boxtype = line.charAt(j);
			 switch(boxtype) {
			 case 'A' : maze.get(i).add(new ABox(i,j));
			 break;
			 case 'D' : maze.get(i).add(new DBox(i,j));
			 break;
			 case 'E' : maze.get(i).add(new EBox(i,j));
			 break;
			 case 'W' : maze.get(i).add(new WBox(i,j));
			 break;
			 }
					
		 }
		 
		 i=i+1;
		
	 }
	 textFile.close();

}
 public void setEmptyMaze(int x ,int y){
	 //rebuilds a new empty maze
	 ArrayList<ArrayList<VertexInterface>> emptyMaze = new ArrayList<ArrayList<VertexInterface>>() ;
	 for(int i =0 ; i<x ; i++) {
		 emptyMaze.add(new ArrayList<VertexInterface>());
		 for(int j =0 ; j<y ; j++) {
			 emptyMaze.get(i).add(new EBox(i,j));
		 }
	 }
	 this.maze = emptyMaze;
 }

public VertexInterface getArrival() {
	for(ArrayList<VertexInterface> line : maze) {
		for(VertexInterface box : line) {
			if(box.getLabel() == "ABox") {
				return box;
			}
		}
	}
	return null;
}

public VertexInterface getDeparture() {
	for(ArrayList<VertexInterface> line : maze) {
		for(VertexInterface box : line) {
			if(box.getLabel() == "DBox") {
				return box;
			}
		}
	}
	return null;
}

public void setArrival(int x, int y) {
	if(getArrival() == null) {
		maze.get(x).set(y, new ABox(x,y));
		return;
	}
	int xold = getArrival().getX();
	int yold = getArrival().getY();
	//swaps previous arrival with the selected case
	maze.get(xold).set(yold, new EBox(xold,yold));
	maze.get(x).set(y, new ABox(x,y));
	
}

public void setDeparture(int x, int y) {
	if(getDeparture() == null) {
		maze.get(x).set(y, new DBox(x,y));
		return;
	}
	int xold = getDeparture().getX();
	int yold = getDeparture().getY();
	//swaps previous departure with the selected case 
	maze.get(xold).set(yold, new EBox(xold,yold));
	maze.get(x).set(y, new DBox(x,y));
	
}
public void setEBox(int x, int y) {
	maze.get(x).set(y, new EBox(x,y));
}

public void setWBox(int x, int y) {
	maze.get(x).set(y, new WBox(x,y));
}

public final void saveToTextFile(String fileName) throws FileNotFoundException {
	PrintWriter textFile = new PrintWriter(fileName);
	for (ArrayList<VertexInterface> line : maze) {
		
		for (VertexInterface Box : line) {
			String typeBox= Box.getLabel();
			switch(typeBox) {
			case "ABox" : textFile.print("A"); break;
			case "DBox" : textFile.print("D"); break;
			case "EBox" : textFile.print("E"); break;
			case "WBox" : textFile.print("W"); break;
			}
			
		}
		textFile.println();
		
	}
	textFile.close();
}


public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
	
	ArrayList<VertexInterface> list = new ArrayList<VertexInterface>();
	int x =vertex.getX() ;
	int y = vertex.getY();
	if (x!=this.maze.size()-1) {
		if (maze.get(x+1).get(y).getLabel() != "WBox") {
			list.add(maze.get(x+1).get(y));
		}
		
	}
	if (x!=0) {
		if (maze.get(x-1).get(y).getLabel() != "WBox") {
			list.add(maze.get(x-1).get(y));
		}
	
	}
	if (y!=this.maze.get(0).size()-1) {
		if (maze.get(x).get(y+1).getLabel() != "WBox") {
			list.add(maze.get(x).get(y+1));
		}		
	}
	if (y!=0) {
		if (maze.get(x).get(y-1).getLabel() != "WBox") {
			list.add(maze.get(x).get(y-1));
		}
		
	}
	return list ;
}


public int getWeight(VertexInterface src, VertexInterface dst) {

	return 1;
	//all arcs have the same weight of 1
}
public ArrayList<ArrayList<VertexInterface>> getMaze(){
	return maze;
}

public ArrayList<ArrayList<VertexInterface>> deepClone(){
	// we need to copy the maze, but it is a deep ArrayList so we can't use the usual clone() method
	ArrayList<ArrayList<VertexInterface>> mazeClone = new ArrayList<ArrayList<VertexInterface>>();
	int i = 0;
	for (ArrayList<VertexInterface> line : maze) {
		mazeClone.add(new ArrayList<VertexInterface>());
		for (VertexInterface Box : line) {
			mazeClone.get(i).add(Box);
		}
		i++;
	}
	return mazeClone;
}
}

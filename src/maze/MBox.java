package maze;

import Dijkstra.VertexInterface;

public abstract class MBox implements VertexInterface{
	
	private int horizontal;
	private int vertical;
	
	public MBox(int horizontal,int vertical) {
		this.horizontal = horizontal;
		this.vertical = vertical;
	}
	
	public int getX() {
		return horizontal;
	}
	
	public int getY() {
		return vertical;
	}
	
	public String getLabel() {
		return "MBox";
	}
	}
		



package Dijkstra;
import java.util.ArrayList;

public interface PreviousInterface {
	
	public void setValue(VertexInterface x, VertexInterface y);
	
	public VertexInterface getValue(VertexInterface vertex);
	
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex);
}

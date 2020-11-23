package Dijkstra;

import java.util.Iterator;

public interface ASetInterface {

	public boolean add(VertexInterface pivot);
	
	public boolean contains(VertexInterface y);

	public Iterator<VertexInterface> iterator();
	

}

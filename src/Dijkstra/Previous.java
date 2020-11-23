package Dijkstra;
import java.util.ArrayList;
import java.util.Hashtable;

public class Previous extends Hashtable<VertexInterface , VertexInterface> implements PreviousInterface{
// key = premier argument = vecteur interroge	value = deuxieme argument = pere
	private VertexInterface r ;
	
	public Previous(VertexInterface r) {
		this.r = r;
	}
	
	public void setValue(VertexInterface x, VertexInterface y) {
		 super.put(x,y);
		
	}


	public VertexInterface getValue(VertexInterface vertex) {
		return super.get(vertex);
	}

	
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex) {
		VertexInterface pivot = vertex ;
		ArrayList<VertexInterface> path = new ArrayList<VertexInterface>() ;
		
		while (pivot!= r) {
			pivot = this.getValue(pivot);
			path.add(pivot);}
		
		
		return path;
	}

	


}

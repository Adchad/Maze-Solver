package Dijkstra;
import java.lang.Integer;
import java.util.Hashtable;

public class Pi extends Hashtable<VertexInterface,Integer> implements PiInterface  {

	
	public int getValue(VertexInterface v) {
		return super.get(v);
	}

	
	public void setValue(VertexInterface v, int i) {
		Integer piValue = i;
		super.put(v,piValue);
		
	}


}
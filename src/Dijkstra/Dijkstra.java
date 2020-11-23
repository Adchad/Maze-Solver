package Dijkstra;

import java.util.*;
import maze.*;
public class Dijkstra {
	private static PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface previous ) {
		
		a.add(r);
		VertexInterface pivot = r;
		pi.setValue(r,0);
		
		for(VertexInterface x : g.getAllVertices()) {
			if( x.getLabel() != r.getLabel() ) {
				pi.setValue(x,100000000);
			}
		}
			
			
		for(int j = 1 ;j< g.getAllVertices().size(); j++){
			for(VertexInterface y : g.getSuccessors(pivot) ) {
				if( !a.contains(y) ) {
					if( pi.getValue(pivot) + g.getWeight(pivot, y) < pi.getValue(y)) {
						pi.setValue(y, pi.getValue(pivot) + g.getWeight(pivot, y));
						
						previous.setValue(y,pivot);						
					}
				}
			}
			//IL FAUDRAIT METTRE TOUTE CETTE PARTIE DE CODE DANS UNE METHODE EN DEHORS DE LA METHODE PRINCIPALE
			int piMin = 10000;
			VertexInterface min = r; //on prend r parce qu'il faut initialiser min sans l'initialiser
			Iterator<VertexInterface> x = a.iterator();
			while(x.hasNext()) {
				for(VertexInterface y : g.getSuccessors(x.next()) ) {
					if( !a.contains(y) ){
						if (pi.getValue(y)<piMin) {
						min = y ;
						piMin=pi.getValue(y);
						}
					}
				}
			}
			
			pivot = min;
			a.add(pivot);
				}
		
		return previous;
			
	
	}
public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
	Previous previous = new Previous(r);
	Pi pi = new Pi();
	ASet a = new ASet();
	return dijkstra(g,r,a,pi,previous);
	
}

public ArrayList<ArrayList<VertexInterface>> solvedMaze(Maze maze, VertexInterface r, VertexInterface a){
	ArrayList<ArrayList<VertexInterface>> mazeSolved = maze.deepClone();
	PreviousInterface previous = dijkstra(maze,r);
	for (VertexInterface x : previous.getShortestPathTo(a)) {
		mazeSolved.get( x.getX() ).set( x.getY(),new DBox(x.getX(),x.getY()) ) ;
		
	}
	return  mazeSolved;
}
}



		
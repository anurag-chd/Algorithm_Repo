package Geek4Geeks_Graph;

import java.util.ArrayList;

public class DFSAdjacencyList {
	public static void main(String args[]){
		Graph_Adj graph = new Graph_Adj(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		DFS(graph);
		
	}
	
	public static void DFS(Graph_Adj G ){
		
		
	}
}

class Graph_Adj{
	int V;
	int E;
	ArrayList<Edges1> edges;
	
	public Graph_Adj(int v){
		V= v;
		E= 0;
		edges = new ArrayList<Edges1>();
	}
	
	public void addEdge(int src, int des){
		Edges1 e = new Edges1(src,des);
		edges.add(e);
		E++;
	}
	
}

class Edges1{
	int src;
	int des;
	
	

	public  Edges1(int src, int des){
		this.src = src;
		this.des = des;
	}

}

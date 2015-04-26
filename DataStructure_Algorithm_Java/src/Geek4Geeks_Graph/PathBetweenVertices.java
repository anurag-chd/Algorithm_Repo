package Geek4Geeks_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PathBetweenVertices {
	
	public static void main(String args[]){
		Graph G = new Graph(4);
		G.addEdge(0, 1);
		G.addEdge(0, 2);
		G.addEdge(1, 2);
		G.addEdge(2, 0);
		G.addEdge(2, 3);
		G.addEdge(3, 3);
		
		System.out.println("Is There path between 0 and 3");
		System.out.println(G.isReachable(0, 3));
		
		System.out.println("Is There path between 0 and 3");
		System.out.println(G.isReachable(3,0));
	}
	
}


class Graph {
	int V;
	boolean [][] adjList;
	
	public Graph(int v){
		V = v;
		adjList = new boolean[v][v];
		for(int i = 0; i<v; i++){
			for(int j = 0; j < v; j++){
				adjList[i][j] = false; 
			}
		}
	}
	
	public void addEdge(int a, int b){
		adjList[a][b] = true;
	}
	
	public boolean isReachable(int s, int d){
		boolean visited[] = new boolean [V];
		for(int i =0; i <V; i++){
			visited[i] = false;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		while(!queue.isEmpty()){
			int temp = queue.poll();
			for(int i = 0; i< V ; i++){
				if(visited[i] == false && adjList[temp][i] == true){
					if( i == d)
						return true;
					else{
						queue.add(i);
						visited[i] = true;
					}
				}
				
			}
		}
		
		return false;
	}
	
	
	
	
}
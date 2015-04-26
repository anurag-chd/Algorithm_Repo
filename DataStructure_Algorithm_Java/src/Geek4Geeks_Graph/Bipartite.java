package Geek4Geeks_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
	public static void main(String args[]){
		Graph G = new Graph(4);
		G.addEdge(0, 1);
		G.addEdge(0, 2);
		G.addEdge(1, 2);
		G.addEdge(2, 0);
		G.addEdge(2, 3);
		G.addEdge(3, 3);
		
		System.out.println("Is the graph G Bipartite");
		System.out.println(isBipartite(G));

	}
	
	public static boolean isBipartite(Graph G){
		boolean result = true;
		char color[] = new char[G.V];
		for(int i = 0; i< color.length ;i++){
			color[i] = 'w';
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		color[0] = 'b';
		while(!queue.isEmpty()){
			int temp =  queue.poll(); 
			for(int i =0 ; i< color.length ;i++){
				if(G.adjList[temp][i] == true){
					if(color[i] == 'w'){
						color[i] = color[temp] == 'b' ?'r':'b';
						queue.add(i);
					}
					else{
						if(color[i] == color[temp]){
							result = false;
							return result;
						}
					}
				}
			}
		}
		return result;
	}
}

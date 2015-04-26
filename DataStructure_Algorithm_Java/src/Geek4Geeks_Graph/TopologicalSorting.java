package Geek4Geeks_Graph;

import java.util.Stack;

public class TopologicalSorting {
	public static void main(String args[]){
		Graph g = new Graph(6);
		g.addEdge(5, 0);
		g.addEdge(5, 2);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		
		sort(g);
	}
	
	public static void sort(Graph g){
		int vertex = g.V;
		boolean visited[] = new boolean[vertex];
		for(int i =0 ; i< vertex ;i++)
			visited[i] = false;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i =0 ; i< vertex ;i++){
			if(!visited[i])
				topSort(i,g,visited,stack);
		}
		
		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}
	
	public static void topSort(int start, Graph g , boolean visited[], Stack<Integer> stack){
		visited[start] = true;
		for(int i =0; i< g.V; i++){
			if(visited[i] == false && g.adjList[start][i] == true)
				topSort(i,g,visited,stack);
		}
		stack.push(start);
	}

}

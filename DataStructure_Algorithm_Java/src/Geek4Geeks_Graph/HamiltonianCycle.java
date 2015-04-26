package Geek4Geeks_Graph;

public class HamiltonianCycle {
	public static void main(String args[]){
		int	graph1[][] = 		{{0, 1, 0, 1, 0},
                				{1, 0, 1, 1, 1},
                				{0, 1, 0, 0, 1},
                				{1, 1, 0, 0, 1},
                				{0, 1, 1, 1, 0},
               					};
		int path[] = new int [graph1.length];
		int len = graph1.length;
		for(int i =0 ;i < len ;i++)
			path[i] = -1;
		path[0] = 0;
		
		System.out.println("Is the Graph G1 hamiltonian ?");
		System.out.println(isHamiltonian(graph1));
	}
	public static boolean isHamiltonian(int graph[][]){
		int path[] = new int [graph.length];
		int len = graph.length;
		for(int i =0 ;i < len ;i++)
			path[i] = -1;
		path[0] = 0;
		
		if(!hamilCycle(graph,path,1)){
			System.out.println("The graph has no hamiltonian cycle");
			return false;
		}
		else{
			System.out.println("Hamiltonian path");
			for(int i =0 ; i< len ;i++)
				System.out.print(path[i]);
			System.out.println();
			return true;
		}
	}
	
	public static boolean hamilCycle(int graph[][], int path[], int pos){
		if(pos == graph.length){
			if(graph[path[pos-1]][0] == 1)
				return true;
			else
				return true;
		}
		for(int i = 1 ; i < graph.length;i++){
			if(isSafe(graph,i,path,pos)){
				path[pos] = i;
				if(hamilCycle(graph,path,pos+1))
					return true;
				path[pos] = -1;
			}
		}
		return false;
	}
	
	public static boolean isSafe(int graph[][], int vertex, int path[], int pos){
		if(graph[path[pos-1]][vertex] == 0){
			return false;
		}
		for(int i = 0; i< pos; i++){
			if(path[i] == vertex)
				return false;
		}
		return true;
	}
}

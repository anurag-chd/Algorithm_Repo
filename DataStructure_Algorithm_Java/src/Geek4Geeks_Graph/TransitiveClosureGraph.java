package Geek4Geeks_Graph;

public class TransitiveClosureGraph {

	public static void main(String args[]){
		Graph G = new Graph(4);
		G.addEdge(0, 1);
		G.addEdge(0, 3);
		G.addEdge(1, 2);
		G.addEdge(2, 3);
		
		
		transitiveClosure(G);
	}
	
	public static void transitiveClosure(Graph G){
		int vertices = G.V;
		boolean reach[][] = new boolean[vertices][vertices];
		
		for(int i =0 ; i< vertices ;i++){
			for(int j =0; j< vertices ;j++){
				if(i == j)
					reach[i][j] = true;
				else
					reach[i][j] = G.adjList[i][j];
			}
		}
		
		for(int i =0 ; i <vertices ; i++){
			for(int j = 0; j<vertices ;j++){
				for(int k = 0; k<vertices ;k++){
					reach[i][j] = reach[i][j] || (reach[i][k] && reach[k][j]);
					if(reach[i][j] == true){
						break;
					}
						
				}
			}
		}
		
		printReachabilityMatrix(G.adjList);
		System.out.println();
		printReachabilityMatrix(reach);
	}
	
	public static void printReachabilityMatrix(boolean reach[][]){
		for(int i = 0; i< reach.length ;i++){
			for(int j = 0 ; j< reach[0].length ; j++){
				int res = reach[i][j] == true?1:0;
				System.out.print(res + " ");
			}
				
			System.out.println();
		}
	}
}

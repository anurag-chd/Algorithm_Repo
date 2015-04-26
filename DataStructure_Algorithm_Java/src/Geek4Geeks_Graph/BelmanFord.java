package Geek4Geeks_Graph;

public class BelmanFord {
	public static final int INF = 1000000000;
	public static void main(String args[]){
		Graph_Weight graph = new Graph_Weight(5);
		graph.addEdge(0,1,-1);
		graph.addEdge(0,2,4);
		graph.addEdge(1,2,3);
		graph.addEdge(1,3,2);
		graph.addEdge(1,4,2);
		graph.addEdge(3,2,5);
		graph.addEdge(3,1,1);
		graph.addEdge(4,3,-3);
		
		findPath(graph,0);
	}
	
	
	public static void findPath(Graph_Weight graph, int start){
		int v = graph.V;
		int dist[] = new int[v];
		
		for(int i =0 ; i< v ;i++){
			dist[i] = INF;
		}
		dist[start] = 0;
		// to calculate the minimum path
		for(int i =1; i<v;i++){
			for(Edges e : graph.edges){
				int s = e.src;
				int t = e.des;
				int weight = e.w;
				if(dist[t] > dist[s] + weight){
					dist[t] = dist[s] + weight;
				}
			}
		}
		
		// to check the presence of negative cycle
		
		for(Edges e : graph.edges){
			int s = e.src;
			int t = e.des;
			int weight = e.w;
			if(dist[t] > dist[s] + weight){
				System.out.println("The graph contains negative cycle");
				return;
			}
		}
		
		printArr(dist);
	}
	
	public static void printArr(int [] arr){
		for(int i = 0; i< arr.length ;i++)
			System.out.print(arr[i] + " ,");
	}
	
}

package Geek4Geeks_Graph;

public class Dijkstra {
	public static final int INF = 100000000;
	public static void main(String args[]){
		int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                		 {4, 0, 8, 0, 0, 0, 0, 11, 0},
                		 {0, 8, 0, 7, 0, 4, 0, 0, 2},
                		 {0, 0, 7, 0, 9, 14, 0, 0, 0},
                		 {0, 0, 0, 9, 0, 10, 0, 0, 0},
                		 {0, 0, 4, 0, 10, 0, 2, 0, 0},
                		 {0, 0, 0, 14, 0, 2, 0, 1, 6},
                		 {8, 11, 0, 0, 0, 0, 1, 0, 7},
                		 {0, 0, 2, 0, 0, 0, 6, 7, 0}
               			};
		
		findPath(graph,0);
	}
	
	public static void findPath(int graph[][], int start){
		int len = graph.length;
		int dist[] = new int[len];
		boolean visited[] = new boolean[len];
		for(int i = 0; i< len ;i++){
			dist[i] = INF;
			visited[i] = false;
		}
		int count = 1;
		dist[start] = 0;
		int distance  = 0;
		visited[start] = true;
		while(count < len){
			for(int i = 0; i<len ;i++){
				if(visited[i] == false && graph[start][i] != 0 && (distance + graph[start][i])<dist[i]){
					dist[i] = distance + graph[start][i];
				}
			}
			start = findMin(dist,visited);
			distance = dist[start];
			visited[start] = true;
			count++;
		}
		for(int i = 0;i<len ;i++){
			System.out.print(dist[i]+" ,");
		}
	}
	
	public static int findMin(int [] dist, boolean [] visited){
		int min = INF;
		int result = 0;
		for(int i =0 ;i< dist.length ;i++){
			if(visited[i] == false && min>dist[i]){
				min=dist[i];
				result = i;
			}
		}
		return result;
	}
}

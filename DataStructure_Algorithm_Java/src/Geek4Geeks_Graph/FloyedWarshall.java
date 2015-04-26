package Geek4Geeks_Graph;
 
public class FloyedWarshall {
	public static final int INF = 10000000;
	public static void main(String args[]){
		int graph[][] = { {0,   5,  INF, 10},
                		  {INF,  0,  3,  INF},
                		  {INF, INF, 0,   1},
                		  {INF, INF, INF, 0} };
		minDistance(graph);
	}
	public static void minDistance(int graph[][]){
		int result [][] = new int[graph.length][graph[0].length];
		int len = graph.length;
		for(int i =0 ; i< len ;i++){
			for(int j = 0; j< len ; j++){
				result[i][j] = graph[i][j];
			}
		}
		
		for(int k =0 ; k< len ; k++){
			for(int i =0 ; i< len ;i++){
				for(int j =0 ; j< len ;j++){
					result[i][j] = Math.min(result[i][j],(result[i][k]+result[k][j]));
				}
			}
		}
		
		printMatrix(result);
		
		
	}
	
	public static void printMatrix(int arr[][]){
		for(int i =0; i< arr.length ;i++){
			for(int j =0 ;j< arr[0].length ;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}
}

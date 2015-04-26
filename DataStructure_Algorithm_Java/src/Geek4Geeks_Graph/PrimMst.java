package Geek4Geeks_Graph;

public class PrimMst {
	static final int INF = 1000000000;
	public static void main(String args[]){
		int graph[][] = {{0, 2, 0, 6, 0},
                  		 {2, 0, 3, 8, 5},
                  		 {0, 3, 0, 0, 7},
                  		 {6, 8, 0, 0, 9},
                  		 {0, 5, 7, 9, 0},
               			};
		
		findMst(graph);
		
	}
	
	public static void findMst(int graph[][]){
		int count =1;
		int vert = graph.length;
		boolean visited[] = new boolean [vert];
		int key[] = new int[vert];
		int parent[] = new int[vert];
		int mst[][] = new int[vert][vert];
		for(int i = 0 ; i< vert ;i++){
			for(int j =0 ; j< vert ;j++){
				mst[i][j] = 0;
			}
		}
		for(int i =0 ; i< vert ; i++){
			visited[i] = false;
			key[i] = INF;
			parent[i] = -1;
		}
		visited[0] = true;
		key[0] = 0;
		parent[0] =0;
		int start = 0;
		while(count < vert){
			for(int i = 0; i< vert ;i++){
				if(visited[i] == false){
					if(graph[start][i] !=0 && graph[start][i] <= key[i]){
						key[i] = graph[start][i];
						parent[i] = start;
					}
				}
			}
			start = findMin(key,visited);
			visited[start] = true;
			mst[parent[start]][start] = key[start];
			count++;
		}
		System.out.println("The graph is :");
		for(int i =0 ; i< vert;i++){
			for(int j =0 ; j<vert ;j++){
				System.out.print(graph[i][j]+" ,");
			}
			System.out.println();
		}
		System.out.println("The mst is :");
		for(int i =0 ; i< vert;i++){
			for(int j =0 ; j<vert ;j++){
				System.out.print(mst[i][j]+" ,");
			}
			System.out.println();
		}
		System.out.println("The parent group is :");
		for(int i =0 ;i< vert; i++){
			System.out.print(parent[i]+" ,");
		}
		
		
	}
	
	public static int findMin(int [] key , boolean visited[]){
		int min = INF;
		int result = 0; 
		for(int i = 0 ; i < key.length ;i++){
			if(!visited[i]){
				if(min>key[i]){
					min = key[i];
					result = i;
				}
			}
		}
		return result;
	}
	
}

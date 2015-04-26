package Geek4Geeks_Dynamic;

public class MinCostPath {
	public static void main(String args[]){
		int cost[][] = 	{ 	{1, 8, 3},
                			{4, 1, 2},
                			{1, 5, 3} };
		System.out.println(minCost(cost,0,2));
	}
	
	public static int minCost(int cost[][], int m , int n){
		int min_cost[][] = new int[m][n];
		
		min_cost[0][0] = cost[0][0];
		for(int i =1; i<m ;i++){
			min_cost[i][0] = cost[i][0] + min_cost[i-1][0]; 
		}
		for(int j =1; j<n ;j++){
			min_cost[0][j] = cost[0][j] + min_cost[0][j-1];
		}
		
		for(int i =1; i<m ;i++){
			for(int j =1; j<n ;j++){
				min_cost[i][j] = cost[i][j] + min(min_cost[i-1][j-1],min_cost[i][j-1],min_cost[i-1][j]);
			}
		}
		
		return min_cost[m-1][n-1];
 	}
	
	public static int min(int a, int b, int c){
		if(a<=b)
			return a<=c?a:c;
		else
			return b<=c?b:c;
		
	}
}

package Vmware;

public class Knapsack {
	public static void main(String args[]){
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
	    findmax(val,wt,W,val.length);
	}
	
	public static void findmax(int val[], int wt[], int W, int n){
		int matrix[][] = new int[n+1][W+1];
		for(int i = 0;i<=n;i++){
			for(int j =0; j <= W ; j++){
				if(i ==0 || j ==0)
					matrix[i][j] = 0;
				else{
					if(wt[i-1]>j){
						matrix[i][j] = matrix[i-1][j];
					}
					else{
						matrix[i][j] = Math.max((val[i-1] + matrix[i-1][j-wt[i-1]]),matrix[i-1][j] );
					}
				}
			}
		}
		System.out.println(matrix[n][W]);
	}
	
}

package LeetCode;

public class UniquePath2 {
	public static void main(String args[]){
		int obstacleGrid[][] =	{{0,0},
								 {1,1},
								 {0,0}	
								};
		
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int arr[][] = new int[m][n];
		arr[0][0] = 1;
        for(int i =1; i< arr.length ;i++){
		    arr[i][0] = obstacleGrid[i][0] !=1?arr[i-1][0]:0;
		   
		}
		for(int i =1; i< arr[0].length ;i++)
			 arr[0][i] = obstacleGrid[0][i] !=1?arr[0][i-1]:0;
		
		
		
		for(int i = 1; i< arr.length;i++){
			for(int j = 1; j< arr[0].length; j++){
				arr[i][j] = obstacleGrid[i][j] !=1?arr[i-1][j] + arr[i][j-1]:0;
			}
		}
		return arr[m-1][n-1];
        
    }
	
}

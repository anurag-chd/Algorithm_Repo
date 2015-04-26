package LeetCode;

public class MinPathSum {
	public static void main (String args[]){
		int grid[][] ={{1,3,1},
					   {1,5,1},
					   {4,2,1}		
					  };
		System.out.println(minPathSum(grid));
	}
	
	 public static int minPathSum(int[][] grid) {
	        int arr[][] = new int[grid.length][grid[0].length];
	        arr[0][0] = grid[0][0];
			for(int i =1; i< arr.length ;i++)
				arr[i][0] = grid[i-1][0] + grid[i][0];
			
			for(int j = 1; j< arr[0].length;j++)
				arr[0][j] = grid[0][j-1] + grid[0][j];
			
			for(int i = 1; i< arr.length;i++){
				for(int j = 1; j< arr[0].length; j++){
					arr[i][j] = grid[i][j] + Math.min(arr[i-1][j],arr[i][j-1]);
				}
			}
			printGrid(arr);
			return arr[grid.length-1][grid[0].length-1];
	        
	    }
	 public static void printGrid(int arr[][]){
		 for(int i =0; i< arr.length;i++){
			 for(int j =0; j< arr[0].length;j++){
				 System.out.print(arr[i][j]+" ,");
			 }
			 System.out.println();
		 }
	 }
}

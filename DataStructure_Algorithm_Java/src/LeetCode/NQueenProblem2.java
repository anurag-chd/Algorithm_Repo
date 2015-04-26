package LeetCode;

public class NQueenProblem2 {
	public static int res = 0;
	public static void main(String args[]){
		int n = 5;
		System.out.println(totalNQueens(n));
	}
	
	public static int totalNQueens(int n) {
        if(n == 1)
            return 1;
        if(n < 3)
            return 0;
        boolean arr[][] = new boolean[n][n];
		int result[] = new int[n];
		populateQueens(n,arr,0,result);
		return res;
	}
	
	public static void populateQueens(int n,boolean arr[][], int rowIndex , int result[]){
		if(rowIndex == n){
			res++;
			return;
		}
		for(int col =0; col< arr.length;col++){
			arr[rowIndex][col] = true;
			if(correctPos(arr,rowIndex,col)){
				result[rowIndex] = col;
				populateQueens(n,arr,rowIndex+1,result);
			}
			arr[rowIndex][col] = false;
		}
	}
	
	
	public static boolean correctPos(boolean arr[][] , int row, int col){
		if(row == 0)
			return true;
		for(int i = row-1;i >=0 ;i--){
			if(arr[i][col])
				return false;
		}
		
		int i = row -1;
		int j = col -1;
		while(i>=0 && j >=0){
			if(arr[i][j])
				return false;
			i--;
			j--;
		}
		
		i = row -1;
		j = col+1;
		
		while(i>=0  && j <arr.length){
			if(arr[i][j])
				return false;
			i--;
			j++;
		}
		
		return true;

        
    }
}

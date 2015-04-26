package LeetCode;

public class UniquePaths {
	public static void main(String args[]){
		int m = 4;
		int n = 4;
		System.out.println(uniquePaths(m,n));
	}
	
	public static int uniquePaths(int m , int n){
		int arr[][] = new int[m][n];
		for(int i =0; i< arr.length ;i++)
			arr[i][0] = 1;
		
		for(int j = 0; j< arr[0].length;j++)
			arr[0][j] = 1;
		
		for(int i = 1; i< arr.length;i++){
			for(int j = 1; j< arr[0].length; j++){
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
		return arr[m-1][n-1];
	}
}

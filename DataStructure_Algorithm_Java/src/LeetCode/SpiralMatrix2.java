package LeetCode;

public class SpiralMatrix2 {
	public static void main(String args[]){
		int n = 3;
		int mat[][] = generateMatrix(n);
		printMatrix(mat);
	}
	
	public static void printMatrix(int arr[][]){
		for(int i =0; i< arr.length ; i++){
			for(int j =0; j< arr[0].length ; j++){
				System.out.print(arr[i][j]+" ,");
			}
			System.out.println();
		}
	}
	
	public static int[][] generateMatrix(int n){
		int arr[][] = new int[n][n];
		int rowLen = arr.length;
		int colLen = arr[0].length;
		int layer = 0;
		int i ,j;
		int count =1;
		while(layer <= (arr.length-1)/2){
			i = layer;
			for(j = layer;j<= colLen - layer-1;j++)
				arr[i][j] = count++;
			
			j = colLen -layer-1;
			for(i = layer+1; i<rowLen-layer-1 ;i++)
				arr[i][j] = count++;
			
			i = rowLen -layer -1;
			for(j = colLen-layer-1; j>layer ;j--)
				arr[i][j] = count++;
			
			j = layer;
			for(i = rowLen-layer-1; i> layer;i--)
				arr[i][j] = count++;
			
			
			layer++;
		}
		
		return arr;
	}
	
}

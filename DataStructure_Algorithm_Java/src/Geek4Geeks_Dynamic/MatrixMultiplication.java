package Geek4Geeks_Dynamic;

public class MatrixMultiplication {
	public static void main(String args[]){
		int arr[] = {1, 2, 3, 4};
		int size = arr.length;
		System.out.println("Minimum number of multiplications" 
				+ matrixChainOrder(arr,size));
	}
	
	public static int matrixChainOrder(int arr[] , int size){
		int result_matrix [][] = new int[size][size];
		int n = size;
		// initialize the same number position matrix to zero
		for(int i = 0; i<size; i++){
			result_matrix[i][i] = 0;
		}
		int max = 99999999;
		
		for(int l = 1; l < n-1; l++){
			for(int i = 1; i < n-l; i++){
				int j = i + l;
				result_matrix[i][j] = max;
				
				for(int k = i; k < j ;k++){
					int q = result_matrix[i][k] + result_matrix[k+1][j] +
							(arr[i-1] * arr[k+1] * arr[j]);
					if(q < result_matrix[i][j]){
						result_matrix[i][j] = q;
					}
				}
			}
		}
		for(int i =0; i<n ;i++){
			for(int j =0 ; j<n ;j++){
				System.out.print(result_matrix[i][j]+" ");
					
			}
			System.out.println();
		}
	
		
		return result_matrix[1][n-1];
	}

}

package ProgrammeCreek.String_Array_Matrix;

public class RotateImage {
	public static void main(String args[]){
		int matrix[][] = {{1,2,3,4},
						  {5,6,7,8},
						  {9,10,11,12},
						  {13,14,15,16}};
		rotateMatrix(matrix);
		printMatrix(matrix);
						  
		
	}
	
	public static void rotateMatrix(int[][]matrix){
		if (matrix == null)
			return;
		int len = matrix.length;
		for(int layer = 0 ; layer <len/2 ;layer++){
			int first = layer;
			int last = len -1- layer;
			for(int i = first; i< last ; i++){
				int offset = i -first;
				int top = matrix[first][i];
				
				matrix[first][i] = matrix[last-offset][first];
				
				matrix[last-offset][first] = matrix[last][last-offset];
				
				matrix[last][last-offset] = matrix[first+offset][last];
				
				matrix[first + offset][last] = top;
			}
		}
	}
	
	public static void printMatrix(int matrix[][]){
		for(int i =0; i< matrix.length;i++){
			for(int j = 0; j< matrix[0].length;j++){
				System.out.print(matrix[i][j]+" ,");
			}
			System.out.println();
		}
	}
}

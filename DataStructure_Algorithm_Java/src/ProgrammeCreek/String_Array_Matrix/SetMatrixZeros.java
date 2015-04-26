package ProgrammeCreek.String_Array_Matrix;

public class SetMatrixZeros {
	public static void main(String args[]){
		int [][] matrix = {{1,0,1},
						   {0,1,1},
						   {1,1,1}};
		setZeros(matrix);
		printMatrix(matrix);
		
	}
	
	public static void printMatrix(int [][] matrix){
		for(int i =0; i< matrix.length ;i++){
			for(int j =0; j< matrix[0].length; j++){
				System.out.print(matrix[i][j]+" ,");
			}
			System.out.println();
		}
	}
	
	public static void setZeros(int [][] matrix){
		boolean rowFlag = false , colFlag = false;
		// check the first row and col to assign value to row, col flags
		for(int i = 0; i< matrix.length ;i++){
			if(matrix[i][0] == 0){
				colFlag = true;
				break;
			}
		}
		for(int j =0; j < matrix[0].length ; j++){
			if(matrix[0][j] == 0){
				rowFlag = true;
				break;
			}
		}
		
		// check the inner matrix and make the first row and col to 0
		for(int i = 1; i< matrix.length ; i++){
			for(int j =1; j< matrix[0].length ; j++){
				if(matrix[i][j] == 0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		// make the inner matrix zero if first row or col is zero
		for(int i = 1; i< matrix.length ; i++){
			for(int j =1; j< matrix[0].length ; j++){
				if(matrix[i][0] == 0 || matrix[0][j] == 0){
					matrix[i][j] = 0;
				}
			}
		}
		
		// assign the first row as zero if rowflag is set
		if(rowFlag){
			for(int i =0; i<matrix[0].length ; i++)
				matrix[0][i] = 0;
		}
		
		// assign the first col as zero if colFlag is set
		if(colFlag){
			for(int i =0; i< matrix.length ; i++)
				matrix[i][0] = 0;
		}
	}
	
	
	

}

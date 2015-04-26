package ProgrammeCreek.String_Array_Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void main(String args[]){
		/*int matrix[][] = {{1,2,3,4,5},
						  {6,7,8,9,10},
						  {11,12,13,14,15}};*/
		int matrix[][] = {{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};
		List<Integer> list = spiralOrder(matrix);
		System.out.println(list);
	}
	
	public static List<Integer> spiralOrder(int [][]matrix){
		ArrayList<Integer> list = new ArrayList<>(); 
		if(matrix == null || matrix.length == 0 || matrix[0].length ==0){
			return list;
		}
		getSpiralOrder(matrix,list,0,matrix.length-1,0,matrix[0].length-1);
		return list;
	}
	
	public static void getSpiralOrder(int [][]matrix, ArrayList<Integer> list,int row_start,
													int row_end,int col_start, int col_end){
		if(row_start > row_end || col_start>col_end){
			return;
		}
		int row = row_start;
		int col = col_start;
		
		if(row_start == row_end){
			while(col<=col_end)
				list.add(matrix[row][col++]);
			return;
		}
		if(col_start == col_end){
			while(row<=row_end)
				list.add(matrix[row++][col]);
			return;
		}
		
		//add first row 
		while(col <= col_end){
			list.add(matrix[row][col++]);
		}
		// add last column
		row++;col--;
		while(row<=row_end){
			list.add(matrix[row++][col]);
		}
		// add last row
		row--;col--;
		while(col>=col_start){
			list.add(matrix[row][col--]);
		}
		// add first column
		row--;col++;
		while(row>=row_start+1){
			list.add(matrix[row--][col]);
		}
		getSpiralOrder(matrix,list,++row_start,--row_end,++col_start,--col_end);
		
	}

}

package Geek4Geeks_Arrays;

public class InsertXO {
	
	public static void main(String args[]){
		fillXO(5,5);
		
	}
		
	public static void fillXO(int m, int n){
		int itr, start_row, start_col, end_row, end_col;
		start_row =0;
		start_col = 0;
		end_row = m;
		end_col = n;
		char arr[][] = new char[m][n];
		char c = 'X';
		while(start_row < end_row && start_col < end_row){
			
			for(itr =start_col ; itr < end_col ;itr++){
				arr[start_row][itr] = c;
			}
			start_row++;
			
			for(itr = start_row ;itr<end_row;itr++){
				arr[itr][end_col - 1] = c;
			}
			end_col--;
			
			if(start_row < end_row){
				for(itr = end_col;itr >=start_col;itr--){
					arr[end_row-1][itr] = c;
				}
				end_row--;
			}
			
			if(start_col<end_col){
				for(itr = end_row ; itr>=start_row;itr--){
					arr[itr][start_col] = c;
				}
				start_col++;
			}
						
			c =(c == 'X')?'O':'X';
			
		}
		
		
		for(int i =0; i < m ;i++){
			for(int j =0;j<n;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}

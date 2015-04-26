package Vmware;

public class KnightShortest {
	public static void main(String args[]){
		int start_x= 2,start_y = 2, end_x = 5 , end_y = 8;
		int result = minPath(start_x,start_y,end_x,end_y);
		System.out.println(result);
	}
	
	public static int minPath(int s_x , int s_y,int e_x,int e_y){
		if(e_x == s_x){
			return e_y-s_y;
		}
		else if(e_y == s_y)
			return e_x -s_x;
		
		else{
			int x_max = Math.abs(e_x -s_x);
			int y_max = Math.abs(e_y -s_y);
			int dist_matrix[][] = new int[x_max+1][y_max+1];
			for(int i = 0 ;i<=(e_x-s_x);i++){
				for(int j = 0;j<=(e_y-s_y);j++){
					if(i==0)
						dist_matrix[i][j] = j;
					else if(j==0)
						dist_matrix[i][j] = i;
					else{
						dist_matrix[i][j] = Math.min( Math.min(dist_matrix[i-1][j-1], dist_matrix[i][j-1]) ,dist_matrix[i-1][j] ) +1;					}
				}
			}
			return dist_matrix[e_x-s_x][e_y-s_y];
		}
		
		
	}
}

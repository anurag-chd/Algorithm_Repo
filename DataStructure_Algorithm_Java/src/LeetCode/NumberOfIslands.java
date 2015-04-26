package LeetCode;

import java.util.Stack;

public class NumberOfIslands {
	public static void main(String args[]){
		char arr[][] = {{'1','1','0','0','0'},
						{'1','1','0','1','0'},
						{'0','0','1','0','0'},
						{'0','0','0','1','1'},
					};
		
		System.out.println(numIslands(arr));
	}
	
	
	public static int numIslands(char[][] grid){
		Stack<Point1> stack = new Stack<>();
		int result = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0 ; j< grid[0].length; j++){
				if(grid[i][j] == '1'){
					result++;
					Point1 p = new Point1(i,j);
					stack.push(p);
					while(!stack.isEmpty()){
						Point1 temp = stack.pop();
						int row = temp.x;
						int col = temp.y;
						grid[row][col] = '0';
						if(row < grid.length-1 && grid[row+1][col] =='1')
							stack.push(new Point1(row+1,col));
						if(col < grid[0].length-1 && grid[row][col+1] == '1')
							stack.push(new Point1(row,col+1));
					}
				}
			}
		}
		return result;
		
	}
	
	

}
class Point1{
	int x;
	int y;
	
	public Point1(int x, int y){
		this.x = x;
		this.y = y;
	}
}



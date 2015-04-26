package AmazonInterview;

import java.util.Stack;

public class Zero1_Path_2d_Array {
	
	public static void main(String args[]){
		int arr[][] = new int[3][4];
		arr[0][0] =1;
		arr[0][1] =1;
		arr[0][2] =1;
		arr[0][3] =1;
		arr[1][0] =0;
		arr[1][1] =0;
		arr[1][2] =1;
		arr[1][3] =0;
		arr[2][0] =1;
		arr[2][1] =0;
		arr[2][2] =1;
		arr[2][3] =1;
		
		int result = totalPath(arr);
		System.out.println(result);
	}
	
	public static int totalPath(int arr[][]){
		int count =0;
		Stack<Pos> stack = new Stack();
		int row = arr.length;
		int col = arr[0].length;
		
		for(int i = 0; i<row ;i++){
			for(int j = 0; j<col ;j++){
				if(arr[i][j] == 1){
					Pos a = new Pos(i,j);
					stack.push(a);
					while(!stack.empty()){
						a = (Pos)stack.pop();
						int x = a.x;
						int y = a.y;
						arr[x][y] =0;
						
						if(x-1>=0 && arr[x-1][y] == 1){
							Pos b = new Pos(x-1,y);
							stack.push(b);
						}
						
						if(y-1>=0 && arr[x][y-1] == 1){
							Pos c = new Pos(x,y-1);
							stack.push(c);
						}
						
						if(x+1<row && arr[x+1][y] == 1){
							Pos d = new Pos(x+1,y);
							stack.push(d);
						}
						
						if(y+1<col && arr[x][y+1] == 1){
							Pos e = new Pos(x,y+1);
							stack.push(e);
						}
					}
					count++;
				}
			}
		}
		return count;
		
		
	}
	
	
	public static class Pos{
		int x;
		int y;
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}

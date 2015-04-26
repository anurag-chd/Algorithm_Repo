package Geek4Geeks_Graph;

import java.util.Stack;

public class CountIslands {
	public static void main(String args[]){
		int mat[][] = {  {1, 1, 0, 0, 0},
						 {0, 1, 0, 0, 1},
						 {1, 0, 0, 1, 1},
						 {0, 0, 0, 0, 0},
						 {1, 0, 1, 0, 1}
		    			};
		System.out.println("The number of islands is "+numIslands(mat));
	}
	
	public static int numIslands(int mat[][]){
		boolean visited[][] = new boolean[mat.length][mat[0].length];
		int row = mat.length;
		int col = mat[0].length;
		for(int i =0 ; i< row;i++){
			for(int j =0; j< col ;j++){
				visited[i][j] = false;
			}
		}
		Stack<Point> stack = new Stack<Point>();
		int count =0;
		for(int i =0 ; i< row ;i++){
			for(int j = 0; j< col ; j++){
				if(mat[i][j] == 1 &&  visited[i][j] == false){
					Point p = new Point(i,j);
					stack.push(p);
					visited[i][j] = true;
					while(!stack.isEmpty()){
						Point temp = stack.pop();
						int x = temp.x;
						int y = temp.y;
						
							if(x-1>=0 && y-1>=0 && mat[x-1][y-1] == 1 && visited[x-1][y-1] == false){
								temp = new Point(x-1,y-1);
								stack.push(temp);
								visited[x-1][y-1] = true;
							}
							if(x-1>=0 && mat[x-1][y] == 1 && visited[x-1][y] == false){
								temp = new Point(x-1,y);
								stack.push(temp);
								visited[x-1][y] = true;
							}
							if(x-1>=0 && y+1< col && mat[x-1][y+1] == 1 && visited[x-1][y+1] == false){
								temp = new Point(x-1,y+1);
								stack.push(temp);
								visited[x-1][y+1] = true;
							}
							if(y-1>=0 && mat[x][y-1] == 1 && visited[x][y-1] == false){
								temp = new Point(x,y-1);
								stack.push(temp);
								visited[x][y-1] = true;
							}
							if(y+1< col && mat[x][y+1] == 1 && visited[x][y+1] == false){
								temp = new Point(x,y+1);
								stack.push(temp);
								visited[x][y+1] = true;
							}
							if(x+1< row && y-1 >= 0 && mat[x+1][y-1] == 1 && visited[x+1][y-1] == false){
								temp = new Point(x+1,y-1);
								stack.push(temp);
								visited[x+1][y-1] = true;
							}
							if(x+1< row && mat[x+1][y] == 1 && visited[x+1][y] == false){
								temp = new Point(x+1,y);
								stack.push(temp);
								visited[x+1][y] = true;
							}
							if(x+1< row && y+1 < col && mat[x+1][y+1] == 1 && visited[x+1][y+1] == false){
								temp = new Point(x+1,y+1);
								stack.push(temp);
								visited[x+1][y+1] = true;
							}
					}
					count++;
					System.out.println(i+" "+j );
				}
			}
		}
		return count;
	}
}

class Point {
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
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
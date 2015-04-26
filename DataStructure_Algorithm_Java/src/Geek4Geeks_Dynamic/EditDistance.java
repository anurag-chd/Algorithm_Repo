package Geek4Geeks_Dynamic;

public class EditDistance {
	public static void main(String args[]){
		String str1 = "hello";
		String str2 = "jello";
		calEditDist(str1,str2);
	}
	
	public static void calEditDist(String str1, String str2){
		int del_cost = 1;
		int add_cost = 1;
		int replace_cost = 1;
		
		int len1 = str1.length()+1;
		int len2 = str2.length()+1;
		
		int min[][] = new int [len1][len2];
		
		for(int row = 0; row<len1 ;row++)
			min[row][0] = row;
		
		for(int col = 0; col<len1 ;col++)
			min[0][col] = col;
		
		int left;//for insertion operation
		int up; // for deletion operation
		int diag; // for no cost or replace
		
		for(int row =1; row <len1; row++){
			for(int col =1; col < len2 ;col++){
				left = min[row][col-1] + del_cost;
				up = min[row-1][col] + add_cost;
				
				if(str1.charAt(row-1) == str2.charAt(col-1)){
					diag = min[row-1][col-1];
				}
				else
					diag = min[row-1][col-1] + replace_cost;
				
				min[row][col] = minCost(left,up,diag);
			}
		}
		
		printMatrix(min);
		System.out.println();
		
		System.out.println(min[len1-1][len2-1]);
	}
	
	public static void printMatrix(int arr[][]){
		for(int row = 0 ; row < arr.length ;row++){
			for(int col = 0; col< arr[0].length ; col++){
				System.out.print(arr[row][col]+", ");
			}
			System.out.println();
		}
	}
	
	public static int minCost(int a, int b , int c){
		if(a<=b){
			if(a<=c)
				return a;
			else
				return c;
		}
		else{
			if(b<=c)
				return b;
			else
				return c;
		}
	}
}

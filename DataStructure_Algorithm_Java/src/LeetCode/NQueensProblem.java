package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class NQueensProblem {
	
	public static void main(String args[]){
		int n = 4;
		
		System.out.println(solveNQueens(n));
	}
	
	public static List<String[]> solveNQueens(int n){
		boolean arr[][] = new boolean[n][n];
		int result[] = new int[n];
		List<String[]> list = new ArrayList<>();
		populateQueens(n,arr,0,result,list);
		return list;
	}
	
	public static void populateQueens(int n,boolean arr[][], int rowIndex , int result[], List<String[]> list){
		if(rowIndex == n){
			printArr(result,list);
			return;
		}
		for(int col =0; col< arr.length;col++){
			arr[rowIndex][col] = true;
			if(correctPos(arr,rowIndex,col)){
				result[rowIndex] = col;
				populateQueens(n,arr,rowIndex+1,result,list);
			}
			arr[rowIndex][col] = false;
		}
	}
	
	public static void printArr(int arr[], List<String[]> list){
		String strArr[] = new String[arr.length];
		for(int i = 0; i < arr.length;i++){
			StringBuilder sbr = new StringBuilder();
			for(int j = 0;j< arr.length;j++){
				if(j == arr[i])
					sbr.append("Q");
				else
					sbr.append(".");
			}
			strArr[i] = sbr.toString();
		}
		list.add(strArr);
	}
	
	public static boolean correctPos(boolean arr[][] , int row, int col){
		if(row == 0)
			return true;
		for(int i = row-1;i >=0 ;i--){
			if(arr[i][col])
				return false;
		}
		
		int i = row -1;
		int j = col -1;
		while(i>=0 && j >=0){
			if(arr[i][j])
				return false;
			i--;
			j--;
		}
		
		i = row -1;
		j = col+1;
		
		while(i>=0  && j <arr.length){
			if(arr[i][j])
				return false;
			i--;
			j++;
		}
		
		return true;
	}
}

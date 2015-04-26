package Geek4Geeks_Strings;

public class Match_String_2D_Array {
	
	public static void main(String args[]){
		char[][] arr = {{'a','b','c'},
						{'d','e','f'},
						{'g','h','i'}};
		String str = "bcfehgda";
		if(findStr(arr,str)){
			System.out.println("true");
		}
		else{
			System.out.println("false");
		}
	}
	
	public static boolean findStr(char arr[][], String str){
		for(int i = 0; i<arr.length ;i++){
			for(int j =0 ; j<arr[0].length ;j++){
				if(str.charAt(0) == arr[i][j]){
					return finalSearch(str,arr,1,i,j);
				}
			}
		}
		return false;
	}
	
	public static boolean finalSearch(String str,char arr[][], int index, int row, int col){
		if(index == str.length()){
			return true;
		}
		else{
			System.out.println(index);
			if( row-1 >= 0 && str.charAt(index) == arr[row-1][col]){
				return finalSearch(str,arr,++index,row-1,col);
			}
			else if(row+1 < arr.length && str.charAt(index) == arr[row+1][col]){
				return finalSearch(str,arr,++index,row+1,col);
			}
			else if(col-1 >=0 && str.charAt(index) == arr[row][col-1]){
				return finalSearch(str,arr,++index,row,col-1);
			}
			else if(col + 1 <arr[0].length && str.charAt(index) == arr[row][col+1]){
				return finalSearch(str,arr,++index,row,col+1);
			}
			else
				return false;
		
					
			
		
			
		}
	}
}	


package Geek4Geeks_Dynamic;

public class LongestCommonSubsequence {
	public static void main(String args[]){
		String str1 = "GXTXAYB";
		String str2 = "AGGTAB";
		
		int result = LCS(str1,str2);
		System.out.println(result);
	}
	
	public static int LCS(String str1, String str2){
		char arr1[] = str1.toCharArray();
		char arr2[] = str2.toCharArray();
		
		
		int len1 = arr1.length;
		int len2 = arr2.length;
		/*the length of the longest sequence array */
		int len3 =len1>len2?len2:len1;
		char LCSArr[] = new char[len3];
		int lcs_index =0;
		int max_match =0;
				
		int max[][] = new int[len1+1][len2+1];
		
		for(int i = 0; i<= len1; i++){
			for(int j = 0; j<= len2; j++){
				if(i ==0 || j ==0)
					max[i][j] = 0;
			}
		}
		
		for(int row =1 ; row<= len1 ;row++){
			for(int col = 1; col<= len2 ;col++){
				if(arr1[row-1] == arr2[col-1]){
					max[row][col] = 1 + max[row-1][col-1];
					if(max_match <max[row][col]){
						max_match = max[row][col];
						LCSArr[lcs_index] = arr1[row-1];
						lcs_index++;
					}
					
				}
					
				
				else{
					max[row][col] = Math.max(max[row-1][col], max[row][col-1]);
				}
			}
		}
		
		printArr(LCSArr);
		//print2DArr(max);
		
		return max[len1][len2];
	}
	
	public static void printArr(char arr[]){
		for(char c : arr){
			System.out.print(c);
		}
		System.out.println();
	}
	
	public static void print2DArr(int arr[][]){
		for(int i =0; i< arr.length;i++){
			for(int j =0; j< arr[0].length ;j++){
				System.out.print(arr[i][j]+ " ,");
			}
			System.out.println();
		}
	}
}

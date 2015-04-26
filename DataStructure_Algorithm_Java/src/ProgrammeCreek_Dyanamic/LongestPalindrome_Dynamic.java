package ProgrammeCreek_Dyanamic;

public class LongestPalindrome_Dynamic {
	public static void main(String args[]){
		String str1 = "dabcba";
		System.out.println(getLPS(str1));
	}
	
	public static String getLPS(String str){
		if(str == null || str.length() == 0)
			return str;
		int maxLen = 0;
		String longestPalin = null;
		boolean matrix[][] = new boolean[str.length()][str.length()];
		int len = str.length();
		for(int i =0 ; i< len ;i++)
			matrix[i][i] = true;
		
		for(int i = 0; i< len-1 ;i++){
			if(str.charAt(i) == str.charAt(i+1)){
				matrix[i][i+1] = true;
				longestPalin = str.substring(i,i+2);
			}
		}
		
		for(int l = 3 ; l<=len ;l++){
			for(int i =0; i<= len-l;i++){
				int j = l + i -1;
				if(str.charAt(i) == str.charAt(j)){
					matrix[i][j] = matrix[i+1][j-1];
					if(matrix[i][j] == true && l > maxLen){
						maxLen = l;
						longestPalin = str.substring(i,j+1);
					}
				}
				else{
					matrix[i][j] = false;
				}
			}
		}
		return longestPalin;
		
	}
}

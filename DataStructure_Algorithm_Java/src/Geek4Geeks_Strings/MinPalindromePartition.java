package Geek4Geeks_Strings;

public class MinPalindromePartition {
	public static void main(String args[]){
		String str = "ababbbabbababa";
		
		System.out.println("The minimum palindrome partition are :" + minPALPartition(str));
	}
	
	public static int minPALPartition(String str){
		int len = str.length();
		char str_arr[] = str.toCharArray();
		//the result matrix
		int r[][] = new int[len][len];
		// the palindrome confirmation array
		boolean p[][] = new boolean[len][len];
		
		for(int i =0; i<len; i++){
			r[i][i] = 0;
			p[i][i] = true;
		}
		
		for(int l = 1; l < len; l++){
			for(int i =0; i< len-l; i++){
				int j = i+l;
				if(l ==1){
					p[i][j] = (str_arr[i] == str_arr[j]);
				}
				else
					p[i][j] = (str_arr[i] == str_arr[j]) && p[i+1][j-1];
				
				if(p[i][j] == true)
					r[i][j] = 0;
				else{
					r[i][j] = 999999999;
					
					for(int k = i; k<j ;k++){
						r[i][j] = Math.min(r[i][j], r[i][k] + r[k+1][j] +1);
					}
				}
			}
		}
		return r[0][len-1];
				
	}

}

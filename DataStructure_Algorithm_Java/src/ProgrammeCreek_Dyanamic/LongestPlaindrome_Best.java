package ProgrammeCreek_Dyanamic;

public class LongestPlaindrome_Best {
	public static void main(String args[]){
		String str = "dabcba";
		System.out.println(longestPalindorme(str));
	}
	
	public static String longestPalindorme(String str){
		if(str == null || str.length() <2)
			return str;
		else{
			int len = str.length();
			String longPalin = str.substring(0,1);
			for(int i = 0; i< len-1;i++){
				String temp1 = getPalin(str,i,i);
				String temp2 = getPalin(str,i,i+1);
				String temp3 = temp1.length()<temp2.length()?temp2:temp1;
				longPalin = longPalin.length()<temp3.length()?temp3:longPalin;
				
			}
			
			return longPalin;
		}
	}
	
	public static String getPalin(String str, int left, int right){
		while(left>=0 && right<str.length()){
			if(str.charAt(left) == str.charAt(right)){
				left--;
				right++;
			}
			else{
				break;
			}
		}
		
		return str.substring(left+1,right);
			
	}

}

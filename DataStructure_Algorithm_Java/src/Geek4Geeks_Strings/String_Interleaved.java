package Geek4Geeks_Strings;

public class String_Interleaved {
	public static void main(String args[]){
		String str1 = "AB";
		String str2 = "CD";
		String str3 = "ACDB";
		if(isInterleaved(str1,str2,str3)){
			System.out.println("The string is interleaved");
		}
		else{
			System.out.println("The string is not interleaved");
		}
	}
	
	public static boolean isInterleaved(String str1, String str2, String inter){
		int i = 0, j=0;
		char[] str1_arr = str1.toCharArray();
		char[] str2_arr = str2.toCharArray();
		char[] inter_arr = inter.toCharArray();
		
		for(int k = 0; k<inter_arr.length; k++){
			if(i < str1.length() && inter_arr[k] == str1_arr[i]){
				i++;
			}
			else if(j <str2.length() && inter_arr[k] == str2_arr[j]){
				j++;
			}
			else{
				return false;
			}
		}
		return true;
		
	}
}

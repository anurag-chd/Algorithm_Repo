package Geek4Geeks_Strings;

public class LongestSubstring_WORepeating {
	public static void main(String args[]){
		String str = "ABDEFGABEF";
		int length = longestUniqueSubstring(str);
		System.out.println(length);
	}
	
	public static int longestUniqueSubstring(String str){
		char [] str_arr = str.toCharArray();
		int [] int_arr = new int[256];
		for(int i =0;i<str.length();i++){
			int_arr[(int)str_arr[i]] = -1;
		}
		int max =1;
		int count = 1;
		int_arr[(int)str_arr[0]] = 0 ;
		for(int i = 1; i< str.length(); i++){
			if(int_arr[(int)str_arr[i]] == -1){
				int_arr[(int)str_arr[i]] = i;
				count++;
				if(count == 7){
					System.out.println(str_arr[i]);
				}
			}
			else{
				if(max<count){
					max = count;
				}
				count = count - 1 - int_arr[(int)str_arr[i]];
				int_arr[(int)str_arr[i]] = i;
			}
		}
		return max;
	}
}

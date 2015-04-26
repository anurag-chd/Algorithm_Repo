package Geek4Geeks_Strings;

import java.util.HashMap;
import java.util.HashSet;

public class Remove_Dup_Chars {
	public static void main(String args[]){
		String str = "tea tooth tee";
		long startTime = System.currentTimeMillis();
		String result = removeDuplicate(str);
		//String result = removeDuplicate2(str);
		System.out.println(result);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}
	
	public static String removeDuplicate2(String str){
		HashSet <Character> char_set = new HashSet<Character>();
		int i =0;
		while(i< str.length()){
			char c = str.charAt(i);
			int j = i ;
			if(char_set.contains(c)){
				str = str.substring(0,j) + str.substring(j+1);
			}
			else{
				char_set.add(c);
				i++;
			}	
		}
		return str;
	}
	
	public static String removeDuplicate(String str){
		byte []bitmap = new byte[32];
		for(int i =0; i< 32; i++){
			bitmap[i] = 0;
		}
		int i =0;
		while(i< str.length()){
			char c = str.charAt(i);
			int j = i ;
			if(bitmapContains(c,bitmap)){
				str = str.substring(0,j) + str.substring(j+1);
			}
			else{
				i++;
			}	
		}
		return str;
	}
	
	
	public static boolean bitmapContains(char c, byte[] bitmap){
		int char_val = c;
		int rem = char_val/8;
		int bit_val = char_val%8;
		if(bit_val == 0)
			bit_val = 7;
		else
			bit_val = bit_val -1;
		
		byte temp = (byte) 255;
		
		temp = (byte) (temp & (1<<bit_val));
		
		if((bitmap[rem] & temp) == 0){
			bitmap[rem] = (byte) (bitmap[rem] | temp);
			return false;
		}
		else{
			return true;
		}
		
		
	}
}

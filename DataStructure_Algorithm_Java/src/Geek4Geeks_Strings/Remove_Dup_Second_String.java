package Geek4Geeks_Strings;

import java.util.HashSet;

public class Remove_Dup_Second_String {
	public static void main(String args[]){
		String str1 = "anurag";
		String str2 = "ragau";
		
		String result = removeDup(str1,str2);
		System.out.println(result);
	}
	
	public static String removeDup(String str1, String str2){
		HashSet<Character> char_set =  new HashSet<Character> ();
		for(int i = 0; i< str2.length();i++){
			char_set.add(str2.charAt(i));
		}
		int index =0;
		while(index< str1.length()){
			if(char_set.contains(str1.charAt(index))){
				str1 = str1.substring(0,index) + str1.substring(index+1);
			}
			else{
				index++;
			}
		}
		return str1;
		
	}

}

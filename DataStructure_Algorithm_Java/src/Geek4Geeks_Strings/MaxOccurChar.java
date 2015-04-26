package Geek4Geeks_Strings;

import java.util.HashMap;

public class MaxOccurChar {
	public static void main(String args[]){
		String str = "tea tot teeth";
		int result = getMax(str);
		System.out.println(result);
		
	}
	
	public static int getMax(String str){
		int len = str.length();
		char max_char = ' ';
		HashMap<Character, Integer> charmap = new HashMap<Character, Integer>(); 
		for(int i =0 ; i< len ;i++){
			char c = str.charAt(i);
			if(i == 0)
				max_char = c;
			if(!charmap.containsKey(c)){
				charmap.put(c,1);
			}
			else{
				int j = charmap.get(c);
				charmap.put(c,++j);
				
				if(j>charmap.get(max_char))
					max_char = c;
			}
		}
		
		return charmap.get(max_char);
	}

}

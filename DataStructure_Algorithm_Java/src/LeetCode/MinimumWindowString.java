package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowString {
	public static void main(String args[]){
		String S = "ADOBECODEBANC";
		String T = "ABC";
		
		System.out.println(minWindow(S,T));
	}
	
	
	public static String minWindow(String S, String T){
		Map<Character, Integer> tMap = new HashMap<>();
		for(int i = 0; i<T.length() ;i++){
			char c = T.charAt(i);
			if(tMap.containsKey(c))
				tMap.put(c, tMap.get(c)+1);			
			else
				tMap.put(c,1);
		}
		Map<Character, Integer> sMap = new HashMap<>();
		String result = "";
		int start = 0, end = 0, min =Integer.MAX_VALUE;
		int foundChars = 0;
		while(end < S.length()){
			char c = S.charAt(end);
			if(tMap.containsKey(c) && sMap.containsKey(c)){
				if(sMap.get(c) <tMap.get(c))
					foundChars++;
				sMap.put(c,sMap.get(c)+1);
				
			}
			else if(tMap.containsKey(c)){
				sMap.put(c,1);
				foundChars++;
			}
			
			if(foundChars == T.length()){
				char sc = S.charAt(start);
				while(!sMap.containsKey(sc) || sMap.get(sc) > tMap.get(sc)){
					if(sMap.containsKey(sc) && sMap.get(sc) > tMap.get(sc)){
						sMap.put(sc, sMap.get(sc)-1);
					}
					start++;
					sc = S.charAt(start);
				}
				if(end -start+1 <min){
					result = S.substring(start,end+1);
					min = end-start+1;
				}
			}
			
			end ++;
		}
			
		return result;
		
	}
}

package ProgrammeCreek.String_Array_Matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWORepeatingChars {
	public static void main(String args[]){
		String s = "anurag";
		System.out.println(lengthOfLongestSubstring(s));
	}
	public static int lengthOfLongestSubstring(String s){
		if(s == null || s.length() == 0)
			return 0;
		if(s.length() ==1)
			return 1;
		Map<Character,Integer> charMap = new HashMap<Character,Integer> (); 
		int maxLength = Integer.MIN_VALUE;
		int count =1;
		int start =0, end =1;
		charMap.put(s.charAt(0),0);
		while(end<s.length()){
			if(!charMap.containsKey(s.charAt(end))){
				count++;
				charMap.put(s.charAt(end),end);
				end++;
				if(count>maxLength)
					maxLength = count;
			}
			else{
				start= charMap.get(s.charAt(end))+1;
				charMap.remove(s.charAt(end));
				
				charMap.put(s.charAt(end),end);
				clearMap(charMap,start);
				count = end-start+1;
				end++;
				if(count>maxLength)
					maxLength = count;
			}
		
			
				
		}
		return maxLength;
	}
	
	public static void clearMap(Map<Character,Integer> charMap, int end){
		Iterator<Map.Entry<Character,Integer>> iter = charMap.entrySet().iterator();
		while (iter.hasNext()) {
		    Map.Entry<Character,Integer> entry = iter.next();
		    if(end> entry.getValue()){
		        iter.remove();
		    }
		}
	}
}

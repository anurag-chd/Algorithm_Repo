package ProgrammeCreek_Dyanamic;

import java.util.HashSet;
import java.util.Set;

/**
 * When the dictionary size is small keep the entire dictinory in memory
 * Create a boolean array arr[] of size s.length()+1
 * mark arr[0] = true;
 * 
 * create a for loop to traverse through the various substrings of string.
 * if arr[index] == true
 * 	traverse the dict and check 
 * 		substring(index, dict.word.length()) is there in dictionary
 * 			mark arr[index+ dict.word.length()] = true
 * return arr[s.length()]; 
 *  
 * @author Anurag
 *
 */

public class WordBreak_SmallDictionary {
	public static void main(String args[]){
		String str = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");dict.add("code");
		System.out.println(wordBreak(str,dict));
		
	}
	
	public static boolean wordBreak(String s, Set<String> dict){
		if(s == null || s.length() == 0)
			return true;
		else if(dict == null || dict.size() == 0)
			return false;
		boolean T[] = new boolean[s.length()+1];
		T[0] = true;
		
		for(int i =0; i< s.length(); i++){
			if(!T[i])
				continue;
			
			for(String a: dict){
				int len = a.length();
				int j = i + len;
				if(j >s.length())
					continue;
				else if(T[j])
					continue;
				if(s.substring(i,j).equals(a))
					T[j] = true;
				if(T[j] && j == s.length())
					return true;
			}
		}
		return T[s.length()];
	}
}

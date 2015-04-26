package ProgrammeCreek_Dyanamic;

import java.util.HashSet;
import java.util.Set;

/**
 * When the dictionary size is big you should not bring it in memory and traverse through the dictionary.
 * Create a boolean array of size of string.
 * Step 1)
 *  ->run outer loop which creates substring from index 0 until we get a match in string
 *  -> mark the index as true in the boolean array.
 *  -> check whether the index is of size of string if that return true;
 *  
 *  Step 2)
 *  -> once you get a true at an index traverse an inner loop to check 
 *  	whether the inner substring is in dictionary.
 *  -> mark the index in array as true and check if its equal to length and return true;  
 *  
 * 
 * 
 * 
 * @author Anurag
 *
 */

public class WordBreak_BigDictionary {
	public static void main(String args[]){
		String str = "aaaaaaa";
		Set<String> dict = new HashSet<String>();
		dict.add("aaaa");dict.add("aa");
		/*dict.add("sam");dict.add("sung");
		dict.add("man");dict.add("mango");dict.add("icecream");dict.add("and");
		dict.add("go");dict.add("i");dict.add("like");dict.add("ice");dict.add("cream");*/
		
		System.out.println(wordBreak(str,dict));
		
	}
	
	public static boolean wordBreak(String s, Set<String> dict){
		if(s == null || s.length() == 0)
			return true;
		else if(dict == null || dict.size() == 0)
			return false;
		int len = s.length();
		boolean T[] = new boolean[s.length()+1];
		for(int i =1; i<= len;i++){
			if(!T[i] && dict.contains(s.substring(0,i))){
				T[i] = true;
			}
			
			if(T[i]){
				if( i == len)
					return true;
				else{
					for(int j = i+1 ; j<= len ; j++){
						if(!T[j] && dict.contains(s.substring(i,j))){
							T[j] = true;
						}
						if(T[j] && j == len)
							return true;
					}
				}
			}
		}
		return false;
	}
}

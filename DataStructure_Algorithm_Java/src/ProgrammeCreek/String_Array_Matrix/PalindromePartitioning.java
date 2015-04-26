package ProgrammeCreek.String_Array_Matrix;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public static void main(String args[]){
		String str = "aab";
		List<List<String>> result = getPartitions(str);
		System.out.println(result);
		
	}
	
	public static List<List<String>> getPartitions(String s){
		List<List<String>> result = new ArrayList<List<String>>();
		if(s == null || s.length() == 0)
			return null;
		ArrayList<String> partition = new ArrayList<String>();
		addPalindrome(s, 0, partition, result);
	 
		return result;
	}
	
	public static void addPalindrome(String s, int start, ArrayList<String> partition, List<List<String>> result){
		if(start == s.length()){
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}
		for(int index = start+1; index <= s.length();index++){
			String str = s.substring(start, index);
			if(isPalin(str)){
				partition.add(str);
				addPalindrome(s,index,partition,result);
				partition.remove(partition.size()-1);
			}
		}
	}
	
	public static boolean isPalin(String str){
		if(str == null || str.length()<2)
			return true;
		int start = 0;
		int end = str.length()-1;
		while(start < end){
			if(str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
}

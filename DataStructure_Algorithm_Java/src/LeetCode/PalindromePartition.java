package LeetCode;

import java.util.ArrayList;

public class PalindromePartition {
	public static void main(String args[]){
		String s = "aab";
		ArrayList<ArrayList<String>> list = null;
		
		list = getPalindrome(s);
		printList(list);
		
	}
	
	public static void printList(ArrayList<ArrayList<String>> list){
		for(ArrayList<String> l : list){
			for(String s: l){
				System.out.print(s+",	 ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<String>> getPalindrome(String str){
		if(str == null || str.length() == 0)
			return null;
		ArrayList<String> partition = new ArrayList<String>();
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		findPalindromeLists(str,0,partition,list);
		
		return list;
		
	}
	
	public static void findPalindromeLists(String str, int start, ArrayList<String> partition, ArrayList<ArrayList<String>> list){
		if(start == str.length()){
			ArrayList<String> temp = new ArrayList<String>(partition);
			list.add(temp);
			return;
		}
		else{
			for(int i = start+1; i<= str.length();i++){
				String string = str.substring(start, i);
				if(isPalindrome(string)){
					partition.add(string);
					findPalindromeLists(str,i,partition,list);
					partition.remove(partition.size()-1);
				}
			}
		}
		
	}
	
	public static boolean isPalindrome(String str){
		int start = 0;
		int end = str.length()-1;
		
		while(start<=end){
			if(str.charAt(start) != str.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}

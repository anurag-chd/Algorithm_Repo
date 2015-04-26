package Basics;

import java.util.ArrayList;


public class PossibleCharacterPartition_Integer {
	public static void main(String args[]){
		int num = 1234;
		ArrayList<ArrayList<String>> result = getPartition(num);  
		System.out.println(result);
	}
	
	public static ArrayList<ArrayList<String>> getPartition(int num){
		String str = Integer.toString(num);
		ArrayList<ArrayList<String>> result = getResult(str);
		return result;
	}
	
	public static ArrayList<ArrayList<String>> getResult(String s){
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if(s == null || s.length() == 0)
			return null;
		ArrayList<String> partition = new ArrayList<String>();
		addCharacters(s, 0, partition, result);
	 
		return result;
	}
	public static void addCharacters(String s, int start, ArrayList<String> partition, ArrayList<ArrayList<String>> result){
		if(start == s.length()){
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}
		for(int index = start+1; index <= start+2 && index <= s.length();index++){
			String str = s.substring(start, index);
			if(isChar(str)){
				int buffer = 'a'-1;
				char c = (char)(buffer + Integer.parseInt(str));
				partition.add(Character.toString(c));
				addCharacters(s,index,partition,result);
				partition.remove(partition.size()-1);
			}
		}
	}
	
	public static boolean isChar(String str){
		if(str.length() >2 || str.length() == 0)
			return false;
		int num = Integer.parseInt(str);
		if(num >26 || num <1)
			return false;
		else{
			return true;
		}
	}
	
}

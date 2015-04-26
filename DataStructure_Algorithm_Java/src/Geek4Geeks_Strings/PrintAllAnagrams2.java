package Geek4Geeks_Strings;

import java.util.*;

public class PrintAllAnagrams2 {
	public static void main(String args[]){
		String str_arr[] = {"cat", "dog", "tac", "god", "act"};
		printAllAna(str_arr);
 		
	}
	
	public static void printAllAna(String str_arr[]){
		int n = str_arr.length;
		String sorted_arr[] = new String[n];
		Integer index_arr [] = new Integer[n];
		for(int i = 0; i < n ;i++){
			index_arr[i] = i;
			sorted_arr[i] = sortString(str_arr[i]);
		}
		
		HashMap <String,ArrayList<String>> str_map = new HashMap<String,ArrayList<String>>();
		for(int i =0 ; i< n;i++){
			if(!str_map.containsKey(sorted_arr[i])){
				ArrayList<String> list = new ArrayList<String>();
				list.add(str_arr[i]);
				str_map.put(sorted_arr[i],list);
			}
			else{
				ArrayList<String> temp = str_map.get(sorted_arr[i]);
				temp.add(str_arr[i]);
				str_map.put(sorted_arr[i], temp);
			}
		}
		for(String s : str_map.keySet()){
			ArrayList<String> temp = str_map.get(s);
			for(String str : temp){
				System.out.println(str);
			}
		}
	}
	
	
	public static String sortString(String str){
		char char_arr [] = str.toCharArray();
		StringBuilder sbr = new StringBuilder();
		Arrays.sort(char_arr);
		for(int i = 0; i< char_arr.length;i++){
			sbr.append(char_arr[i]);
		}
		return sbr.toString();
	}

}

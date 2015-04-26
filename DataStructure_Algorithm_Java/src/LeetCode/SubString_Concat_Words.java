package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubString_Concat_Words {
	public static void main (String args[]){
		String S = "aaa";
		String [] L = {"a","a"};
		
		
		System.out.println(findSubString(S,L));
	}
	
	public static List<Integer> findSubString(String S , String[] L){
		List<Integer> result = new ArrayList<Integer>();
		if(S == null || S.length() < (L.length * L[0].length()) || L == null || L.length == 0)
			return result;
		int subLength = L[0].length();
		HashMap<String,Integer> map = new HashMap<>();
		for(String s: L)
			addMap(map,s);
		HashMap<String, Integer> curMap = new HashMap<>();
		for(int i =0 ; i<=S.length() - (L.length* subLength);i++){
			curMap.clear();
			int j = i;
			for(; j< i+ (L.length * subLength); j= j+subLength){
				if(map.containsKey(S.substring(j,j+subLength))){
					addMap(curMap,S.substring(j,j+subLength));
					if(map.get(S.substring(j,j+subLength)) < curMap.get(S.substring(j,j+subLength))){
						break;
					}
				}
				else{
					break;
				}
			}
			if( j == i + (L.length * subLength)){
				result.add(i);
			}
		}
		return result;
	}
	
	public static void addMap(HashMap<String,Integer> map , String s){
		if(map.containsKey(s))
			map.put(s, map.get(s) +1);
		else
			map.put(s, 1);
	}
}

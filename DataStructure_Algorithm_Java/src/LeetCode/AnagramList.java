package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramList {
	public static void main(String args[]){
		String strs[] = {"c","c"};
		System.out.println(anagrams(strs));
		
	}
	
	public static List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<>();
        if(strs == null || strs.length <2)
            return result;
        HashMap<String,List<String>> map = new HashMap<>();
        List<String> emptyList = new ArrayList<>();
        for(String s: strs){
        	if(s.length() == 0){
        		emptyList.add(new String(""));
        	}
        	else{
        		String sortS = getSortedString(s);
                if(map.containsKey(sortS)){
                    List<String> temp = map.get(sortS);
                    temp.add(s);
                    map.put(sortS,temp);
                }
                else{
                    List<String> temp = new ArrayList<>();
                    
                    map.put(sortS,temp);
                }
        	}
            
        }
        
        for(String s : map.keySet()){
            if(map.get(s).size()>1)
                result.addAll(map.get(s));
        }
        result.addAll(emptyList);
        
        return result;
    }
    
    public static String getSortedString(String str){
        if(str.length() <2)
            return str;
        char arr[] = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}

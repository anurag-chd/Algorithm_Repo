package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombination_PhoneNumber {
	public static void main(String args[]){
		String digits = "23";
		System.out.println(letterCombinations(digits));
	}
	
	
	 public static List<String> letterCombinations(String digits) {
	        HashMap<String,String> map = new HashMap<>();
	        map.put("2","abc");
	        map.put("3","def");
	        map.put("4","ghi");
	        map.put("5","jkl");
	        map.put("6","mno");
	        map.put("7","pqrs");
	        map.put("8","tuv");
	        map.put("9","wxyz");
	        
	        List<String> result = new ArrayList<String>();
	        char arr[] = new char[digits.length()];
	        getCombinations(digits,map,0,result,arr);
	        
	        return result;
	        
	    }
	    
	    public static void getCombinations(String digits, HashMap<String,String> map, int index,List<String> result, char arr[]){
	        if(index == digits.length()){
	            String str = new String(arr);
	            result.add(str);
	            return;
	        }
	        String s = map.get(digits.substring(index,index+1));
	        if(s == null){
	            arr[index] = ' ';
	            getCombinations(digits,map,++index,result,arr);
	            index--;
	        }
	        else{
	            for(int i =0 ; i< s.length();i++){
	                arr[index] = s.charAt(i);
	                getCombinations(digits,map,++index,result,arr);
	                index--;
	            }    
	        }
	    }
}

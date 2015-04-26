package ProgrammeCreek.String_Array_Matrix;

import java.util.LinkedList;

public class WordLadder {
	static int min = Integer.MAX_VALUE;
	static boolean flag = false;
	public static void main(String args[]){
		String start = "hit";
		String end = "dov";
		String arr[] = {"hot","dot","dog","lot","log"};
		LinkedList<String> dict = new LinkedList<>();
		for(String s : arr)
			dict.add(s);
		
		System.out.println("The minimum # of transformations " + calcTrans(start,end,dict,0));
	}
	
	public static int calcTrans(String start,String end, LinkedList<String> dict, int trans){
		// if start and end string both are one transformation different
		if(isOneChange(start,end)){
			flag = true;
			trans = trans+2;
			if(min > trans)
				min = trans;
			return min;
		}
		
		// traverse through the list to find the trans sequence
		for(int index =0 ; index < dict.size(); index++){
			if(isOneChange(start,dict.get(index))){
				trans++;
				start = dict.get(index);
				dict.remove(start);
				min = calcTrans(start,end,dict,trans);
				dict.add(start);
			}
		}
		
		if(flag)
			return min;
		else
			return 0;
	}
	
	public static boolean isOneChange(String str1, String str2){
		boolean oneChange = false;
		for(int i =0 ; i< str1.length();i++){
			if(str1.charAt(i) != str2.charAt(i)){
				if(oneChange)
					return false;
				else
					oneChange = true;
				
			}
		}
		return oneChange;
	}
}

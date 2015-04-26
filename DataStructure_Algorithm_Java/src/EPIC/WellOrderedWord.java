package EPIC;

import java.util.ArrayList;
import java.util.List;

public class WellOrderedWord {
	public static void main(String args[]){
		String str = "aBLe";
		computeOrderSeq(str);
	}
	
	public static void computeOrderSeq(String str){
		if(str == null || str.length() <2){
			System.out.println(str);
			return;
		}
		int index = 0;
		List<String> permList = new ArrayList<>();
		
		generatePerms(str,index,permList);
		
		printOrderdStr(permList);
		
			
	}
	
	public static void printOrderdStr(List<String> list){
		for(String str: list){
			if(str.length()!=0){
				if(str.length() ==1)
					System.out.println(str);
				String temp = str.toLowerCase();
				for(int i =1; i<str.length();i++){
					if(temp.charAt(i)< temp.charAt(i-1))
						break;
					if(i == str.length()-1)
						System.out.println(str);
				}
			}
		}
		
	}
	
	public static void generatePerms(String str, int index , List<String> list){
		if(index == str.length()){
			list.add("");
			return;
		}
		generatePerms(str,index+1,list);
		List<String> copyList = new ArrayList<>();
		for(String s: list){
			for(int i =0; i<= s.length();i++){
				String temp = s.substring(0,i)+str.charAt(index)+ s.substring(i);
				copyList.add(temp);
			}
		}
		list.addAll(copyList);
	}

}

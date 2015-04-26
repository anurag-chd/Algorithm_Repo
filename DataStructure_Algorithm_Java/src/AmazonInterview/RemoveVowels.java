package AmazonInterview;

import java.util.HashSet;

public class RemoveVowels {
	public static void main(String args[]){
		String str = new String("Nikhil<>?\" is John Abrahim");
		str = removeVowels(str);
		System.out.println(str);
		
	}
	
	public static String removeVowels(String str){
		if(str == null || str.length() == 0)
			return str;
		HashSet<Character> set = new HashSet<Character>();
		set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
		set.add('A');set.add('E');set.add('I');set.add('O');set.add('U');
		
		int index = 0;
		while(index < str.length()){
			if(set.contains(str.charAt(index))){
				if(index == 0){
					str = str.substring(1);
				}
				else{
					str = str.substring(0,index) + str.substring(index+1);
				}
			}
			else
				index++;
		}
		return str;
	}
}

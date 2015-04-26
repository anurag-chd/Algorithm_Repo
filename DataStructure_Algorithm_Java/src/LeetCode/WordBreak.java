package LeetCode;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordBreak {
	public static void main(String args[]){
		Set<String> set = new HashSet<String>();
		/*"cat", "cats", "and", "sand", "dog"*/
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		
		String str = "catsanddog";
		LinkedList<String> list = null;
		
		list = createSentenceList(str,set);
		for(String s : list){
			System.out.println(s);
		}
		
		
		
	}
	
	public static LinkedList<String> createSentenceList(String str , Set<String> dict){
		LinkedList <String> result = new LinkedList<String>();
		String sent = null;
		for(int i =1; i<=str.length();i++){
			if(dict.contains(str.substring(0, i))){
				sent = getSentence(str,dict,i);
				if(sent != null){
					result.add(sent);
				}
				
			}
		}
		return result;
	}
	
	public static String getSentence(String str , Set<String> dict, int index){
		String resultString=str.substring(0,index);
		for(int i=index+1; i<=str.length();i++){
			if(dict.contains(str.substring(index, i))){
				resultString = resultString +" "+ str.substring(index,i) ;
				index = i;
			}
			else if(i == str.length()){
				return null;
			}
		}
		return resultString;
	}
	
	public static String writeSentence(String str, Set<String> dict){
		int word_start = 0 ;
		String resultString="";
		for(int i=1; i<=str.length();i++){
			if(dict.contains(str.substring(word_start, i))){
				resultString = resultString + str.substring(word_start,i)+ " " ;
				word_start = i;
			}
		}
		return resultString;
	}
}

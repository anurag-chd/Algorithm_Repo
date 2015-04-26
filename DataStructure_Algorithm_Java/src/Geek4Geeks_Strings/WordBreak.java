package Geek4Geeks_Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	static Set<String> dict = new HashSet<>();
	public static void main(String args[]){
		
		String arr[] = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream"};
		
		Collections.addAll(dict,arr);
		
		ArrayList<String> words = new ArrayList<>();
		
		String str = "ilikesamsungi";
		
		printWords(str,words,0);
		
		
	}
	
	
	public static void printWords(String str, ArrayList<String> words, int word_count){	
		int len = str.length();
		if(len ==0){
			System.out.println(words);
		}
		for(int i =1; i<= len ;i++){
			String prefix = str.substring(0,i);
			if(dict.contains(prefix)){
				words.add(prefix);
				String suffix = str.substring(i);
				printWords(suffix,words,word_count);
				words.remove(words.size()-1);
			}
		}
	}
	
	}

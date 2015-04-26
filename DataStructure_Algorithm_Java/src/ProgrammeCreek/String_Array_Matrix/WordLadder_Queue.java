package ProgrammeCreek.String_Array_Matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder_Queue {
	public static void main(String args[]){
		String start = "hit";
		String end = "dov";
		String arr[] = {"hot","dot","dog","lot","log"};
		HashSet<String> dict = new HashSet<>();
		for(String s : arr)
			dict.add(s);
		
		System.out.println("The minimum # of transformations " + calcTrans(start,end,dict));
	}
	
	public static int calcTrans(String start, String end, HashSet<String> dict){
		if(dict.isEmpty())
			return 0;
		
		Queue<String> wordQueue = new LinkedList<>();
		Queue<Integer> countQueue = new LinkedList<>();
		
		wordQueue.add(start);
		countQueue.add(1);
		
		while(!wordQueue.isEmpty()){
			String currentWord = wordQueue.poll();
			int currentDistance  = countQueue.poll();
			
			if(currentWord.equals(end)){
				return currentDistance;
			}
			
			
			for(int i = 0; i < currentWord.length() ;i++){
				char [] arr = currentWord.toCharArray();
				for(char c = 'a' ; c <='z' ; c++){
					if(arr[i] != c){
						arr[i] = c;
						String tmp = new String(arr);
						if(dict.contains(tmp)){
							wordQueue.add(tmp);
							countQueue.add(currentDistance+1);
							dict.remove(tmp);
						}
					}
				}
			}
		}
		return 0;
		
		
	}
}

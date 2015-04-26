package ProgrammeCreek.TreeHeap;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public static void main(String args[]){
		String start = "hit";
		String end = "cog";
		String arr[] = {"hot","dot","dog","lot","log"};
		Set<String> dict = new HashSet<String>();
		Collections.addAll(dict,arr);
		System.out.println(ladderLength(start,end,dict));
	}
	
	public static int ladderLength(String start, String end, Set<String> dict){
		if(dict.isEmpty()){
			return -1;
		}
		if(start == null || end == null || start.length() == 0 || end.length() == 0)
			return -1;
		if(start.equals(end))
			return 0;
		Queue<String> currWord = new LinkedList<>();
		Queue<Integer> currCount = new LinkedList<>();
		currWord.add(start);
		currCount.add(1);
		while(!currWord.isEmpty()){
			String str = currWord.poll();
			int currDistance = currCount.poll();
			if(str.equals(end)){
				return currDistance;
			}
			
			for(int index = 0; index <str.length();index++){
				char strArr[] = str.toCharArray();
				for(char i = 'a'; i<= 'z' ;i++){
					strArr[index] = i;
					String temp = new String(strArr);
					if(temp.equals(end)){
						return currDistance + 1;
					}
					if(dict.contains(temp)){
						currWord.add(temp);
						currCount.add(currDistance + 1);
						dict.remove(temp);
					}
				}	
			}
		}
		return 0;
	}
}

package ProgrammeCreek.String_Array_Matrix;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class LongestConsecutiveSequence {
	public static void main(String args[]){
		int []num = {100, 4, 200, 1, 3, 2};
		System.out.println(findLongestSequence(num));
	}
	
	public static int findLongestSequence(int []num){
		if(num == null || num.length ==0)
			return 0;
		else{
			HashSet<Integer> set = new HashSet<>();
			
			for(int i : num)
				set.add(i);
			int size = set.size();
			boolean upFlag = false, downFlag = false;
			int max = Integer.MIN_VALUE;
		
			for(int i : num){	
				set.remove(i);
				int count = 1;
				if(set.contains(i+1))
					downFlag = true;
				if(set.contains(i-1))
					upFlag = true;
				int j =1;
				// check upwards
				while(upFlag && count <= size){
					if(set.contains(i-j)){
						count++;
						set.remove(i-j);
						j++;
					}
					else{
						j =1;
						upFlag = false;
					}
				}
				
				// check downwards
				while(downFlag && count <= size){
					if(set.contains(i+j)){
						count++;
						set.remove(i+j);
						j++;
					}
					else{
						downFlag = false;
					}
				}
				
				
				// check wit max
				if(max < count)
					max = count;
			}
			return max;
		}
		
	}

}

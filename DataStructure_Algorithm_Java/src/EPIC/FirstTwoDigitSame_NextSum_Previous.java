package EPIC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FirstTwoDigitSame_NextSum_Previous {
	public static void main(String args[]){
		int min = 113;
		int max = 4000;
		System.out.println("hi");
		System.out.println(getRange(min,max));
	}
	
	// Method to get the range
	/**
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<Integer> getRange(int start, int end){
		if(start > end || (start < 11 && end <11) || (start > 112358 && end > 112358))
				return null;
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 1; i<=9;i++)
			list.add((i*10)+i);
		
		// create the result list
		int num = 0;
		List<Integer> result = new ArrayList<>();
		while(!list.isEmpty()){
			num = (list.getFirst()%10)+ ((list.getFirst()/10)%10);
			if(num <10){
				num = (list.getFirst()*10) + num;
				if(num >= start && num <= end){
					result.add(num);
				}
				
				list.addLast(num);
				
			}
			list.removeFirst();
		}
		return result;
		
		
	}

}

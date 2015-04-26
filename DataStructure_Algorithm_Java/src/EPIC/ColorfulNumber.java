package EPIC;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {
	public static void main(String args[]){
		int num = 23456;
		System.out.println(isColorful(num));
	}
	
	public static boolean isColorful(int num){
		if(num >= 0 && num <100)
			return true;
		int count = 1;
		int temp = num;
		while(temp >10){
			temp = temp/10;
			count++;
		}
		Set<Integer> set = new HashSet<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		return checkNum(num,count,count,set,list);
	}
	
	public static boolean checkNum(int num, int numPow, int index, Set<Integer> set, ArrayList<ArrayList<Integer>> list){
		if(index == 1){
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(num%10);
			list.add(temp);
			return true;
		}
		boolean check = checkNum(num,numPow,--index,set,list);
		if(!check)
			return false;
		
		index++;
		int numAtIndex = getNumAtIndex(num,index);
		ArrayList<ArrayList<Integer>> copyList = new ArrayList<>();
		
		for(ArrayList<Integer> l : list){
			int prod = getListProduct(l);
			prod = prod * numAtIndex;
			if(set.contains(prod))
				return false;
			else{
				set.add(prod);
				ArrayList<Integer> tempList = new ArrayList<>();
				tempList.addAll(l);
				tempList.add(numAtIndex);
				copyList.add(tempList);
			}
		}
		
		ArrayList<Integer> newList = new ArrayList<>();
		newList.add(numAtIndex);
		copyList.add(newList);
		list.addAll(copyList);
		return true;
		
	}
	
	public static int getListProduct(ArrayList<Integer> list){
		int prod = 1;
		for(int i : list)
			prod = prod * i;
		return prod;
	}
	
	public static int getNumAtIndex(int num, int index){
		num = num/(int) (Math.pow(10, index-1));
		if(num > 10)
			return num%10;
		else
			return num;
	}
}

package EPIC;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsColorFullNumber {
	public static void main(String args[]){
		List<Integer> list = new ArrayList<>();
		list.add(2);list.add(3);list.add(6);
		
		System.out.println(isColorFul(list));
	}
	
	public static boolean isColorFul(List<Integer> list){
		if(list.size() <2)
			return true;
		int index = 0;
		ArrayList<ArrayList<Integer>> permList = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		
		return checkColor(list,index,permList,set);
		
	}
	
	public static boolean checkColor(List<Integer> list, int index, ArrayList<ArrayList<Integer>> permList, Set<Integer> set){
		if(index == list.size()){
			ArrayList<Integer> temp = new ArrayList<>();
			permList.add(temp);
			return true;
		}
		boolean res = checkColor(list,index+1,permList,set);
		if(!res)
			return false;
		int num = list.get(index);
		ArrayList<ArrayList<Integer>> copyList = new ArrayList<>();
		for(ArrayList<Integer> l : permList){
			int prod = num * getProduct(l);
			if(set.contains(prod))
				return false;
			else{
				set.add(prod);
				ArrayList<Integer> temp = new ArrayList<>();
				temp.addAll(l);
				temp.add(num);
				copyList.add(temp);
			}
		}
		permList.addAll(copyList);
		return true;
	}
	
	public static int getProduct(ArrayList<Integer> list){
		int prod = 1;
		for(int i: list)
			prod = prod *i;
		return prod;
	}
}

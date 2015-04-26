package ProgrammeCreek.String_Array_Matrix;

import java.util.ArrayList;
import java.util.Collections;


public class Subsets1 {
	public static void main(String args[]){
		int s[] = {1,2,3};
		ArrayList<ArrayList<Integer>> list=  new ArrayList<ArrayList<Integer>>();
		list = subsets(s);
		System.out.println(list);
	}
	
	public static ArrayList<ArrayList<Integer>> subsets(int [] s){
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		list = getSubSets(s,list,0);	
		return list;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubSets(int []s,ArrayList<ArrayList<Integer>> list,int index){
		if(index == s.length){
			ArrayList<Integer> temp = new ArrayList<>();
			list.add(temp);
			return list;
		}
		list = getSubSets(s,list,++index);
		index--;
		ArrayList<ArrayList<Integer>> copyList = new ArrayList<>();
		for(ArrayList<Integer> l : list){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(l);
			temp.add(s[index]);
			copyList.add(temp);
		}
		list.addAll(copyList);
		return list;
	}
}

package ProgrammeCreek.String_Array_Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Subset1_Sorted {
	public static void main(String args[]){
		int s[] = {1,2,3};
		ArrayList<ArrayList<Integer>> list= subsets(s); 
		System.out.println(list);
	}
	
	public static ArrayList<ArrayList<Integer>> subsets(int[] s){
		Arrays.sort(s);
		Set<ArrayList<Integer>> listSet = new HashSet<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for(int i = 0 ; i< s.length ;i++){
			ArrayList<ArrayList<Integer>> cloneList = new ArrayList<>();
			for(ArrayList<Integer> list: result){
				ArrayList<Integer> tempList = new ArrayList<>();
				tempList.addAll(list);
				tempList.add(s[i]);
				cloneList.add(tempList);
			}
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(s[i]);
			cloneList.add(temp);
			result.addAll(cloneList);
		}
		ArrayList<Integer> emptyList = new ArrayList<>();
		result.add(emptyList);
		return result;
		
		
	}

}

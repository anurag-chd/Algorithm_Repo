package ProgrammeCreek.String_Array_Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubSets_Duplicates {
	public static void main(String args[]){
		int s[] = {1,2,2};
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
				if(!listSet.contains(tempList)){
					listSet.add(tempList);
					cloneList.add(tempList);
				}
				
			}
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(s[i]);
			if(!listSet.contains(temp)){
				listSet.add(temp);
				cloneList.add(temp);
			}
			
			result.addAll(cloneList);
		}
		ArrayList<Integer> emptyList = new ArrayList<>();
		result.add(emptyList);
		return result;
		
		
	}
	
}



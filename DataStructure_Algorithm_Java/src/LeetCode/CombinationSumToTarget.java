package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumToTarget {
	public static void main(String args[]){
		int target = 8;
		int arr[] = {10,1,2,7,6,1,5};
		System.out.println(combinationSum(arr,target));
	}
	
	public static List<List<Integer>> combinationSum(int [] candidate, int target){
		List<List<Integer>> result = new ArrayList<List<Integer>> ();
		Arrays.sort(candidate);
		if(target <= 0 || candidate[0] >target)
			return result;
		
		List<Integer> list = new ArrayList<>();
		int index = 0;
		getCombo(candidate,target,result,list,index);
		return result;
	}
	
	public static void getCombo(int[] arr, int num, List<List<Integer>> result, List<Integer> list, int index){
		if(num == 0){
			List<Integer> temp = new ArrayList<>();
			
			cloneList(temp,list);
			if(!result.contains(temp)){
				result.add(temp);
			}
			
			return;
		}
		else if(num <0)
			return;
		for(int i = index; i<arr.length;i++){
			list.add(arr[i]);
			getCombo(arr,num-arr[i],result,list,i+1);
			list.remove(list.size()-1);
		}
	}
	
	public static void cloneList(List<Integer> temp , List<Integer> list){
		for(int i: list)
			temp.add(i);
	}
}

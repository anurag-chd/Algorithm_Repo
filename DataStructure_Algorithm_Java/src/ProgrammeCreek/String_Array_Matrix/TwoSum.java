package ProgrammeCreek.String_Array_Matrix;

import java.util.HashMap;

public class TwoSum {
	public static void main(String args[]){
		int arr [] = {2, 7, 11, 15};
		findSum(arr,21);
	}
	
	public static void findSum(int arr[], int sum){
		HashMap<Integer,Integer> indexMap = new HashMap<>();
		for(int index =0; index < arr.length ;index++){
			indexMap.put(arr[index], index);
		}
		for(int index =0 ; index < arr.length ;index++){
			int left = sum - arr[index];
			int secondIndex = indexMap.containsKey(left)? indexMap.get(left):-1;
			if(secondIndex != -1){
				System.out.println("Both the indexs are "+ index+ ", "+ secondIndex);
				return;
			}
		}
		System.out.println("Sum of two numbers does not exits");
		
	}

}

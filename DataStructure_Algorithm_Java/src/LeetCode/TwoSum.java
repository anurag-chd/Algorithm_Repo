package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
	public static void main(String args[]){
		int arr[] = {2,1,9,4,4,56,90,3};
		int result[] = twoSum(arr,8);
		printArr(result);
	}
	public static void printArr(int arr[]){
		for(int i : arr)
			System.out.print(i+" ,");
		System.out.println();
	}
	
	public static int[] twoSum(int []num, int target){
		if(num == null || num.length < 2)
			return null;
		int refArr [] = Arrays.copyOfRange(num, 0, num.length);
		int numIndex[] = new int[num.length];
		
		Arrays.sort(num);
		Set<Integer> set = new HashSet<> ();
		for(int i =0 ; i< num.length ;i++){
			int j = search(num,0,refArr[i],set);
			set.add(j);
			numIndex[j] = i;
		}
		int result[] = new int[num.length];
		int index = 0;
		set.clear();
		for(int i = 0; i< num.length-1 ;i++){
			int next = target - num[i];
			set.add(i);
			int j = search(num,i+1,next,set);
			if(j != -1){
				result[index++] = numIndex[i]+1;
				result[index++] = numIndex[j]+1;
			}
		}
		
		return result;
	}
	
	public static int search(int arr[],int start, int target, Set<Integer> set){
		int end = arr.length -1;
		while(start <= end){
			int mid = (start+end)/2;
			if(arr[mid] == target)
				if(set.contains(mid)){
					mid = arr[mid] == arr[mid-1]? mid-1:mid+1;
					return mid;
							
				}
				else
					return mid;
			else if(arr[mid] > target){
				end = mid -1;
			}
			else
				start = mid+1;
		}
		return -1;
	}
}

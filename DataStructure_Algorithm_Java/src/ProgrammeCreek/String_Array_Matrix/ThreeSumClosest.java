package ProgrammeCreek.String_Array_Matrix;

import java.util.Arrays;

public class ThreeSumClosest {
	public static void  main (String args[]){
		int arr[] = {-1, 2, 1, -4};
		int target = 1;
		System.out.println(find3ClosestSum(arr,target));
	}
	
	public static int find3ClosestSum(int num[], int target){
		int min = Integer.MAX_VALUE;
		if(num.length == 0)
			return min;
		Arrays.sort(num);
		int sum = Integer.MAX_VALUE;
		for(int index = 0; index < num.length-2 ; index++){
			int targetDiff = target - num[index];
			int start = index + 1;
			
			int end = num.length-1;
			
			while(start<end){
				if(num[start] + num[end] == targetDiff)
					return num[index] +num[start] +num[end];
				else if((num[start]+ num[end]>targetDiff)){
					int diff = num[start]+ num[end] - targetDiff;
					if(min > diff){
						min = diff;
						sum = num[index] +num[start] +num[end]; 
					}
					end--;
						
				}
				else{
					int diff = targetDiff - (num[start]+ num[end]);
					if(min > diff){
						min = diff;
						sum = num[index] + num[start] + num[end];
					}
					start++;	
				}
			}
		}
		return sum;
		
		
	}

}

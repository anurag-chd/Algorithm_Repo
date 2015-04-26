package ProgrammeCreek_Dyanamic;

public class MaximumSubarray {
	public static void main(String args[]){
		int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(getMaxSubarr(arr));
		
	}
	
	public static int getMaxSubarr(int arr[]){
		if(arr == null)
			return 0;
		else if(arr.length < 2)
			return arr.length;
		int max = arr[0];
		int newSum = arr[0];
		
		for(int i = 1; i < arr.length; i++){
			newSum = (arr[i]+ newSum)> arr[i]?(arr[i]+ newSum) :arr[i];
			max = (max>newSum)?max:newSum;
		}
		return max;
		
	}
}

package ProgrammeCreek.String_Array_Matrix;

public class MaximumSubArray {
	public static void main(String args[]){
		int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println(calMaxSubArraySum(arr));
	}
	
	public static int calMaxSubArraySum(int A[]){
		if(A == null || A.length == 0)
			return -1;
		int max = A[0];
		int newSum = A[0];
		for(int index =1; index< A.length;index++ ){
			newSum = (A[index]+newSum) > A[index]? (A[index]+newSum): A[index];
			max = max> newSum ? max: newSum;
		}
		return max;
	}
}

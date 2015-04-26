package ProgrammeCreek.String_Array_Matrix;

public class SearchInsertPosition_SortedArray {
	public static void main(String args[]){
		int A[] = {1,2,3,4,5,10};
		int target1 = 2;
		/*int target2 = 2;
		int target3 = 7;
		int target4 = 0;
		*/
		System.out.println(searchInsert(A,target1));
		/*System.out.println(searchInsert(A,target2));
		System.out.println(searchInsert(A,target3));
		System.out.println(searchInsert(A,target4));*/
	}
	
	public static int searchInsert(int A[], int target){
		if(A.length ==0)
			return 0;
		if(target <= A[0])
			return 0;
		if(target > A[A.length-1])
			return A.length;
		if(target == A[A.length-1])
			return A.length-1;
		
		int start = 0 , end = A.length -1;
		while(start<=end){
			int mid = (start + end)/2;
			if(A[mid] == target)
				return mid;
			else if( A[mid] > target){
				if(mid > 0 && A[mid-1] < target)
					return mid;
				else{
					end = mid -1;
				}
			}
			else{
				if(mid < A.length-1 && A[mid+1] > target)
					return mid+1;
				else
					start = mid +1;
			}
		}
		return -1;
	}
	
}

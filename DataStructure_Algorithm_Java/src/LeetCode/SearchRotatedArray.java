package LeetCode;

public class SearchRotatedArray {
	public static void main(String args[]){
		int arr[] = {3,1};
		int target = 1;
		System.out.println(search(arr,target));
	}
	
	public static int search(int A[], int target){
	if(A == null || A.length == 0)
		return -1;
	if(A.length == 1){
	    return A[0] == target?0:-1;
	}	
	int start = 0;
	int end = A.length-1;
	while(start<end){
		int mid = (start+end)/2;
		if(A[mid] == target)
			return mid;
		if(A[mid] >= A[start]){
			if(A[mid]>target && A[start] <=target){
				end = mid-1;
				continue;
			}
			else{
				start = mid+1;
				continue;
			}
		}
		else{ 
			if(A[mid] < target && A[end] >= target){
				start = mid +1;
				continue;
			}
			else{
				end = mid -1;
				continue;
			}
		}
	}
	if(start == end && start >=0 && start < A.length){
		return A[start] == target?start:-1;
	}
	return -1;
	}
}

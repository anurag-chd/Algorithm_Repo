package LeetCode;

public class SerachRange_SortedList {
	public static void main(String args[]){
		int arr[] = {3,3,3};
		int target = 3;
		printArr(searchRange(arr,target));
	}
	public static void printArr(int arr[]){
		if(arr == null){
			System.out.println("null");
			return;
		}
		for(int i : arr)
			System.out.print(i+" ,");
		System.out.println();	
	}
	
	public static int[] searchRange(int[] A, int target){
		if(A == null || A.length <2){
			int result[] = {-1,-1};
			return result;
		}
			
		int result[] = new int[2];
		binarySearch(A,target,result,0,A.length-1);
		
		return result;
	}
	
	public static void binarySearch(int A[], int target, int [] result, int start, int end){
		if(start > end)
			return;
		int mid = (start + end)/2;
		if(A[mid] == target){
			if(mid -1 <0){
				if(result[0] != -1)
					result[0] = result[0]<mid?result[0]:mid;
				else
					result[0] = mid;
				binarySearch(A,target,result,mid+1,end);
			}
			else if(mid +1>= A.length){
				if(result[1] != -1)
					result[1] = result[1]>mid?result[1]:mid;
				else
					result[1] = mid;
				binarySearch(A,target,result,start,mid-1);
			}
				
			else if(mid-1 >= 0 && mid+1 <A.length && A[mid-1] == target && A[mid+1] == target ){
				binarySearch(A,target,result,start,mid-1);
				binarySearch(A,target,result,mid+1,end);
			}
			else if(A[mid-1] == target){
				if(result[1] != -1)
					result[1] = result[1]>mid?result[1]:mid;
				else
					result[1] = mid;
				binarySearch(A,target,result,start,mid-1);
			}
			else{
				if(result[0] != -1)
					result[0] = result[0]<mid?result[0]:mid;
				else
					result[0] = mid;
				binarySearch(A,target,result,mid+1,end);
			}
		}
		else if(A[mid] > target){
			binarySearch(A,target,result,start, mid-1);
		}
		else{
			binarySearch(A,target,result,mid+1,end);
		}
	}
	
	
}

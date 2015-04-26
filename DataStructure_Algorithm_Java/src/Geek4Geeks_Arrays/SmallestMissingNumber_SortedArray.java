package Geek4Geeks_Arrays;

public class SmallestMissingNumber_SortedArray {
	public static void main(String args[]){
		int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
		System.out.println(findFirstMissing(arr,0,arr.length-1));
	}
	
	public static int findFirstMissing(int arr[], int start, int end){
		if(start > end)
			return Integer.MAX_VALUE;
		if(arr[start] != start)
			return start;
		else{
			int mid = (start + end)/2;
			if(arr[mid] > mid){
				return findFirstMissing(arr,++start,mid-1);
			}
			else
				return findFirstMissing(arr,mid+1,end);
		}
			
	}
}

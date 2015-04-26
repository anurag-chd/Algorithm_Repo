package Geek4Geeks_Arrays;

public class SearchNum_Increasing_Decreasing_Array {
	public static void main(String args[]){
		int arr[] = {1,2,3,4,10,9,8,7,6,5};
		findNum(6,arr,0,arr.length-1);
	
	}
	
	public static void findNum(int num, int []arr, int start, int end){
		if(start>end)
			return;
		
		int mid = (start + end)/2;
		
		if(num == arr[mid]){
			System.out.println(mid);
			return;
		}
		else if(num < arr[mid]){
			if(arr[mid] < arr[mid-1])
				findNum(num,arr,mid+1,end);
			else if(arr[mid] < arr[mid+1])
				findNum(num,arr,start,mid-1);
			else{
				findNum(num,arr,start,mid-1);
				findNum(num,arr,mid+1,end);
			}
		}
		
		else{
			if(arr[mid] < arr[mid-1])
				findNum(num,arr,start,mid-1);
			else{
				findNum(num,arr,mid+1,end);
			}
		}
	}
}

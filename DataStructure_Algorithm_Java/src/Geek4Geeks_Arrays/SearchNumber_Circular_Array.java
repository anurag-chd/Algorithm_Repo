package Geek4Geeks_Arrays;

public class SearchNumber_Circular_Array {
	public static void main(String args[]){
		int arr[] = {4,5,8,10,1,2,3};
		findNum(1,arr,0,arr.length-1);
	}
	
	public static void findNum(int num, int arr[], int start, int end){
		if(start>end){
			System.out.println("number not in list");
			return;
		}
		int mid = (start + end)/2;
		
		if(arr[mid] == num){
			System.out.println(mid);
			return;
		}
		if(arr[mid] > arr[start]){
			if(num >= arr[start] && num < arr[mid])
				findNum(num,arr,start,mid-1);
			else{
				findNum(num,arr,mid+1,end);
			}
		}
		else if(arr[mid]<arr[end]){
			if(num >= arr[mid] && num < arr[end])
				findNum(num,arr,mid+1,end);
			else{
				findNum(num,arr,start,mid-1);
			}
			
		}
	}
}

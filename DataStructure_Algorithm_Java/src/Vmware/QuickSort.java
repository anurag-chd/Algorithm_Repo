package Vmware;

public class QuickSort {
	public static void main(String args[]){
		int arr[] = {4,5,6,7,1,2,4,3};
		sort(arr,0,arr.length-1);
		
		for(int i : arr){
			System.out.print(i+", ");
		}
	}
	
	public static void sort(int arr[],int start, int end){
		if(start>end){
			return;
		}
		else{
			int left = start;
			int right = end;
			int pivot = arr[start];
			
			while(right>left){
				while(left<=end && pivot>=arr[left]){
					left++;
				}
				while(right>=start && pivot < arr[right])
					right--;
				
				if(right>=left){
					swap(arr,left,right);
				}
			}
			swap(arr,start,right);
			sort(arr,start,right-1);
			sort(arr,right+1,end);
		}
	}
	
	public static void swap(int arr[], int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}

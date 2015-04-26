package ProgrammeCreek_Sorting;

public class QuickSortArray {
	public static void main(String args[]){
		int arr[] = {10,3,3,2,14,10,20,15,16};
		printArr(arr);
		qSort(arr,0,arr.length-1);
		
		printArr(arr);
		
	}
	
	public static void qSort(int arr[], int start, int end){
		if(start>= end)
			return;
		int pivot = start;
		int left = start;
		int right = end;
		
		while(left < right){
			while(right>= left && arr[left]<= arr[pivot])
				left++;
			while(right>= left && arr[right] > arr[pivot])
				right--;
			if(left<=right)
				swap(arr,left,right);
		}
		swap(arr,right,pivot);
		qSort(arr,start,right-1);
		qSort(arr,right+1,end);
		
	}
	
	public static void swap(int arr[], int index1, int index2){
		if(arr == null || arr.length == 0 || index1 == index2)
			return;
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp; 
	}
	
	public static void printArr(int arr[]){
		if(arr==null || arr.length == 0)
			return;
		for(int index = 0 ; index< arr.length; index++)
			System.out.print(arr[index]+", ");
		System.out.println();
		return;
	}
}

package AmazonInterview;

public class HeapSort {
	public static void main(String args[]){
		int arr[] = {9,3,4,2,6,7,10,1,5,8};
		sort(arr);
		
	}
	
	public static void sort(int arr[]){
		int len = arr.length;
		heapify(arr,len);
		int end = len-1;
		while(end>=0){
			swap(arr,0,end);
			end = end -1;
			shiftDown(arr,0,end);
		}
		
		for(int i =0 ; i< len ;i++){
			System.out.print(arr[i]+" ,");
		}
	}
	
	
	public static void heapify(int arr[], int len){
		int start = (int)Math.floor((double)len-2/2);
		while(start>=0){
			shiftDown(arr,start,len-1);
			start = start -1;
		}
		
	}
	public static void shiftDown(int arr[], int start, int end){
		int root = start;
		while(root*2 +1 <= end){
			int child = (root*2) +1;
			if(child+1<=end && arr[child]< arr[child+1]){
				child = child +1;
			}
			if(arr[root] <= arr[child]){
				swap(arr,root,child);
				root = child;
			}
			else{
				return;
			}
				
		}
	}
	
	public static void swap(int arr[], int root, int child){
		int temp = arr[root];
		arr[root] = arr[child];
		arr[child] = temp;
	}
}

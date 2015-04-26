package Vmware;

public class MergeSort {
	public static void main(String args[]){
		int arr [] = {20,30,10,5,5,40,70,6,34,60};
		sort(arr);
		for(int i : arr){
			System.out.print(i+",");
		}
	}
	
	public static void sort(int arr[]){
		
		int len = arr.length;
		if(len <=1){
			return;
		}
		mergesort(arr,0,len-1);
	}
	
	public static void mergesort(int arr[], int start, int end){
		if(start<end){
			//int middle = start + (end-start)/2;
			int middle = (start + end)/2;
			mergesort(arr,start,middle);
			mergesort(arr,middle+1,end);
			merge(arr,start,middle,end);
			
		}
		
	}
	public static void merge(int arr[], int start, int middle, int end){
		int temp[] = new int[arr.length];
		for(int i =0;i<arr.length;i++){
			temp[i] = arr[i];
		}
		int i = start;
		int j = middle+1;
		int k = start;
		while(i<=middle && j<=end){
			if(temp[i]<=temp[j]){
				arr[k++] = temp[i++];
				/*k++;
				i++;*/
			}
			else{
				arr[k++] = temp[j++];
				
			}
			
		}
		if(i>middle){
			while(j<=end){
				arr[k++] = temp[j++];
			}
		}
		else {
			while(i<=middle){
				arr[k++] = temp[i++];
				
				
			}
		}
	}
}

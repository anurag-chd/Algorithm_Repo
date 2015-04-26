package Geek4Geeks_Trees;

public class Sort_BST_Array {
	public static void main(String args[]){
		int arr[] = {4, 2, 5, 1, 3};
		sortBSTArray(arr,0,arr.length-1);
		
	}
	
	public static void sortBSTArray(int arr[], int start, int end){
		if(start > end)
			return;
		
		sortBSTArray(arr, 2*start+1,end);
		System.out.print(arr[start]+" ,");
		sortBSTArray(arr, 2*start+2,end);
		
	}
}

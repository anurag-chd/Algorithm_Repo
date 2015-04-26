package LeetCode;

public class KthPermutation {
	public static int count = 0;
	public static String result = "";
	public static void main(String args[]){
		int num = 2;
		int k = 1;
		System.out.println(getKthPermutation(num,k));
		
	}
	
	public static String getKthPermutation(int num,int k){
		int arr[] = new int [num];
		for(int i = 0; i< num; i++)
			arr[i] = i+1;
		 createPerms(arr,0,k);
		 return result;
	}
	
	public static void  createPerms(int arr[], int index, int k){
		if(index == arr.length-1){
			count++;
			if(count == k)
				result = printArr(arr);
			
			return;
			
		}
		for(int i = index; i< arr.length ;i++){
			swap(arr,index,i);
			createPerms(arr,index+1,k);
			swap(arr,index,i);
		}
		
	}
	
	public static void swap(int arr[], int i , int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static String printArr(int []arr){
		StringBuilder sbr = new StringBuilder();
		for(int i = 0; i< arr.length; i++)
			sbr.append(arr[i]);
		return sbr.toString();
	}
}

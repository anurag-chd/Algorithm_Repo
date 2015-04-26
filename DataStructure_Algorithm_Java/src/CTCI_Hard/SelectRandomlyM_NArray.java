package CTCI_Hard;

public class SelectRandomlyM_NArray {
	public static void main(String args[]){
		int[] arr = {2,3,4,5,6,7,8,6,5};
		int m = 4;
		int [] res = pickRandom(arr,4);
		for(int i : res){
			System.out.print(i+",");
		}
	}
	
	public static int [] pickRandom(int [] arr, int m){
		int []subset = new int[m];
		int []arr1 = arr.clone();
		for(int j = 0; j<m;j++){
			int index  = j +(int)(Math.random()*(arr.length-1 - j +1));
			subset[j] = arr[index];
			arr[index] = arr[j];
		}
		return subset;
	}
}

package CTCI_Hard;

public class ShuffleCards {
	public static void main(String args[]){
		int []arr ={1,2,3,4,5,6,7};
		arr = shuffle(arr);
		System.out.print("{");
		for(int i : arr){
			System.out.print(i+",");
		}
		System.out.println("}");
	}
	public static int[] shuffle(int arr[]){
		for(int i =0 ; i <arr.length;i++){
			int index = (int)(Math.random()*(arr.length-i))+i;
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		return arr;
	}
}

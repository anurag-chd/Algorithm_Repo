package ProgrammeCreek_BitManipulation;

public class SingleNumber {
	public static void main(String args[]){
		int arr[] = {1,2,3,4,3,2,1};
		System.out.println(singleNumber(arr));
	}
	public static int singleNumber(int arr[]){
		if(arr.length < 2)
			return arr[0];
		int x = 0;
		for(int i : arr)
			x = x^i;
		return x;
	}

}

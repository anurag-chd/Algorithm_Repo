package Geek4Geeks_Strings;

public class Recurse_Reverse {
	public static void main(String args[]){
		String str = "anurag";
		printReverse(str);
		char arr[] = str.toCharArray();
		reverseString(arr,0,arr.length-1);
		System.out.println();
		System.out.println("recurrsive ");
		printArr(arr);
	}
	
	public static void printArr(char arr[]){
		for(char c: arr){
			System.out.print(c);
		}
	}
	
	public static void reverseString(char arr[], int start, int end){
		if(start >= end)
			return;
		char temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		reverseString(arr,++start,--end);
	}
	
	public static void printReverse(String str){
		char arr[] = str.toCharArray();
		
		System.out.println(arr);
		int length = arr.length;
		printArr(arr,0, length);
		
	}
	
	public static void printArr(char arr[], int index, int length) {
		if(index<=length-1){
			//System.out.println(length);
			//System.out.println(index);
			printArr(arr,++index,length);
			//System.out.println(index);
			System.out.print(arr[--index]);
		}
		else
			return;
		
	}

}

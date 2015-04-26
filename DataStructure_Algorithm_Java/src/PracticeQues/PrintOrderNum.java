package PracticeQues;

public class PrintOrderNum {
	public static void main(String args[]){
		int num_len = 3;
		char str[] = new char[3];
		printInorderNum(str,num_len,0,1);
		
	}
	
	public static void printInorderNum(char[] str , int num_len, int index, int value){
		if(num_len == index){
			printCharArr(str);
			return;
		}
		int start = value;
		int end = (9 + index+1) - num_len;
		for(int i =start ; i <= end; i++){
			str[index] = Integer.toString(i).charAt(0);
			printInorderNum(str,num_len,++index,i+1);
			index--;
		}
	}
	
	public static void printCharArr(char arr[]){
		for(int i = 0; i< arr.length; i++){
			System.out.print(arr[i]);
		}
		System.out.print(", ");
	}

}

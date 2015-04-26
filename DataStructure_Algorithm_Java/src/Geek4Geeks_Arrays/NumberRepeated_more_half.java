package Geek4Geeks_Arrays;

public class NumberRepeated_more_half {
	public static void main(String args[]){
		int arr[] = {7,1,1,1,1,4,7,7,7};
		System.out.println("the number more than half times in array is "+findNum(arr));
	}
	
	public static int findNum(int arr[]){
		int num = arr[0];
		int count =1;
		for(int i =1;i<arr.length;i++){
			if(arr[i] == num)
				count++;
			else
				count--;
			if(count == 0){
				//i++;
				if(i>=arr.length)	
					return -1;
				count = 1;
				num = arr[i];
			}
		}
		System.out.println(num);
		if(count > 0){
			int c=0;
			for(int i=0;i<arr.length;i++){
				if(num == arr[i]){
					c++;
				}
			}
			if(c>(arr.length/2))
				return num;
			else{
				return -1;
			}
		}
		else{
			return -1;
		}
	}
}

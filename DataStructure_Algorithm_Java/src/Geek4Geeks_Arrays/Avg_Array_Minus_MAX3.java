package Geek4Geeks_Arrays;

public class Avg_Array_Minus_MAX3 {
	
	public static void main(String args[]){
		int arr[] = {1,8,4,6,9,2,3,7};
		double avg = calcAvg(arr);
		System.out.println(avg);
	}
	
	public static double calcAvg(int arr[]){
		int max1 = 0, max2 = 0, max3 = 0, sum =0;
		int temp1 , temp2;
		for(int i =0; i< arr.length; i++){
			// if number is greater then max1
			if(arr[i] >= max1){
				temp1 = max1;
				max1 = arr[i];
				temp2 = max2;
				max2 = temp1;
				sum = sum + max3;
				max3 = temp2; 
			}
			
			// else if number is greater than max2
			else if(arr[i] >= max2){
				temp1 = max2;
				max2 = arr[i];
				sum = sum + max3;
				max3 = temp1;
			}
			
			// else if number is greater than max3
			else if(arr[i] >= max3){
				sum = sum + max3;
				max3 = arr[i];
			}
			
			// if number is smaller then all the three max add to sum
			else{
				sum = sum + arr[i];
			}
		}
		
		
		
		System.out.println(sum);
		return ((double)sum/ (arr.length-3));
	}

}

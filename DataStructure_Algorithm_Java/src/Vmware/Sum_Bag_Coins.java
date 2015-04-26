package Vmware;

public class Sum_Bag_Coins {
	public static void main(String args[]){
		int arr[] = {5, 20, 45};
		int sum = 155;
		int len = arr.length;
		if(isSumPossible(arr,sum, len-1))
			System.out.println("Sum is possible");
		else
			System.out.println("Sum is not possible");
	}
	
	public static boolean isSumPossible(int arr[], int sum , int index){
		if(sum == 0){
			return true;
		}
		
		if(sum < 0)
			return false;
		
		if(index <0 && sum >= 1){
			return false;
		}
		else{
			if(arr[index] <= sum){
				sum = sum - arr[index];
				return(isSumPossible(arr,sum,index) || isSumPossible(arr,sum+arr[index],index-1));
					
				
			}
			else{
				return(isSumPossible(arr,sum,index-1) || isSumPossible(arr,sum+arr[index],index-1));
			}
		}
	}
}

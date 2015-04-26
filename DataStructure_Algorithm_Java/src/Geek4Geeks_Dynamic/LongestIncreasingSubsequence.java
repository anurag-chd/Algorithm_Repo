package Geek4Geeks_Dynamic;

public class LongestIncreasingSubsequence {
	public static void main(String args[]){
		int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 11};
		int result = findLIS(arr);
		System.out.println(result);
	}
	
	public static int findLIS(int arr[]){
		int lis[] = new int [arr.length];
		int max =1;
		lis[0] = 1;
		
		for(int i =1; i< arr.length;i++){
			for(int j =0; j<i ;j++){
				if(arr[i]>arr[j] && lis[i] <lis[j] +1){
					lis[i] = 1 + lis[j];
					if(max<lis[i])
						max = lis[i];
					
				}
				if(j ==0 && arr[i]<arr[j]){
					lis[i] = 1;
				}
			}
		}
		
		for(int i =0 ;i< arr.length;i++)
			System.out.print(lis[i]+" ");
		System.out.println();
		return max;
		
	}

}

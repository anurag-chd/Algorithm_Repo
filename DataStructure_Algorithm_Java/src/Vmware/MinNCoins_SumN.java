package Vmware;

public class MinNCoins_SumN {
	public static void main(String args[]){
		int a[]={1,3,5};
		int sum =11;
		findMinCoin(a,sum);
	}
	public static void findMinCoin(int arr[],int sum){
		int Min[][] = new int[arr.length+1][sum+1];
		for(int i =0 ; i<=arr.length;i++){
			for(int j =0;j<=sum;j++){
				if(j ==0)
					Min[i][j] = 0;
				else if(i==0 && j!=0)
					Min[i][j] = 101010010;
				else{
					if(arr[i-1]>j)
						Min[i][j] = Min[i-1][j];
					else{
						Min[i][j] = Math.min(Min[i-1][j],1+Min[i][j-arr[i-1]]);
					}
				}
			}
		}
		System.out.println(Min[arr.length][sum]);
	}

}

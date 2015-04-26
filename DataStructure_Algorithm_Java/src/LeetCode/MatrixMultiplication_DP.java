package LeetCode;

public class MatrixMultiplication_DP {
	public static void main(String args[]){
		int arr[] = {1,2,3,4};
		int result = matrixMul(arr);
		System.out.println(result);
	}
	
	public static int matrixMul(int arr[]){
		int len = arr.length;
		int min[][] = new int[len][len];
		
		for(int i=0; i< len ;i++){
			min[i][i] = 0;
		}
		
		for(int l=1 ; l<len ;l++){
			for(int i = 1; i<= len-l ; i++){
				int j = i+l;
				int min_num = 999999;
				for(int k =i;k<j;k++){
					if(min_num >(min[i-1][k-1] + min[k][j-1]+ (arr[i-1]*arr[k]*arr[j]))){
						min_num = (min[i-1][k-1] + min[k][j-1]+ (arr[i-1]*arr[k]*arr[j]));
					}
				}
				min[i-1][j-1] = min_num;
			}
		}
		for(int i =0; i<len ;i++){
			for(int j =0 ; j<len ;j++){
				System.out.print(min[i][j]+" ");
					
			}
			System.out.println();
		}
		
		return min[0][len-1];
	}

}

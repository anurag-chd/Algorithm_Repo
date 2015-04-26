package LeetCode;

public class UniqueBinaryTree1 {
	public static void main(String args[]){
		int n = 3;
		System.out.println(numTrees(n));
	}
	
	public static int numTrees(int num){
		int arr[] = new int[num+1];
		arr[0] = 1;
		for(int i = 1;i<=num; i++){
			for(int j = 0 ; j<i;j++){
				arr[i]+= arr[j]*arr[i-j-1];
			}
		}
		return arr[num];
	}
}

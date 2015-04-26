package PracticeQues;

public class LongestSubsequenceSum {
	public static void main(String args[]){
		int arr[] = {1,-4,5,7};
		findMax(arr);
	}
	public static void findMax(int arr[]){
		int len = arr.length;
		int result[] = new int[len];
		result[0] = arr[0];
		boolean in_sequence_flag = true;
		for(int i = 1; i< len ;i++){
			if(in_sequence_flag &&  result[i-1] < result[i-1]+ arr[i]){
				result[i] = result[i-1]+ arr[i];
			}
			if(result[i-1]> result[i-1]+ arr[i]){
				result[i] = result[i-1];
				in_sequence_flag = false;
			}
			
			if(!in_sequence_flag && result[i-1] < arr[i]){
				result[i] = arr[i];
				in_sequence_flag = true;
			}
			
		}
		System.out.println(result[len-1]);
	}
}

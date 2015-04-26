package LeetCode;

public class ReverseString {
	public static void main(String args[]){
		String str = "anurag choudhary";
		String ans = reverse(str);
		System.out.println(ans);
	}
	
	public static String reverse(String str){
		int start = 0;
		
		
		int end = str.length()-1;
		char arr[] = str.toCharArray();
		while(start <= end){
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i =0 ; i< arr.length ; i++)
			sb.append(arr[i]);
		return sb.toString();
		
	}

}

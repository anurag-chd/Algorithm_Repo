package LeetCode;

public class DecodeWays {
	public static void main(String args[]){
		String str = "01";
		System.out.println(numDecoding(str));
	}
	
	public static int numDecoding(String str){
		if(str == null || str.length() == 0)
			return 0;
		int arr[] = new int[str.length()];
		int len = str.length();
		if(str.charAt(len-1) != '0'){
			arr[len-1] = 1;
		}
		
		if(len >=2){
			if(Integer.valueOf(str.substring(len-2,len))>=10 && Integer.valueOf(str.substring(len-2,len))<=26){
				arr[len-2] = arr[len-1] +1;
			}
			else
				arr[len-2] = arr[len-1];
		}
		
		for(int i = len-3; i>=0 ;i--){
			if(str.charAt(i) != '0'){
				arr[i] = arr[i+1];
			}
			int num = Integer.valueOf(str.substring(i,i+2));
			if(num >=10 && num <=26)
				arr[i]+= arr[i+2];
		}
		
		return arr[0];
		
				
	}
}

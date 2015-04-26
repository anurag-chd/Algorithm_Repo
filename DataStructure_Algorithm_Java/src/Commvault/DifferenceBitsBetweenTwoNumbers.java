package Commvault;

public class DifferenceBitsBetweenTwoNumbers {
	public static void main(String args[]){
		int a = 31;
		int b = 14;
		System.out.println(getBitDiff(a,b));
	}
	
	public static int getBitDiff(int a, int b){
		int count = a ^ b;
		int result = 0;
		for(int i = 0 ; i< 32 ; i++){
			if((count & 1<<i) >0)
				result++;
		}
		return result;
	}

}

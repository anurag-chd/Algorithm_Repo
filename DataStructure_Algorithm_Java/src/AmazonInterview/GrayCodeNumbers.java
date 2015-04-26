package AmazonInterview;

public class GrayCodeNumbers {
	public static void main(String args[]){
		int num1 = 1;
		int num2 = 10;
		System.out.println(isGrayCode(num1,num2));
	}
	
	public static boolean isGrayCode(int num1, int num2){
		if(num1 == num2)
			return false;
		int num3 = num1 ^ num2;
		if(num3 == 0)
			return false;
		return (num3|(num3-1)) == (2*num3 -1)? true:false;
	}

}

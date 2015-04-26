package Basics;

public class Add2Num_Bits {
	public static void main(String args[]){
		//int a = 4 , b = 9;
		String str1 = "101";
		String str2 = "11";
		int a = Integer.parseInt(str1);
		int b = Integer.parseInt(str2);
		int sum = calSum(a,b);
		System.out.println(sum);
	}
	
	public static int calSum(int a, int b){
		if(b ==0)
			return a;
		int sum = a ^ b;
		int carry = (a & b) <<1;
		return calSum(sum,carry);
	}
}

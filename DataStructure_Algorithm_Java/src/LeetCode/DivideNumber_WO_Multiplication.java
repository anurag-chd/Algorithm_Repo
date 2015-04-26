package LeetCode;

public class DivideNumber_WO_Multiplication {
	public static void main(String args[]){
		int dividend = 10;
		int divisor = 2;
		System.out.println(divide(dividend,divisor));
	}
	
	public static int divide(int dividend , int divisor){
		if(divisor == 0){
			return Integer.MAX_VALUE;
		}
		if(dividend == 0)
			return 0;
		
		Long p = Math.abs((long)dividend);
		Long q = Math.abs((long)divisor);
		int result = 0;
		while(p >= q){
			int counter = 0;
			while(p >= q <<counter)
				counter++;
			result += 1<<(counter-1);
			p -= q<<(counter-1);
			
		}
		if((dividend <0 && divisor <0) ||(dividend > 0 && divisor > 0))
			return result;
		else
			return -result;
		
	}
}

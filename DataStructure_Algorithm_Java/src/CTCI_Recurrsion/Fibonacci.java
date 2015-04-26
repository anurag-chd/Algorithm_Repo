package CTCI_Recurrsion;

public class Fibonacci {
	public static void main(String args[]){
		int number = 20;
		Fibonacci fib = new Fibonacci();
		
		// Recurrsive Solution
		long startTime1 = System.nanoTime();
		int result1 = fib.getFib_Recur(number);
		long endTime1 = System.nanoTime();
		long result_time1 =  endTime1-startTime1;
		System.out.println("Recurrsion Fibonacci execution time" + result_time1);
		System.out.println(result1);
		
		// DP solution
		long startTime2 = System.nanoTime();
		int result2 = fib.getFib_DP(number);
		long endTime2 = System.nanoTime();
		long result_time2 =  endTime2-startTime2;
		System.out.println("DP Fibonacci execution time" + result_time2);
		System.out.println(result2);
	}
	
	public int getFib_Recur(int number){
		if(number == 0){
			return 0;
		}
		if (number == 1){
			return 1;
		}
		else{
			return (getFib_Recur(number-1) + getFib_Recur(number -2));
		}
	}
	
	public int getFib_DP(int number){
		if(number == 0)
			return 0;
		int fib_arr[] = new int [number];
		fib_arr[0] = 1;
		fib_arr[1] = 1;
		
		for(int i =2; i< number ;i++)
			fib_arr[i] = fib_arr[i-1] + fib_arr[i-2];
	
		return fib_arr[number-1];
	}
	
	

}

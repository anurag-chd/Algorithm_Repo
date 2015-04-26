package LeetCode;

public class Sqrt_BinarySearch {
	public static void main(String args[]){
		int num = 8;
		System.out.println(sqrt(num));
	}
	
	public static int sqrt(int num){
		if(num == 0 || num == 1)
			return num;
		long i = 0;
		long j = num/2 +1;
		while(i<j){
			long mid = (i+j)/2;
			if(mid * mid == num)
				return (int)mid;
			if(mid * mid > num)
				j = mid-1;
			else
				i = mid +1;
		}
		
		return (int)j;
	}
}

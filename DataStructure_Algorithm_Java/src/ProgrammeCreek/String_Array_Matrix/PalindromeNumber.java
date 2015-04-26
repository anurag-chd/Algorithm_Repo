package ProgrammeCreek.String_Array_Matrix;

public class PalindromeNumber {
	public static void main(String args[]){
		int x = -2147447412;
		System.out.println(isPlaindrome(x));
	}
	
	public static boolean isPlaindrome(int x){
		if(x <10 && x > -10)
			return true;
		if(x > Integer.MAX_VALUE || x< Integer.MIN_VALUE)
			return false;
		int res = revInt(x);
		return res==x?true:false;
	}
	
	public static int revInt(int num){
		int sign = num>0?1:-1;
		num = num * sign;
		int ret = 0;
		while(num > 0){
			ret = ret *10;
			if(ret < 0 || (num >10 && ret*10/10 != ret)) // to check overflow
					return 0;
			ret = ret + num%10;
			num = num/10;
		}
		return sign * ret;
	}

}

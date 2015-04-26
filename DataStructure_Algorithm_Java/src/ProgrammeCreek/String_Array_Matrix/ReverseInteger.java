package ProgrammeCreek.String_Array_Matrix;

public class ReverseInteger {
	public static void main(String args[]){
		int num = 1999999999;
		int num2 = 1999999999;
		
		System.out.println(revInt(num));
	}
	/**
	 * check sign of the num and keep it as a variable to multiply with the result
	 * -> the overflow can be checked if 
	 * 		the ans becomes < 0 when multiplied by 10
	 * 		or, if num >10 && if 10*ans/10 != ans
	 * 
	 * @param num
	 * @return
	 */
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

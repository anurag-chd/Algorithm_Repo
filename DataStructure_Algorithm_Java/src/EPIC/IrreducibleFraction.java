package EPIC;

public class IrreducibleFraction {
	public static void main(String args[]){
		double  num= 0.35;
		System.out.println(getIrreducible(num));
	}
	
	public static String getIrreducible(double num){
		if(num == 0)
			return String.valueOf(0);
		int num1 = (int)(num *10000);
		int num2 = 10000;
		int gcd = getGCD(num1,num2);
		System.out.println(gcd);
		return num1/gcd +"/" + num2/gcd;
		
		
	}
	
	public static int getGCD(int a, int b){
		if(a == 0)
			return b;
		while(a!=b){
			if(a > b)
				a = a-b;
			else if(a <b)
				b = b -a;
			else
				return a;
		}
		return a;
	}
}

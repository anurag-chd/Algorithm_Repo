package ProgrammeCreek.String_Array_Matrix;

public class PowerFunction {
	public static void main(String args[]){
		double x = 2;
		int n = 3;
		System.out.println(pow(x,n));
	}
	
	public static double pow(double x, int n){
		double temp;
		if(n == 0)
			return 1;
		if(n == 1)
			return x;
		temp = pow(x,n/2);
		if(n%2 == 0){
			return temp*temp;
		}
		else{
			if(n >0)
				return temp*temp*x;
			else
				return (temp*temp)/x;
		}
	}
}

package PracticeQues;

public class ReduceFraction {
	public static void main(String args[]){
		int num2 = 15;
		int num1 = 25;
		
		reducedFraction(num1,num2);
	}
	
	public static void reducedFraction(int num1, int num2){
		if(num2 == 0)
			System.out.println(Double.POSITIVE_INFINITY);
		int a = num1, b = num2, temp;
		temp = a%b;
		while(temp!=0){
			a = b;
			b = temp;
			temp = a%b;
		}
		System.out.println(" "+(num1/b)+"/"+(num2/b));
		
	}
}

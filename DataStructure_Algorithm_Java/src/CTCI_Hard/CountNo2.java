package CTCI_Hard;

public class CountNo2 {
	public static void main(String args[]){
		int num = 339;
		int result = calNo2(num);
	}
	
	public static int calNo2(int num){
		if(num<2){
			return 0;
		}
		int result = 0;
		int power10 = 1;
		while(power10*10<num){
			power10 = power10*10;
		}
		return result;
		
	}
}

package CTCI_Bits;

public class Num_Changed_Bits {
	public static void main(String args[]){
		int a = 9, b =7;
		int result = findBits(a,b);
		int result1 = findBits1(a,b);
		System.out.println(result1);
	}
	
	
	public static int findBits(int a, int b){
		int count =0;
		int c;
		for(c = a^b;c!=0;c= c & (c-1)){
			count++;
			
		}
		return count;
	}
	
	public static int findBits1(int a, int b){
		int count =0;
		int c;
		for(c = a^b;c!=0;c= c>>1){
			if((c&1) == 1)
			count++;
			
		}
		return count;
	}
	
}

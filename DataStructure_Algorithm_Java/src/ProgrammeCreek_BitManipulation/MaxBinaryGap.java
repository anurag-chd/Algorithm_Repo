package ProgrammeCreek_BitManipulation;

public class MaxBinaryGap {
	public static void main(String args[]){
		int n = 10;
		System.out.println(getMaxBinaryGap(n));
	}
	
	public static int getMaxBinaryGap(int n){
		int max = 0;
		int count = -1;
		int r = 0;
		while(n > 0){
			r = n & 1;
			n = n>>1;
			
			if(r == 0 && count >-1){
				count++;
			}
			else{
				if(count > -1){
					max = max>count?max:count;
				}
				count =0;
			}
		}
		return max;
	}
}

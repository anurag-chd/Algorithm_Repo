package Commvault;

public class NextSmallest_Biggest_Same_1_Bits {
	public static void main(String args[]){
		int num = 11;
		int nextMax = getMax(num);
		int nextMin = 0/*getMin(num)*/;
		
		System.out.println("Max "+ nextMax+" , Min "+ nextMin);
	}
	
	public static int getMax(int num){
		//int x = 1;
		int first1 = 0;
		while(first1 <32){
			 
			 if((num & (1<<first1))>0){
				 break;
			 }
			 first1++;
		}
		int num1 = 0;
		
		int first0 = first1 +1;
		while(first0 < 32){
			
			if((num & (1<<first0)) == 0){
				break;
			}
			num1++;
			first0++;
		}
		
		num = num | 1<<first0;
		
		num = num >>first0;
		num = num <<first0;
		
		int ones = (1 << num1) -1;
		
		return num | ones;
	}

}

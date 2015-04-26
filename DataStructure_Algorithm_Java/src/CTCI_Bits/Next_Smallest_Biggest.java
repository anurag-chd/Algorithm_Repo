package CTCI_Bits;

public class Next_Smallest_Biggest {
	public static void main(String args[]){
		int num = 19;
		//int bigger = nextBiggest(num);
		int smaller = nextSmaller(num);
		//System.out.println(bigger);
		System.out.println(smaller);
	}
	
	public static int nextBiggest(int num){
		int temp = num;
		int num_1 = 0;
		int i =0;
		while(true){
			if((temp & (1<<i)) != 0){
				num_1 ++;	
				if((temp & (1<<(i+1))) == 0){
					temp = temp | (1<<(i+1));
					temp = temp>>i+1;
					temp = temp<<i+1;
					int a = 1<<(num_1-1);
					int b = a-1; 
					temp = temp |b;
					break;
				}
				
			}
			i++;	
				
		}
		
		return temp;
	}
	
	public static int nextSmaller(int num){
		int temp = num;
		int num_1 = 0;
		int i =0;
		
		
	
		while(true){
			if((temp &(1<<i)) == 0){
				
				if((temp & (1<<(i+1))) != 0){
					num_1++;
					temp = temp>>(i+2);
					temp = temp<<(i+2);
					
					//temp = temp |(1<<(i));
					
					int a = 1;
					for(int j = 1;j<num_1;j++){
						a = a |1<<j;
					}
					
					a = a<<i-(num_1-1);
					System.out.println(a);
					
					//a = (a<<(i-num_1));
					temp = temp | a;
					break;
				}
			}
			else{
				num_1++;
			}
			i++;
			
		}
			
		
		return temp;
	}
}

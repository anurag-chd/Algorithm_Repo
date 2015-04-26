
package CTCI_Bits;

public class SwapEvenOd {
	public static void main(String args[]){
		int num = 9;
		int result =swapBits(num);
		System.out.println(result);
	}
	
	public static int swapBits(int num){
		int num_bits =0;
		for(int i =0;i<32;i++){
			double a = Math.pow(2,i);
			if(a<=num){
				num_bits++;
				
			}
			else{
				break;
			}
				
		}
		int temp = num;
		for(int i =0;i<num_bits;i++){
			if(i%2 == 0){
				if((num & (1<<i)) ==0){
					if((num & (1<<i+1)) !=0){
						temp = temp | 1<<i;
					}
				}
				else{
					if((num & (1<<i+1)) ==0){
						int a =~0;
						a = a - (1<<i);
						temp = temp & a;
					}
				}
			}
			else{
				if((num & (1<<i)) ==0){
					if((num & (1<<i-1)) !=0){
						temp = temp | 1<<i;
					}
				}
				else{
					if((num & (1<<i-1)) ==0){
						int a =~0;
						a = a - (1<<i);
						temp = temp & a;
					}
				}
				
			}
		}
	return temp;
	
	}
	

}

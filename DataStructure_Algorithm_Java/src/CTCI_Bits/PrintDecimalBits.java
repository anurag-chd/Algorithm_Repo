package CTCI_Bits;

public class PrintDecimalBits {
	public static void main(String args[]){
		double n = .25;
		printBits(n);
	}
	
	public static void printBits(double num){
		if(num >= 1 || num <= 0){
			System.out.println("error");
			return;
		}
		else{
			StringBuilder sb= new StringBuilder();
			sb.append(".");
			while(num>0){
				if(sb.length()>=32){
					System.out.println("error");
					return;
				}
				else{
					double r = 2*num;
					if(r>=1){
						sb.append("1");
						num = r-1;
					}
					else{
						sb.append("0");
						num = r;
					}
					
					
				}
			}
			System.out.println(sb.toString());
			
		}
	}
}

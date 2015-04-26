package CTCI_Bits;

public class InsertM_in_N {
	public static void main(String args[]){
		int m = 16 , n= 5, i= 1, j=3;
		 //m = insert(m,n,i,j);
		 m = insert2(m,n,i,j);
		//m = updatebits(m, n, i, j);	
		 System.out.println(m);
	}
	
	public static int insert2(int m, int n, int i, int j ){
		int temp = m;
		temp = temp>>j;
		temp = temp<<(j-i);
		
		temp = temp | n;
		temp = temp << i;
		m = m | temp;
		return m;
	}
	
	public static int insert(int m,int n, int i, int j){
		int temp = m;
		int temp2 = n;
		int k = 1;
		for(int a =i ; a<= j ;a++){
			//k= k<<a;
			temp = temp | k<<a;
			System.out.println(temp);
			
		}
		//System.out.println(temp);
		for(int b = 0; b<=i;b++){
			temp2 = temp2<<b;
			temp2 = temp2|1; 
		}
		System.out.println(temp2);
		int c = 1;
		for(int b = j+1;b<31;b++ ){
			//c = c<<b;
			temp2 = temp2|(1<<b);
			//System.out.println(temp2);
		}
		//System.out.println(temp2);
		return temp & temp2;
				
	}
	
	public static int updatebits(int m,int n, int i, int j ){
		int max =~0;
		int left = max -((1<<j)-1);
		int right = ((1 << i) - 1);
		int mask = left | right;
		return (m & mask) | (n << i);
	}
}

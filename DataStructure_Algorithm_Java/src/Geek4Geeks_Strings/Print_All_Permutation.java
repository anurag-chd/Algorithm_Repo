package Geek4Geeks_Strings;

public class Print_All_Permutation {
	public static void main(String args[]){
		String str = "abc";
		char str_arr[] = str.toCharArray();
		printAllPermute(str_arr,0,str.length()-1);
	}
	
	public static void printAllPermute(char char_arr[], int i, int n){
		int j;
		if(i == n){
			System.out.println(char_arr);
		}
		else{
			for(j = i;j<=n;j++){
				swap(char_arr,i,j);
				System.out.print("First swap "+i+" "+j+" ");
				System.out.println(char_arr);
				printAllPermute(char_arr,i+1,n);
				swap(char_arr,i,j);
				System.out.print("Second swap "+i+" "+j+" ");
				System.out.println(char_arr);
			}
		}
		
	}
	
	public static void swap(char arr[], int i, int j){
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

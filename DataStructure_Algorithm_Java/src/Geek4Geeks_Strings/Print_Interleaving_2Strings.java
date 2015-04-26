package Geek4Geeks_Strings;

public class Print_Interleaving_2Strings {
	public static void main(String args[]){
		String str1 = "AB";
		String str2 = "CD";
		
		printALL(str1,str2);
	}
	
	public static void printALL(String str1, String str2){
		int m = str1.length(); // length of the first string
		int n = str2.length(); // length of the second string
		
		char [] str1_arr = str1.toCharArray();
		char [] str2_arr = str2.toCharArray();
		char [] istr_arr = new char[m+n];
		
		printInter(str1_arr, str2_arr, istr_arr, m, n,0,0,0);
	}
	
	public static void printInter(char [] str1 , char[] str2 , char[] inter_str , int m, int n, int i, int index1, int index2){
		if(m ==0 && n ==0)
			System.out.println(inter_str);
		if(m != 0){
			inter_str[i] = str1[index1];
			printInter(str1,str2,inter_str,m-1,n,i+1,index1+1,index2);
		}
		if(n != 0){
			inter_str[i] = str2[index2];
			printInter(str1,str2,inter_str,m,n-1,i+1,index1,index2+1);
		}
		
	}
}

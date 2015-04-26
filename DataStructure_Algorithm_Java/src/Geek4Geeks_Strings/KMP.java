package Geek4Geeks_Strings;

public class KMP {
	public static void main(String args[]){
		String text = "ABABDABACDABABCABAB";
		String patt = "ABABCABAB";
		
		kmpSearch(text,patt);
	}
	
	public static void kmpSearch(String text, String patt){
		int m = text.length();
		int n = patt.length();
		int j =0;
		//longest prefix
		int lps[] = new int[n];
		
		// calculate longest prefix substring array
		createLPS(patt,lps);
		for(int i : lps)
			System.out.print(i+" ");
		System.out.println();
		char pat_arr[] = patt.toCharArray();
		char txt_arr[] = text.toCharArray();
		int i= 0;
		while(j<m){
			if(pat_arr[i] == txt_arr[j]){
				i++;
				j++;
			}
			else if(pat_arr[i] != txt_arr[j]){
				if(i != 0)
					i = lps[i-1];
				else
					j++;
			}
			if(i == n){
				System.out.println("Index of matching pattern : "+(j-i));
			//	i = lps[i-1];
			}
		}
	}
	
	
	public static void createLPS(String patt, int[]lps){
		int len =0;
		char pat_arr[] = patt.toCharArray();
		lps[0] =0;
		int i =1;
		while(i< patt.length()){
			if(pat_arr[i] ==pat_arr[len]){
				lps[i++] = ++len;
			}
			else{
				if(len!=0){
					len = lps[len-1];
				}
				else{
					lps[i] = 0;
					i++;
				}
			}
		}
		
	}
}

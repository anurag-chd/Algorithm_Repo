package Geek4Geeks_Strings;

import java.util.Arrays;
import java.util.Collections;

public class AllPermutation_String {
	public static void main(String srgs[]){
		String str = "ABC";
		getAllPerm(str);
	}
	
	public static void getAllPerm(String str){
		char []str_arr = str.toCharArray();
		Arrays.sort(str_arr);
		char []display_arr =  str.toCharArray();
		display(str_arr,display_arr,str.length()-1,0);
	}
	
	public static void display(char [] str_arr, char[] display_arr, int last, int index){
		int len = str_arr.length;
		for(int i =0 ; i< len;i++){
			display_arr[index] = str_arr[i];
			
			if(index == last){
				System.out.println(display_arr);
			}
			else{
				display(str_arr,display_arr,last,index+1);
			}
		}
	}
}

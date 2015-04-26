package EPIC;

import java.util.Vector;

public class Phone {
	public static void main(String args []){
		int n = 3;
		printPhoneNum(n);
		
	}
	public static void printPhoneNum(int n){
		char num [] =  new char[n];
		int index = 0;
		printNum(num,index,n);
	}
	public static void printNum(char[] num, int index, int n){
		if(index == n){
			System.out.println(num);
			return;
		}
		for(int i = 0; i< 10;i++){
			if(index == 0){
				num[index] = String.valueOf(i).charAt(0);
				printNum(num,index+1,n);
			}
			else if(index >0 && i != 4 && !(String.valueOf(i).charAt(0)==num[index-1])){
				num[index] = String.valueOf(i).charAt(0);
				printNum(num,index+1,n);
			}
			else if(index >0 && num[0]== '4' && !(String.valueOf(i).charAt(0)==num[index-1])){
				num[index] = String.valueOf(i).charAt(0);
				printNum(num,index+1,n);
			}
			
		}
			
		
	}
}
		
		
		
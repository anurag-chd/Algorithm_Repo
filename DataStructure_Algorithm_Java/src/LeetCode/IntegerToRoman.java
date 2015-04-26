package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class IntegerToRoman {
	public static void main(String args[]){
		int num = 299;
		System.out.println(intToRoman(num));
	}
	
	public static String intToRoman(int num){
		if(num < 1)
			return null;
		int [] integer = {1000,900,  500,400, 100  ,90,  50,40,10,9,5,4,1};
		String[] roman = {"M", "CM", "D","CD","C", "XC","L","XL", "X", "IX","V","IV", "I"};
		
		StringBuilder s = new StringBuilder();
		for(int i = 0; i<integer.length ;i++){
			int q = num/integer[i];
			while(q > 0){
				s.append(roman[i]);
				q--;
			}
			num = num%integer[i];
		}
		
		return s.toString();
		
		
		
	}
}

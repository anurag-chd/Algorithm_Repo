package LeetCode;

import java.util.ArrayList;

public class MultiPlyStrings {
	public static void main(String args[]){
		String str1 = "12";
		String str2 = "13";
		System.out.println(multiply(str1,str2));
		
	}
	
	public static String multiply(String num1, String num2){
		ArrayList<String> list = new ArrayList<>();
		for(int i = num2.length()-1 ;i>=0 ; i--){
			String s = new String("");
			mulStrings(num1,num2.substring(i,i+1),s);
			int j = i;
			while(j<num2.length()-1){
				s = s+"0";
				j++;
			}
			list.add(s);
		}
		String result = list.get(0);
		for(int i = 1; i< list.size();i++){
			result = addString(result,list.get(i));
		}
		
		return result;
		
	}
	
	public static String addString(String str1, String str2){
		String result = new String("");
		int carry = 0;
		int len1 = str1.length();
		int len2 = str2.length();
		
		if(len1 > len2){
			int i = 1;
			while(i<len2){
				int sum = Integer.parseInt(str1.substring(len1-i,len1-i+1)) + Integer.parseInt(str2.substring(len2-i,len2-i+1));
				if(sum >9){
					carry = sum%10;
					sum = sum/10;
					result = sum + result;
				}
				else{
					carry = 0;
					result = sum + result;
				}
			}
			int carrySum = carry + Integer.parseInt(str1.substring(len1-i,len1-i+1));
			result = carrySum + result;
			result = str1.substring(0,len1-i);
			
		}
		return result;
	}
	
	public static void mulStrings(String num1, String num2, String s){
		int n2 = Integer.parseInt(num2);
		int n1;
		int carry = 0;
		for(int i = num1.length()-1; i>0 ;i--){
			n1 = Integer.parseInt(num1.substring(i,i+1));
			int result = (n1 * n2) + carry;
			if(result>9){
				carry = result %10;
				result = result/10;
				s = String.valueOf(result)+s;
			}
			else{
				carry = 0;
				s = String.valueOf(result)+s;
			}
		}
	}
}

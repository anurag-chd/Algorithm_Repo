package Geek4Geeks_Strings;

public class Remove_Duplicates_Recurrsive {

	public static void main(String args[]){
		String  str = "abcddeffg";
		String str1 = "acbddbc";
		str = removeDuplicate(str);
		System.out.println(str);
	}
	
	public static String removeDuplicate(String str){
		if(str.length()<=1){
			return str;
		}
		else if(str.length() == 2){
			if(str.charAt(0) == str.charAt(1))
				return "";
			else
				return str;
		}
		else{
			System.out.println(str);
			for(int i = 0 ; i< str.length()-1 ;i++){
				if(str.charAt(i) == str.charAt(i+1)){
					String temp1, temp2;
					temp1 = str.substring(0,i);
					temp2 = str.substring(i+2);
					str = temp1 + temp2;
					str = removeDuplicate(str);
				}
			}
			return str;
		}
		
	}
}

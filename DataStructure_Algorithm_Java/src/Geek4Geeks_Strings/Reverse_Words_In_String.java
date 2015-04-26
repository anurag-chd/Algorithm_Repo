package Geek4Geeks_Strings;

public class Reverse_Words_In_String {
	public static void main(String args[]){
		String str = "My name is XYZ";
		char arr[] = str.toCharArray();
		wordRev(arr);
	}
	
	public static void wordRev(char[] str){
		int start =0;
		int end = str.length-1;
		reverse(str,start,end);
		start =0;
		for(int i =start + 1;i<str.length;i++){
			if(str[i] == ' '){
				reverse(str,start,i-1);
				start = i+1;
			}
		}
		reverse(str,start,str.length-1);
		for(int i =0;i< str.length;i++){
			System.out.print(str[i]);
		}
	}
	
	public static void reverse(char[] str, int start, int end){
		while(start<end){
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
}

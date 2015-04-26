package ProgrammeCreek.String_Array_Matrix;

public class ReverseWordsString {
	public static void main(String args[]){
		String s = new String(" 1");
		s = reverseWords(s);
		System.out.println(s);
	}
	public static String reverseWords(String s){
		if(s == null || s.length() == 0)
			return "";
		String strArr[] = s.split(" ");
		StringBuilder sbr = new StringBuilder();
		for(int index = strArr.length-1;index >=0; index--){
			if(!(strArr[index].equals(""))){
				sbr = sbr.append(strArr[index]).append(" ");
			}
		}
		return sbr.length()==0?"" : sbr.substring(0,sbr.length()-1);
		
		
		
	}
	
	public static String reverseString(String s){
		char [] charArr = s.toCharArray();
		int start = 0;
		int end = charArr.length-1;
		while(start<end){
			if(charArr[start] == charArr[end]){
				start++;end--;
			}
			else{
				char temp = charArr[start];
				charArr[start] = charArr[end];
				charArr[end] = temp;
				start++;
				end--;
			}
			
		}
		s = new String(charArr);
		charArr = null;
		return s;
	}
}

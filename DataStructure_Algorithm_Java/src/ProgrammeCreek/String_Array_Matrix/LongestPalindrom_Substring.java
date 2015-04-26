package ProgrammeCreek.String_Array_Matrix;

public class LongestPalindrom_Substring {
	public static void main(String args[]){
		String str = "annurag";
		System.out.println("Longest Palindrome Substring : " + calPalindrome(str) );
	}
	
	public static String calPalindrome(String str){
		if(str == null){
			return null;
		}
		if(str.length() == 1){
			return str;
		}
		
		String result = str.substring(0,1);
		for(int index = 1; index < str.length(); index++){
			String oddPalin = createOddPalin(str,index); // to create the odd palindrome 
			String evenPalin = createEvenPalin(str,index); // to create the even palindrome
			String tmp = null;
			tmp = oddPalin.length()>evenPalin.length() ? oddPalin : evenPalin;
			result = result.length()> tmp.length() ? result : tmp;
		}
		
		return result;
	}
	
	public static String createOddPalin(String str, int index){
		int start = index -1;
		int end = index + 1;
		String result = str.substring(index,index+1);
		while(start >= 0 && end< str.length()){
			if(str.charAt(start) == str.charAt(end)){
				result = str.substring(start,end+1);
				start--;
				end++;
			}
			else{
				break;
			}
		}
		return result;
	}
	
	public static String createEvenPalin(String str, int index){
		int start = index;
		int end = index+1;
		String result = str.substring(index,index+1);
		while(start >= 0 && end< str.length()){
			if(str.charAt(start) == str.charAt(end)){
				result = str.substring(start,end+1);
				start--;
				end++;
			}
			else{
				break;
			}
		}
		return result;
	}
}
package ProgrammeCreek.String_Array_Matrix;

public class Substring_String {
	public static void main(String args[]){
		String text = "mississippi";
		String pat = "issip";
		System.out.println("the patt is at index : "+ strStr(text,pat));
	}
	public static int strStr(String haystack, String needle){
		if(haystack == null )
		    return -1;
		if((haystack.length() == 0 && needle.length() != 0) )	
	    return -1;
		if(needle.length() == 0 || needle == null)    
	    return 0;
		int patLen = needle.length();
		int textLen = haystack.length();
		
		int patIndex = 0;
		for(int index =0 ; index < textLen ; index++){
			if(index == (textLen - patLen +1) && patIndex ==0)
				return -1;
			if(haystack.charAt(index) != needle.charAt(patIndex)){
				index = index - patIndex;
				patIndex = 0; 
				
			}
			else{
				patIndex++;
				if(patIndex == patLen)
					return index - patLen +1;
			}
		}
		return -1;
	}
}

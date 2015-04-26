package ProgrammeCreek.String_Array_Matrix;

public class LongestSubstringWORepeatingChars_CharArr {
	public static void main(String args[]){
		String s = "anurag";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s){
		if(s == null || s.length()<2)
			return s.length();
		
		boolean charFlag[] = new boolean[256];
		int start =0;
		int result = 0;
		
		for(int index = 0 ; index < s.length(); index++){
			char c = s.charAt(index);
			if(charFlag[c]){
				result = Math.max(result,index - start);
				for(int k = start; k< index ; k++){
					if(c == s.charAt(k)){
						start = k+1;
						break;
					}
					else{
						charFlag[s.charAt(k)] = false;
					}
				}
			}
			else{
				charFlag[c] = true;
			}
		}
		return Math.max(result,s.length()-start);
	}
}

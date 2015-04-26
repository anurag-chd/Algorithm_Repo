package ProgrammeCreek.String_Array_Matrix;

public class LongestSubString_2UniqueChars {
	public static void main(String args[]){
		String str = "abcbbbbcccbdddadacb";
		System.out.println(getLongestSubString(str));
	}
	
	public static String getLongestSubString(String str){
		if(str == null || str.length()<2)
			return str;
		boolean charFlag [] = new boolean[256];
		int result =0;
		int strStart = 0,strEnd = 0;
		int count = 0;
		int start = 0;
		for(int end = 0; end < str.length();end++){
			if(!charFlag[str.charAt(end)]){
				if(count <2){
					count++;
				}
				else{
					char c = str.charAt(end-1);
					for(int k = end-2; k>=start;k--){
						if(str.charAt(k) != c){
							if(result < end -start){
								result = end - start;
								strStart = start;
								strEnd = end;
							}
							start = k+1;
							break;
						}
					}
				}
				charFlag[str.charAt(end)] = true;
			}
			else{
				
			}
		}
		if(result < str.length() -start){
			strStart = start;
			strEnd = str.length();
		}
		
		return str.substring(strStart,strEnd);
	}
}

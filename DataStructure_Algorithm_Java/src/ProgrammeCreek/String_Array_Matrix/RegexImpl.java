package ProgrammeCreek.String_Array_Matrix;

public class RegexImpl {
	public static void main(String args[]){
		String str = "";
		String patt = ".*";
		System.out.println("Is the regex able to identify "+ str +" : "+ isMatch(str,patt));
	}
	
	public static boolean isMatch(String str, String patt){
		return Regex(str,patt,0,0);
	}
	
	public static boolean Regex(String str, String patt, int matches, int pIndex){
		if(patt.length() == 0 || (pIndex >= patt.length() && matches != str.length()) )
			return false;
		else if((matches == str.length() && pIndex == patt.length())|| (str.length() ==0 && (patt.charAt(pIndex) == '.' || patt.charAt(pIndex) == '*')) ){
			return true;
		}
		else if(matches == str.length() && pIndex < patt.length()){
		    if(str.charAt(matches-1) == patt.charAt(pIndex)){
		        return Regex(str,patt,matches,++pIndex);
		    }
		    else
		        return false;
		}
			
		else{
			if((pIndex < patt.length()-1) && patt.charAt(pIndex+1) == '*'){
				matches = starMatches(str,patt,matches,pIndex);
				pIndex = pIndex+2;
				return Regex(str,patt,matches,pIndex);
			}
			else{
				if(patt.charAt(pIndex) == '.' || patt.charAt(pIndex) == str.charAt(matches)){
					return Regex(str,patt,++matches,++pIndex);
				}
				else{
					return false;
				}
			}
		}
	}
	
	public static int starMatches(String str, String patt, int matches, int pIndex){
		if(matches >= str.length())
			return matches;
		else if(patt.charAt(pIndex) == '.' || str.charAt(matches) == patt.charAt(pIndex)){
			return starMatches(str,patt, ++matches , pIndex);
		}
		else {
			return matches;
		}
        
    }
}

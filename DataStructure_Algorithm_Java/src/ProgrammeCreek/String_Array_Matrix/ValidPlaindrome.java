package ProgrammeCreek.String_Array_Matrix;

public class ValidPlaindrome {
	public static void main(String args[]){
		String s = ".,";
		System.out.println(isPalindrome(s));
	}
	
	public static boolean isPalindrome(String s){
		 if(s == null || s.length() <=1 )
				return true;
			
			s = s.toLowerCase();
			int start = 0;
			int end = s.length()-1;
			while(start<=end){
				while(!isAlpha(s.charAt(start)) && !isNum(s.charAt(start))){
					start++;
					if(start >end)
						return true;
				}
					
				while(!isAlpha(s.charAt(end)) && !isNum(s.charAt(end)) ){
					end--;
					if(start >end)
						return true;
				}
					
				if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
					return false;
				start++;
				end--;
			}
			return true;
			
			
	}
	
	 public static boolean isAlpha(char a){
	        if((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')){
	            return true;
	        }else{
	            return false;
	        }
	    }
	 
	  public static  boolean isNum(char a){
	        if(a >= '0' && a <= '9'){
	            return true;
	        }else{
	            return false;
	        }
	    }

}

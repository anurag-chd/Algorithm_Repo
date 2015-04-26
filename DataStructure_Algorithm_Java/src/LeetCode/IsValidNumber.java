package LeetCode;

public class IsValidNumber {
	public static void main(String args[]){
		String str = "2e10";
		System.out.println(isNumber(str));
	}
	
	public static boolean isNumber(String s){
		if(s == null || s.length()<1)
			return false;
		if(s.length() == 1){
			if(s.charAt(0) <'0' && s.charAt(0) >'9')
				return false;
		}
		boolean dot = false;
		boolean numStart = false;
		boolean eflag = false;
		for(int i =0; i< s.length() ;i++){
			if(s.charAt(i) ==' ' && numStart)
				return false;
			if(s.charAt(i) >='0' && s.charAt(i) <='9')
				numStart = true;
			if(i != 0 && s.charAt(0)== '-')
				return false;
			if(s.charAt(i) =='.' && !dot){
				dot = true;
			}
			else if(s.charAt(i) <'0' || s.charAt(i) >'9')
				if(s.charAt(i) == 'e' && eflag)
					return false;
				else if(s.charAt(i) == 'e' && !eflag)
					eflag = true;
				else 
					return false;
		}
		return true;
		
	}
}

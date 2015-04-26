package ProgrammeCreek.String_Array_Matrix;

public class StringToInteger {
	public static void main(String args[]){
		String str = " -1010023630o4";
		System.out.println(Integer.MAX_VALUE +"  " + Integer.MIN_VALUE);
		int result = atoi(str);
		System.out.println(str);
		System.out.println(result);
	}
	
	public static int atoi(String str){
		if(str == null)
			return 0;
		boolean negFlag = false;
		boolean posFlag = false;
		boolean numStarted = false;
		int result = 0;
		int numLength = 0;
		for(int index =0 ; index < str.length(); index++){
			if(numLength == 9)
				System.out.println(result);
			
				
			
			if(numStarted == false && str.charAt(index) == '-' ){
				if(posFlag || negFlag)
					break;
				else{
					negFlag = true;
					
				}
					
			}
				
			else if(numStarted == false && str.charAt(index) == '+'){
				if(negFlag || posFlag )
					break;
				else
					posFlag = true;
				
			}
			else if(str.charAt(index) == ' '){
				if(numStarted || negFlag || posFlag)
					break;
				
			}
				
					
			else{
				int num = (int)str.charAt(index)- (int)'0';
				if( num <= 9 && num >=0){
					if(numStarted == false)
						numStarted = true;
					if(result == Integer.MAX_VALUE /10 && num > 7 && negFlag == true){
						
						return Integer.MIN_VALUE;
						
					}
					result = (result *10) + num;
					numLength++;
					if(numLength == 10 && index < str.length()-1){
						if(negFlag)
							return Integer.MIN_VALUE;
						else
						    return Integer.MAX_VALUE;
					}
				}
				else{
					break;
					//return 0;
				}
			}
		}
		if(negFlag){
			if(result < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			else
				return -1 * result;
		}
			
			
		else{
			if(result < 0)
				return Integer.MAX_VALUE;
			else
				return result;
		}
	}
	
	
}

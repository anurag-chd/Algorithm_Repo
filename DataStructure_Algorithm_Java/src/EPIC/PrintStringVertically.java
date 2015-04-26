package EPIC;

public class PrintStringVertically {
	public static void main(String args[]){
		String strArr[] = {"epic is a healthcare company.",
						   "interviewing for software developer.",
						   "print this vertically sentence by sentence."
							};
		
		printVertically(strArr);
	}
	
	public static void printVertically(String strArr[]){
		if(strArr == null || strArr.length ==0)
			return;
		int maxLen = 0;
		for(String str : strArr)
			maxLen = maxLen>str.length()?maxLen:str.length();
		
		for(int i = 0; i< maxLen ;i++){
			for(String s: strArr){
				if(i <s.length())
					System.out.print(s.charAt(i) + " ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}

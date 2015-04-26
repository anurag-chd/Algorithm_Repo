package PracticeQues;

public class AllPalindromes_Length_3 {
	public static void main(String args[]){
		String str = "forgeeksskeegfor";
		printPalin(str);
	}
	
	public static void printPalin(String str){
		for(int i =2;i< str.length();i++){
			printOddPal(str,i);
			printEvenPal(str,i);
		}
		
	}
	
	public static void printOddPal(String str, int index){
		int count = 1;
		int i = index-1;
		int j = index +1;
		while(i>0 && j<str.length()){
			if(str.charAt(i) == str.charAt(j)){
				count = count+2;
				if(count >3)
					System.out.println(str.substring(i,j+1));
				i--;
				j++;
			}
			else{
				count =1;
				break;
			}
		}
		
	}
	
	public static void printEvenPal(String str, int index){
		int count = 1;
		int i = index;
		int j = index +1;
		while(i>0 && j<str.length()){
			if(str.charAt(i) == str.charAt(j)){
				count = count+2;
				if(count >3)
					System.out.println(str.substring(i,j+1));
				i--;
				j++;
			}
			else{
				count =1;
				break;
			}
		}
		
	}
}

package LeetCode;

public class CountNumAndSay {
	public static void main(String args[]){
		int n = 10;
		System.out.println(countAndSay(n));
	}
	
	public static String countAndSay(int n){
		if(n < 0)
			return "";
		String str = String.valueOf(n);
		for(int i = 0; i< n; i++){
			str = convert(str);
		}
		return str;
	}
	
	public static String convert(String str){
		StringBuilder sbr = new StringBuilder();
		int count = 1;
		int i = 0;
		while(i < str.length()){
			int j = i+1;
			while( j < str.length()){
				if(str.charAt(i) == str.charAt(j)){
					count++;
					j++;
				}
				else{
					sbr.append(count+""+str.charAt(i));
					i = j;
					count = 1;
					break;
				}
			}
			if(i == str.length()-1){
				sbr.append(count+""+str.charAt(i));
				i++;
			}
				
		}
		return sbr.toString();
	}
}

package EPIC;

public class Encryption {
	public static void main(String args[]){
		String str = "anu";
		int n = 4;
		System.out.println(getEncryptedText(str,n));
	}
	
	public static String getEncryptedText(String str, int n){
		if(str == null || str.length() == 0 || n < 0)
			return null;
		str = str.toUpperCase();
		StringBuilder sbr = new StringBuilder();
		for(int i = 0; i< str.length() ;i++){
			int num = (int)str.charAt(i) -(int)'A' +1;
			num = (num*n)%26;
			sbr.append(Integer.toString(num));
		}
		
		return sbr.toString();
	}
}

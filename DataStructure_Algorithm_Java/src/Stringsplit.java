
public class Stringsplit {
	public static void main(String args[]){
		String str = "a.B.d";
		int i = str.indexOf('.');
		System.out.println(i);
		int len = str.length();
		String str2 = str.substring(0,i);
		if(str.charAt(len-2) == '.'){
			System.out.println(str.substring(0,len-2));
		}
		else if(str.charAt(len-3) == '.'){
			System.out.println(str.substring(0,len-3));
		}
		else {
			System.out.println(str.substring(0,len-4));
		}
		
		
		/*for(String s : arr)
		System.out.println(s);*/
	}
}

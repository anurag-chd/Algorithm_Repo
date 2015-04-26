package Vmware;

public class LongestPalin {
	public static void main(String args[]){
		String str = "abcdedca";
		int result = findLongestPalin(str);
		System.out.println(result);
	}
	
	public static int findLongestPalin(String str){
		int len = str.length();
		if(len==0)
			return 0;
		
		int result = 1;
		for(int i =0 ; i< len ;i++){
			String temp = expandpalin(str,i,i);
			int l = temp.length();
			if(l>result)
				result = l;
		}
		
		for(int i = 0; i< len;i++){
			String temp = expandpalin(str,i,i+1);
			int l = temp.length();
			if(l>result)
				result = l;
		}
		return result;
		
	
	}
	
	public static String expandpalin(String str, int left, int right){
		int i = left;
		int j = right;
		char arr[] = str.toCharArray();
		while(i>=0 && j<=arr.length-1 && arr[i] == arr[j]){
			i--;
			j++;
		}
		System.out.println(i+" "+j);
		String temp = str.substring(i+1, j);
		return temp;
	}
	
}

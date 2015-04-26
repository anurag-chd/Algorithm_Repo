package Geek4Geeks_Strings;

public class RabinKarpe {
	public static final int d= 256;
	
	public static void main(String args[]){
		String text = "GEEKS FOR GEEKS";
		String pat = "GEEK";
		
		int q= 101; // prime number
		
		search(text,pat,q);
	}
	
	public static void search(String txt, String pat, int q){
		int n = txt.length(); // length of Text
		int m = pat.length(); // length of pat
		
		char txt_char[] = txt.toCharArray();
		char pat_char[] = pat.toCharArray();
		
		int p = 0; // hash value of pattern 
		int t = 0; // has value of text pattern
		int h = 1;
		
		// The value of h would be "pow(d, M-1)%q"
		for(int i =0 ; i < m-1 ; i++){
			h = (h*d)%q;
		}
		
		// calculate the hash values of pattern and the first text window
		for(int i = 0 ; i < m ; i++){
			p = (d * i + (int)pat_char[i] ) % q;
			t = (d * i + (int)txt_char[i] ) % q;
		}
		
		//Searching the pattern in text window by window
		for(int i = 0 ; i < n-m ; i++){
			if(p == t){
				int j =0;
				for(j =0 ; j < m ; j++){
					if(txt_char[i+j] != pat_char[j])
						break;
				}
				if(j == m){
					System.out.println(i);
				}
			}
			// calculate the value of t for next slide window
			else{
				if(i < n-m){
					t = (d *(t - txt_char[i]*h) + txt_char[i+m]) %q ;
					if(t<0)
						t = t + q;
				}
				else{
					System.out.println("No matching pattern");
				}
				
			}
		}
	}

}

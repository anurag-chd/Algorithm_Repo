package LeetCode;

public class WildCardMatching {
	public static void main(String args[]){
		String s = "abc";
		String p = "*ad";
		System.out.println(isMatch(s,p));
	}
	
	 public static boolean isMatch(String s, String p) {
        if(s == null || p == null)
        	return false;
        if(s.equals(p))
        	return true;
        int m = s.length();
        int n = p.length();
        int posS = 0;
        int posP = 0;
        int posStar = -1;
        int posOfS = -1;
        while(posS < m){
        	if(posP < n && s.charAt(posS) == p.charAt(posP) && p.charAt(posP) == '?'){
        		posP++;
        		posS++;
        	}
        	else if(posP < n && p.charAt(posP) == '*'){
        		posStar = posP;
        		posOfS = posS;
        		posP++;
        		continue;
        	}
        	else if(posStar != -1){
        		posS = posOfS;
        		posP = posStar +1;
        		posOfS++;
        	}
        	else{
        		return false;
        	}
        }
        
        while(posP < n && p.charAt(posP) == '*')
        	posP++;
        
        return posP == n && posS == m;
    }
}

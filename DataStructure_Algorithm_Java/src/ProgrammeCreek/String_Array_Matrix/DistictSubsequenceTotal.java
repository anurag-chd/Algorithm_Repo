package ProgrammeCreek.String_Array_Matrix;

public class DistictSubsequenceTotal {
	public static void main(String args[]){
		String S = "rabbbit";
		String T = "rabbit";
		System.out.println(numDistincts(S,T));
	}
	
	public static int numDistincts(String S, String T){
		if(S.length() == 0 && T.length() == 0)
			return 1;
		else if(S == null || S.length() == 0)
			return 0;
		else if(T == null || T.length() == 0)
			return 1;
		
		int num[][] = new int[S.length()+1][T.length()+1];
		for(int i = 0; i<= S.length();i++)
			num[i][0]= 1;
		
		
		for(int i =1; i<= S.length() ;i++){
			for(int j =1; j<= T.length() ;j++){
				if(S.charAt(i-1) == T.charAt(j-1))
					num[i][j] += num[i-1][j-1] + num[i-1][j];
				else
					num[i][j] += num[i-1][j];
			}
		}
		return num[S.length()][T.length()];
		
	}
}

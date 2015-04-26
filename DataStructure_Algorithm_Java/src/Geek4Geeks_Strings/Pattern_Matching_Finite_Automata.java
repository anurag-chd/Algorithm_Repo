package Geek4Geeks_Strings;

public class Pattern_Matching_Finite_Automata {
	public static void main(String args[]){
		String txt = "AABAACAADAABAAABAA";
		String pat = "AABA";
		displayIndex(txt,pat);
	}
	
	public static void displayIndex(String txt, String pat){
		int m = txt.length();
		int n = pat.length();
		int TF[][] = new int[n+1][256];
		computeFA(pat,n,TF);
		System.out.println(TF[3][65]);
		int state =0;
		char [] txt_arr = txt.toCharArray();
		for(int i = 0 ; i< m ;i++ ){
			state = TF[state][(int)txt_arr[i]];
			if(state == n)
				System.out.println("Pattern found at"+ (i-n+1));
		}
	}
	
	public static void computeFA(String pat, int len, int TF[][]){
		char [] pat_arr = pat.toCharArray();
		for(int i =0;i<=len;i++){
			for(int j =0; j <256; j++)
				TF[i][j] = 0;
		}
		int state,x;
		for(state =0; state<=len; state++){
			for(x =0; x <256; x++){
				TF[state][x] = getNextState(pat_arr,state,x,len); 
			}
		}
		
		
		
	}
	
	public static int getNextState(char [] pat_arr, int state, int x , int len){
		if(state<len && ((int)pat_arr[state] == x)){
			return state+1;
		}
		else{
			for(int i = state; i>0;i--){
				if((int)pat_arr[i-1] == x){
					int j;
					for(j =0; j< i-1 ; j++){
						if(!((int)pat_arr[j] == pat_arr[state - i +1 + j])){
							break;
						}
						
					}
					if( j == i-1)
						return i;
				}
			}
		}
		return 0;
	}
}

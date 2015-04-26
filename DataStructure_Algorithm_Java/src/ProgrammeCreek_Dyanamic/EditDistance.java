package ProgrammeCreek_Dyanamic;

public class EditDistance {
	public static void main(String args[]){
		String str1 = "abc";
		String str2 = "aef";
		
		System.out.println("Edit distance between str1 and str2 "+ getEditDistance(str1,str2));
	}
	
	public static int getEditDistance(String str1,String str2){
		if(str1 == null || str1.length() == 0)
			return (str2 == null)?0:str2.length();
		else if(str2 == null || str2.length() == 0)
			return (str1 == null)?0:str1.length();
		int matrix [][] = new int[str1.length()+1][str2.length()+1];
		int len1 = str1.length();
		int len2 = str2.length();
		
		for(int i =0 ; i<= len1; i++)
			matrix [i][0] = i;
		
		for(int j =0 ; j<= len2; j++)
			matrix [0][j] = j;
		
		for(int i =1 ; i<= len1;i++){
			for(int j = 1; j<= len2; j++){
				if(str1.charAt(i-1) == str2.charAt(j-1))
					matrix[i][j] = matrix[i-1][j-1];
				else{
					matrix[i][j] = 1+ Math.min(Math.min(matrix[i-1][j-1],matrix[i-1][j]), matrix[i][j-1]);
				}
			}
		}
		return matrix[len1][len2];
	}
}

package EPIC;

public class RedBlueGame {
	public static void main(String args[]){
		char arr[][] = { { 'r', 'r', 'r', 'b' }, { 'b', 'r', 'b', 'r' },
				{ 'b', 'r', 'r', 'b' }, { 'b', 'r', 'b', 'b' } };
		int redCount = findCount(arr,'r');
		int blueCount = findCount(arr,'b');
		
		System.out.println("Red Count "+ redCount);
		System.out.println("Blue Count "+ blueCount);
		
	}
	
	public static int findCount(char arr[][], char c){
		int count = 0;
		for(int i = 0; i<arr.length;i++){
			for(int j = 0; j<arr.length ;j++){
				if(arr[i][j] == c){
					if(i < arr.length-2 && arr[i+1][j] ==c && arr[i+2][j] == c)
						count++;
					if(j < arr[0].length-2 && arr[i][j+1] == c && arr[i][j+2] == c)
						count++;
					if(i< arr.length-2 && j < arr[0].length-2 && arr[i+1][j+1] == c && arr[i+2][j+2] == c)
						count++;
					if(i>1 && j >1  && arr[i-1][j-1] == c && arr[i-2][j-2] == c)
						count++;
				}
			}
		}
		
		return count;
	}

}

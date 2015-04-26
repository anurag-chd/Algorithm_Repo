package EPIC;

public class WellOrderedString {
	public static void main(String args[]){
		int num = 3;
		char cArr[] = new char[num];
		getWellOrderedString(cArr,0);
	}
	
	public static void getWellOrderedString(char[] arr, int index){
		if(index == arr.length){
			System.out.println(arr);
			return;
		}
		
		for(int i = 'a' ; i<='z' ;i++){
			if(index == 0 && i < 'x'){
				arr[index] = (char)i;
				getWellOrderedString(arr,index+1);
			}
			else if(index > 0 &&(char)i > arr[index-1] ){
				arr[index] = (char)i;
				getWellOrderedString(arr,index+1);
			}
			
		}
		
	}
	
	
}

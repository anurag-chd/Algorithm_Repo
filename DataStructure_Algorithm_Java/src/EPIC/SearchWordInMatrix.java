package EPIC;

public class SearchWordInMatrix {
	public static void main(String args[]){
		char arr[][] ={	{'a','b','c','d'},
					 	{'e','f','g','h'},
					 	{'i','j','k','l'},
					 	{'m','n','j','p'}
					 };
		String str = "njlhc";
		Point [] result = getPath(arr,str);
		printArr(result);
	}
	
	public static void printArr(Point[] arr){
		if(arr == null){
			System.out.println("The word does not exist");
			return;
		}
		for(Point p : arr)
			System.out.println(p);
			
	}
	
	public static Point[] getPath(char arr[][], String str){
		Point[] result = new Point[str.length()];
		if(str == null || str.length() == 0)
			return null;
		int index = 0;
		for(int i = 0; i< arr.length ;i++){
			for(int j =0 ; j< arr[0].length;j++){
				if(str.charAt(0) == arr[i][j]){
					Point p = new Point(i,j);
					result[index] = p;
					if(populatePath(arr, str, index+1, result)){
						return result;
					}
					result[index] = null;
				}
			}
		}
		
		
		
		return null;
	}
	
	public static boolean populatePath(char arr[][], String str ,int index, Point[] result){
		if(index == str.length())
			return true;
		int i = result[index-1].x;
		int j = result[index-1].y;
		
		if(i > 0 && j >0 && str.charAt(index) == arr[i-1][j-1]){
			result[index] = new Point(i-1,j-1);
			if(populatePath(arr,str,index+1,result))
				return true;
		}
		
		if(i > 0 && str.charAt(index) == arr[i-1][j]){
			result[index] = new Point(i-1,j);
			if( populatePath(arr,str,index+1,result))
				return true;
		}
		if(i > 0 && j <arr[0].length-1 && str.charAt(index) == arr[i-1][j+1]){
			result[index] = new Point(i-1,j+1);
			if(populatePath(arr,str,index+1,result))
				return true;
		}
		if(j > 0 && str.charAt(index) == arr[i][j-1]){
			result[index] = new Point(i,j-1);
			if(populatePath(arr,str,index+1,result))
				return true;
		}
		if(j <arr[0].length-1 && str.charAt(index) == arr[i][j+1]){
			result[index] = new Point(i,j+1);
			if(populatePath(arr,str,index+1,result))
				return true;
		}
		if(i < arr.length-1 && j >0 && str.charAt(index) == arr[i+1][j-1]){
			result[index] = new Point(i+1,j-1);
			if(populatePath(arr,str,index+1,result))
				return true;
		}
		if(i < arr.length-1 && str.charAt(index) == arr[i+1][j]){
			result[index] = new Point(i+1,j);
			if(populatePath(arr,str,index+1,result))
				return true;
		}
		if(i < arr.length-1 && j < arr[0].length-1 && str.charAt(index) == arr[i+1][j+1]){
			result[index] = new Point(i+1,j+1);
			if( populatePath(arr,str,index+1,result))
				return true;
		}
		else
			result[index-1] = null; 
			return false;
		
	}
}

class Point{
	int x;
	int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "(" +this.x + " , " +this.y +")";
	}
}

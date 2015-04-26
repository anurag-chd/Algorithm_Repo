package EPIC;

public class PrintSpiralOrder {
	public static void main(String args[]){
		int arr[][] = { {1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16},
				{17,18,19,20}
				};

		printSpiral(arr);
	}
	
	public static void printSpiral(int arr[][]){
		int rowLen = arr.length;
		int colLen = arr[0].length;
		int layer = 0;
		int i ,j;
		while(layer <= arr.length-1/2){
			i = layer;
			for(j = layer;j< colLen - layer-1;j++)
				System.out.print(arr[i][j]+" ,");
			
			j = colLen -layer-1;
			for(i = layer; i<rowLen-layer-1 ;i++)
				System.out.print(arr[i][j]+" ,");
			
			i = rowLen -layer -1;
			for(j = colLen-layer-1; j>layer ;j--)
				System.out.print(arr[i][j]+" ,");
			
			j = layer;
			for(i = rowLen-layer-1; i> layer;i--)
				System.out.print(arr[i][j]+" ,");
			System.out.println();
			
			layer++;
		}
	}
	
}


package LeetCode;

public class MaxWaterArea {
	public static void main(String args[]){
		int height[] = {4,2,0,3,2,5};
		System.out.println(maxArea(height));
	}
	public static int maxArea(int[] A) {
        if(A == null || A.length <3)
        	return 0;
        int []maxLeft = new int[A.length];
        int []maxRight = new int[A.length];
        
        int max = A[0];
        for(int i = 1; i< A.length;i++){
        	maxLeft[i] = max;
        	max = max>A[i]?max:A[i];
        }
        max = A[A.length-1];
        for(int i = A.length-2; i>=0;i--){
        	maxRight[i] = max;
        	max = max>A[i]?max:A[i];
        }
        
        int res = 0;
        for(int i = 1; i< A.length-1;i++){
        	int trap = Math.min(maxLeft[i], maxRight[i]) - A[i];
        	if(trap > 0){
        		res += trap; 
        	}
        }
        
        return res;
    }
}

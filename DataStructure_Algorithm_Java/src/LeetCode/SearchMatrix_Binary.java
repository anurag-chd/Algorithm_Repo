package LeetCode;

public class SearchMatrix_Binary {
	public static void main(String args[]){
		int arr[][] = {{1,3}};
		int target = 3;
		System.out.println(searchMatrix(arr,target));
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null)
            return true;
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;
        if(target < matrix[0][0] || target > matrix[rows][cols])
            return false;
        int i = 0, start =0;
        while(i<=rows){
            if(target == matrix[i][0] || target== matrix[i][cols])
                return true;
            if(target > matrix[i][0] || target< matrix[i][cols])
                break;
            i++;    
        }
        int end = cols;
        while(start <= end){
            int mid = (start+end)/2;
            if(matrix[i][mid] == target)
                return true;
            else if(matrix[i][mid] > target)
                end = mid -1;
            else
                start = mid +1;
        }
        return false;
    }
}

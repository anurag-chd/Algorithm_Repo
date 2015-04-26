package ProgrammeCreek.String_Array_Matrix;

public class MergeSortedList_ConstSpace {
	public static void main(String args[]){
		int arr1[] = new int[10];
		int arr2[] = new int[5];
		arr1[0] = 1; arr1[1] = 3; arr1[2] = 5; arr1[3] = 9; arr1[4] = 15;
		arr2[0] = 2; arr2[1] = 4; arr2[2] = 8; arr2[3] = 10; arr2[4] = 12;
		
		System.out.println(arr1.length);
		mergeArr(arr1,5,arr2,5);
		
		for(int i : arr1)
			System.out.print(i+ " ," );
		
	}
	
	public static void mergeArr(int A[],int m, int B[], int n){
		if(A.length < m+n)
			return;
		int k = m+n -1;
		int i = m-1;
		int j = n-1;
		
		while(i>=0 && j >=0){
			if(A[i] == B [j]){
				A[k--] = A[i--];
				A[k--] = B[j--];
			}
			else if(A[i] < B[j]){
				A[k--] = B[j--];
			}
			else
				A[k--] = A[i--];
		}
		if(i == -1 && j != -1){
			while(j>=0){
				A[k--] = B[j--];
			}
		}
		
		
	}
}

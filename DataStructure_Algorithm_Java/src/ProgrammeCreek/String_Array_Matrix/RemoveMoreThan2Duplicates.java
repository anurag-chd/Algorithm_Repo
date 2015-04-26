package ProgrammeCreek.String_Array_Matrix;

public class RemoveMoreThan2Duplicates {
	public static void main(String args[]){
		int A[] ={1,1,1,2,2,3};
		System.out.println(rmDup(A));
	}
	public static int rmDup(int A[]){
		if(A.length <2)
			return A.length;
		int count =0;
		int i =0;
		int j =1;
		boolean dupFlag = false;
		while(j < A.length){
			if(A[i] == A[j] && !dupFlag){
			
				i++;
				j++;
				dupFlag = true;
			}
			else if(A[i] == A[j] && dupFlag){
				A[j] = Integer.MIN_VALUE;
				count++;
				j++;
			}
			else if(dupFlag && A[i] != A[j]){
				i = j;
				j++;
				dupFlag = false;
			}
			else{
				i++;
				j++;
			}
		}
		
		i =0;
		j =1;
			
		while(j<A.length){
			if(A[i] == Integer.MIN_VALUE && A[j] != Integer.MIN_VALUE){
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
			else if(A[i] == Integer.MIN_VALUE && A[j] == Integer.MIN_VALUE){
				j++;
			}
			else{
				i++;
				j++;
			}
		}
	
		return A.length -count;
	}
}

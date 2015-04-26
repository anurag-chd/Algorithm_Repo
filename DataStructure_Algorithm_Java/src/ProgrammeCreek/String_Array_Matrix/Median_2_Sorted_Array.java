package ProgrammeCreek.String_Array_Matrix;

public class Median_2_Sorted_Array {
	public static void main(String args[]){
		int arr1[] = {2,3,4,10,20};
		int arr2[] = {2,3,4,5};
		
		System.out.println("The median of the two arrays "+ calMedian(arr1,arr2));
	}
	
	// claculating the median of the sorted array in O(log(m+n))
	public static int calMedian(int arr1[] , int arr2[]){
		int m = arr1.length;
		int n = arr2.length;
		if((m + n)%2 != 0){
			return findKth(arr1,arr2,0,m-1,0,n-1,(m+n)/2);
		}
		else{
			return ( (findKth(arr1,arr2,0,m-1,0,n-1,(m+n) /2) + findKth(arr1,arr2,0,m-1,0,n-1,(m+n)/2 -1))/2);
		}
	}
	
	public static int findKth(int arr1[], int arr2[], int aStart, int aEnd, int bStart, int bEnd, int k){
		int aLen = aEnd - aStart +1;
		int bLen = bEnd - bStart +1;
		
		// handle exception
		if(aLen == 0){
			return arr2[bStart + k];
		}
		if(bLen == 0){
			return arr1[aStart + k];
		}
		if(k == 0){
			return arr1[aStart]>arr2[bStart]?arr2[bStart]:arr1[aStart];
		}
		
		int aMid = (aLen * k)/aLen+bLen;
		int bMid = k - aMid -1;
		
		aMid = aMid + aStart;
		bMid = bMid + bStart;
		
		if(arr1[aMid] > arr2[bMid]){
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		}
		else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
		return findKth(arr1, arr2, k, aStart, aEnd, bStart, bEnd);
		
	}
}

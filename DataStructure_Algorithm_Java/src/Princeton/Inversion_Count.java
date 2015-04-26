package Princeton;

public class Inversion_Count {
	public static void main(String args[]){
		//int arr[] = {1,3,5,2,4,6};
		int arr[] = {6,5,4,3,2,1};
		int length = arr.length-1;
		int result = countInversion(arr,0,length,0);
		System.out.println(result);
	}
	
	public static int countInversion(int arr[], int start, int end,int count){
		if(start>=end)
			return 0;
		
		int middle = (int)Math.floor((double)(start + end)/2);
		int count1 =0,count2 =0;
		count1 = countInversion(arr,start,middle,count);
		count2 = countInversion(arr,middle+1,end,count);
		count = count1 + count2;
		
		return mergeInversion(arr,start,middle,end,count);
		
		
	}
	
	public static int mergeInversion(int arr[], int start, int middle, int end, int count){
		// to compare the arrays
		int temp[] = new int[end+1];
		for(int i =0 ;i< end+1;i++){
			temp[i] = arr[i];
		}
		int i= 0,k =0;
		int j = middle+1;
		
		while(i<=middle && j <=end){
			if(temp[i]<=temp[j]){
				arr[k] = temp[i];
				i++;
				k++;
			}
			else{
				arr[k] = temp[j];
				k++;
				j++;
				count++;
			}
				
		}
		if(k < end){
			while(j<=end){
				arr[k] = temp[j];
				k++;
				j++;
			}
			while(i<=middle){
				arr[k] = temp[i];
				i++;
				k++;
				count++;
			}
		}
		
		return count;
	}

}

package Geek4Geeks_Arrays;

public class MaxContgiousSum {
	public static void main(String args[]){
		//int arr[] ={-2,-3,4,-1,-2,1,5,-3};
		int arr[] ={4,-1,-2,-1,-5,-3};
		int res = maxSum(arr);
		System.out.println(res);
	}
	
	public static int maxSum(int arr[]){
		int start = 0;
		int end = 1;
		int max_sum = arr[start] + arr[end];
		int index = 2;
		while(index < arr.length){
			if(max_sum>0){
				if(max_sum < max_sum + arr[index]){
					end = index;
					max_sum = max_sum +arr[end];
					index++;
				}
				else{
					if(max_sum +arr[index] > 0){
						if( index+1 < arr.length && (arr[index] + arr[index+1]) >(max_sum +arr[index])){
							start = index;
							end = index+1;
							max_sum = arr[start] + arr[end];
							index = index +2;
						}
						
						else{
							if(index == arr.length-1){
								index++;
							}
							else{
								end = index;
								max_sum = max_sum + arr[end];
								index++;
							}
							
						}
					}
					else if(max_sum + arr[index] == 0){
						if(index+1 < arr.length && arr[index] + arr[index+1] > 0){
							max_sum = max_sum + arr[index] + arr[index+1];
							end = index+1;
							index = index+2;
						}
						else{
							if(max_sum < arr[end]+ arr[index]){
								start = end;
								end = index;
								max_sum = arr[end] + arr[start];
							}
							index++;
						}
					}
					else{
						index++;
						
					}
				}
			}
			else{
				if(max_sum < max_sum + arr[index]){
					start = end;
					end = index;
					max_sum = arr[start] + arr[end];
					index++;
				}
				else if(max_sum > max_sum + arr[index]){
					if(arr[start] <= arr[index]){
						index++;
					}
					else{
						start = end;
						end = index;
						max_sum = arr[start] + arr[end];
						index++;
					}
				}
				else{
					start = end;
					end = index;
					max_sum = arr[start] + arr[end];
					index++; 
				}
			}
			
		}
		System.out.println("Start index "+ start +" end index "+ end);
		return max_sum;
	}

}

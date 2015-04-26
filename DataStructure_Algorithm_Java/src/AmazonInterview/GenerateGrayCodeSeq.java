package AmazonInterview;
import java.util.*;
public class GenerateGrayCodeSeq {
	public static void main(String args[]){
		int n = 4;
		List<Integer> list = generateSeq(n);
		System.out.println(list);
	}
	
	public static List<Integer> generateSeq(int n){
		if(n<1)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		for(int i =0; i< n; i++){
			int size = list.size();
			for(int j = size-1; j>=0 ; j--){
				list.add(list.get(j)+size);
			}
		}
		return list;
	}
	
	

}

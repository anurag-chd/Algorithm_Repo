package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		root.right.right.right.right = new TreeNode(5);
		int sum = 15;
		
		System.out.println(pathSum(root,sum));
	}
	
	 public static List<List<Integer>> pathSum(TreeNode root, int sum) {
	        List<List<Integer>> result = new ArrayList<>();
	        if(root == null)
	            return result;
	        List<Integer> list = new ArrayList<>();
	        populateResult(root, sum , result, list);
	        return result;
	    }
	    
	    public static void populateResult(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list){
	        if(root == null)
	            return;
	        if(root.left == null && root.right == null){
	            list.add(root.val);
	            int checkSum = getListSum(list);
	            if(sum == checkSum){
	                List<Integer> temp = new ArrayList<>();
	                for(int i : list)
	                    temp.add(i);
	                result.add(temp);    
	            }
	            list.remove(list.size()-1);
	            return;
	        }
	        
	        list.add(root.val);
	        populateResult(root.left,sum,result,list);
	        populateResult(root.right,sum,result,list);
	        
	        list.remove(list.size()-1);
	        return;
	        
	    }
	    
	    public static int getListSum(List<Integer> list){
	        int sum = 0;
	        for(int i : list)
	            sum = sum +i;
	        return sum;    
	    }
}

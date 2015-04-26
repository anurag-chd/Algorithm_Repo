package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeBottomUpTraversal {
	public static void main(String args[]){
		TreeNode root = new TreeNode(3);
		// left subtree
		root.left = new TreeNode(9);
		
		// right subtree
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(17);
		
		System.out.println(levelOrderBottom(root));
		
	}
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> result = new ArrayList<>();
		if(root == null)
			return result;
		Queue<TreeNode> curr = new LinkedList<>();
		Queue<TreeNode> next = new LinkedList<>();
		List<Integer> tempList = new ArrayList<>();
		tempList.add(root.val);
		tempList = new ArrayList<>();
		result.add(0,tempList);
		curr.add(root);
		
		while(!curr.isEmpty()){
			TreeNode temp = curr.poll();
			if(temp.left != null){
				next.add(temp.left);
				tempList.add(temp.left.val);
			}
			if(temp.right != null){
				next.add(temp.right);
				tempList.add(temp.right.val);
			}
			
			if(curr.isEmpty()){
				if(!next.isEmpty())
					result.add(0,tempList);
				
				tempList = new ArrayList<>();
				Queue<TreeNode> swap = curr;
				curr = next;
				next = swap;
			}
				
		}
		
		return result;
		
		
	}
	

}

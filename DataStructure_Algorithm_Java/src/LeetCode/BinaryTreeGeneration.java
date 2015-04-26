package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreeGeneration {
	public static void main(String args[]){
		int num = 3;
		List<TreeNode> result = generateTrees(num);
		
		for(TreeNode temp : result){
			printTree(temp);
			System.out.println();
		}
		
		
	}
	
	public static void printTree(TreeNode root){
		if(root == null)
			return;
		System.out.print(root.val+" ,");
		printTree(root.left);
		printTree(root.right);
	}
	
	public static List<TreeNode> generateTrees(int num){
		List<TreeNode> result = new ArrayList<TreeNode>();
		if(num < 1)
			return result;
		Set<Integer> set = new HashSet<>();
		TreeNode root = null;
		genTrees(num, 0, result,set,root);
		return result;
		
	}
	
	public static void genTrees(int num, int index, List<TreeNode> result, Set<Integer> set,TreeNode root){
		if(index == num){
			TreeNode temp = new TreeNode(root.val);
			generateCopyTree(temp,root);
			TreeNode temp2 = result.size()>0?result.get(result.size()-1):null;
			if(temp2 == null || !checkTree(temp,temp2))
				result.add(temp);
			return;
		}
			
			
		for(int i =1;i<=num; i++){
			if(!set.contains(i)){
				set.add(i);
				if(index == 0){
					root = new TreeNode(i);
					genTrees(num,index+1,result,set,root);
					set.remove(i);
				}
				else{
					root = addBinaryNode(root,i);
					genTrees(num,index+1,result,set,root);
					root = removeBinaryNode(root,i);
					set.remove(i);
					
				}
			}
		}
	}
	
	
	public static boolean checkTree(TreeNode root1, TreeNode root2){
		if(root1 == null && root2 == null)
			return true;
		if(root1 != null && root2 == null || root1 == null && root2 != null || root1.val != root2.val)
			return false;
		boolean left = checkTree(root1.left, root2.left);
		if(!left)
			return false;
		boolean right = checkTree(root1.right, root2.right);
		return left && right;
	}
	
	public static void generateCopyTree(TreeNode temp, TreeNode root){
		if(root == null)
			return;
		if(root.left != null){
			temp.left = new TreeNode(root.left.val);
			generateCopyTree(temp.left, root.left);
		}
		if(root.right != null){
			temp.right = new TreeNode(root.right.val);
			generateCopyTree(temp.right, root.right);
		}
		
	}
	
	public static TreeNode removeBinaryNode(TreeNode root, int num){
		if(root == null || root.val == num){
			root = null;
			return root;
		}
		if(root.val > num){
			root.left = removeBinaryNode(root.left, num);
		}
		else{
			root.right = removeBinaryNode(root.right, num);
		}
		return root;
		
			
	}
	
	public static TreeNode addBinaryNode(TreeNode root, int num){
		if(root == null){
			root = new TreeNode(num);
			return root;
		}
		if(root.val >= num)
			root.left = addBinaryNode(root.left,num);
		else
			root.right = addBinaryNode(root.right,num);
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x; left = null; right = null; 
	}
	
	public String toString(){
		return "" + this.val;
	}
}
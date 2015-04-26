package binaryTree;

public class ArrayToTree2 {
	public static void main(String args[]){
		int[] arr = {1,2,3};
		Array2TreeNode root = convertArray(arr,0,arr.length-1);
		printTree(root);
	}
	public static Array2TreeNode convertArray(int [] arr, int start, int end){
		if(start> end){
			return null;
		}
		int mid = (start + end)/2;
		Array2TreeNode root = new Array2TreeNode(arr[mid]);
		root.lChild = convertArray(arr,start,mid-1);
		root.rChild = convertArray(arr,mid+1,end);
		
		return root;
		
	}
	
	public static void printTree(Array2TreeNode root){
		if(root == null)
			return;
		printTree(root.lChild);
		System.out.print(root.data+ " ,");
		printTree(root.rChild);
	}
	
}

class Array2TreeNode{
	Array2TreeNode lChild;
	Array2TreeNode rChild;
	int data;
	
	public Array2TreeNode(){
		lChild = null;
		rChild = null;
	}
	
	public Array2TreeNode(int d){
		lChild = null;
		rChild = null;
		this.data = d;
	}
}

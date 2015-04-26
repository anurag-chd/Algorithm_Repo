package PracticeQues;

public class Inorder_PreOrder_Binary_Tree {
	static int preIndex = 0;
	public static void main(String args[]){
		char inorder[] = {'D','B','E','A','F','C'};
		char preorder[] = {'A', 'B', 'D', 'E', 'C', 'F'};
				
		TreeNode root = createTree(inorder,preorder,0,inorder.length-1);
		
		inorderPrintTree(root);
 	}
	
	public static void inorderPrintTree(TreeNode root){
		if(root == null)
			return;
		else{
			inorderPrintTree(root.getLeftChild());
			System.out.print(root.getData());
			inorderPrintTree(root.getRightChild());
			
			return;
		}
	}
	
	public static TreeNode createTree(char inorder[], char [] preorder,int in_start,
														int in_end){
		TreeNode root = new TreeNode();
		if(in_start > in_end){
			return null;
		}
		root.setData(preorder[preIndex++]);
		if(in_start == in_end){
			return root;
		}
		
		int root_index = getIndex(inorder,root.getData());
		
		root.setLeftChild(createTree(inorder,preorder,in_start,root_index-1));
		root.setRightChild(createTree(inorder,preorder,root_index+1,in_end));
		
		return root;
		
		
		
	}
	
	public static int getIndex(char arr[] , char c){
		for(int i =0; i< arr.length ;i++){
			if(arr[i] == c)
				return i;
		}
		return -1;
	}

}

class TreeNode{
	char data;
	TreeNode leftChild;
	TreeNode rightChild;
	
	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	public TreeNode(){
		
	}

	public TreeNode(char c){
		this.data = c;
		this.leftChild = null;
		this.rightChild = null;
	}
}

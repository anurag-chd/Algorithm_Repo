package binaryTree;

/*class Array2TreeNode{
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
*/
public class ArrayToTree {

	public Array2TreeNode binarySerachTree(int end , int start, int arr[]){
	   if(end< start){
		   return null;
	   }
	   
	   int mid = (start + end)/2;
       
	   Array2TreeNode n = new Array2TreeNode(arr[mid]);
	   n.lChild = binarySerachTree(mid-1, start, arr);
	   n.rChild = binarySerachTree(end, mid+1, arr);

       return n;	
	}
	
	public Array2TreeNode binarySerachTree(int[] treearray){
		return binarySerachTree(treearray.length-1, 0, treearray);
	}
	
    public void array2TPrintTree(Array2TreeNode root){
    	this.printTree(root);
		
	}
	
    
    public void printTree(Array2TreeNode n){
		if(n == null){
			return;
		}
		
		printTree(n.lChild);
		System.out.print(n.data+",");
		
		printTree(n.rChild);
	}
	public static void main(String[] args) {
	

		ArrayToTree aT = new ArrayToTree();
		int[] tree_array = {1,2,3};
		Array2TreeNode root = aT.binarySerachTree(tree_array);
		
		
		aT.array2TPrintTree(root);
	}

}

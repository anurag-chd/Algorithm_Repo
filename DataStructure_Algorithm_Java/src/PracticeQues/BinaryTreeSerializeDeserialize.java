package PracticeQues;

import Basics.GenTreeNode;

public class BinaryTreeSerializeDeserialize {
	public static int index = 0;
	public static void main(String args[]){
		GenTreeNode<Character> root = new GenTreeNode<Character>('a');
		root.setLeft_child(new GenTreeNode('b'));
		root.setRight_child(new GenTreeNode('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode('d'));
		root.getLeft_child().setRight_child(new GenTreeNode('e'));
		root.getRight_child().setRight_child(new GenTreeNode('f'));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode('g'));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode('h'));
		
		printTree(root);
		System.out.println();
		int treeSize = getTreeSize(root);
		char pre[] = new char[20];
		generatePreOrderArr(root,pre);
		//printArr(pre);
		index = 0;
		GenTreeNode<Character> newRoot = deserializeTree(pre);
		
		
		printTree(newRoot);
		
	}
	
	public static GenTreeNode deserializeTree(char pre[]){
		if(pre[index] == '#'){
			index++;
			return null;
		}
		GenTreeNode<Character> root = new GenTreeNode<>(pre[index++]);
		root.setLeft_child(deserializeTree(pre));
		root.setRight_child(deserializeTree(pre));
		return root;	
	}
	
	
	public static void printArr(char [] arr){
		for(int i =0 ; i< arr.length; i++){
			if(arr[i] ==' ')
				break;
			System.out.print(arr[i]+" ,");
		}
		System.out.println();
	}
	
	public static void generatePreOrderArr(GenTreeNode<Character> root, char[]pre){
		if(root == null){
			pre[index++] ='#';
			return;
		}
		pre[index++] = root.getData();
		generatePreOrderArr(root.getLeft_child(), pre);
		generatePreOrderArr(root.getRight_child(), pre);
		
	}
	
	public static int getTreeSize(GenTreeNode<Character> root){
		if(root == null)
			return 0;
		return 1 +getTreeSize(root.getLeft_child()) + getTreeSize(root.getRight_child());
		
	}
	
	public static void printTree(GenTreeNode<Character> root){
		if(root == null)
			return;
		printTree(root.getLeft_child());
		System.out.print(root.getData()+", ");
		printTree(root.getRight_child());
		
	}
}

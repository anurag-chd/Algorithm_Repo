package LeetCode;

import Basics.GenTreeNode;

public class BinaryTree_Serialisation_Deserialisation {
	
	public static int index =0;
	public static void main(String args[]){
		GenTreeNode<Character> root = new GenTreeNode<Character>('a');
		root.setLeft_child(new GenTreeNode('b'));
		root.setRight_child(new GenTreeNode('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode('d'));
		root.getLeft_child().setRight_child(new GenTreeNode('e'));
		root.getRight_child().setRight_child(new GenTreeNode('f'));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode('g'));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode('h'));
		
		char preorder[] = new char [17];
		convertPre(root,preorder);
		for(int i =0; i< preorder.length;i++)
			System.out.print(preorder[i]+" ");
		index=0;
		System.out.println();
		GenTreeNode<Character> newRoot = convertPre_Tree(preorder);
		System.out.println();
		printInorder(root);
		System.out.println();
		System.out.println("New treeeeeeeee");
		
		printInorder(newRoot);
		
	}
	
	public static void printInorder(GenTreeNode<Character> root){
		if(root == null)
			return;
		printInorder(root.getLeft_child());
		System.out.print(root.getData()+" ,");
		printInorder(root.getRight_child());
		return;
	}
	
	public static GenTreeNode<Character> convertPre_Tree(char [] preorder){
		
			if(index >= preorder.length)
				return null;
			if(preorder[index] == '$'){
				index++;
				return null;
				
			}
			else{
				GenTreeNode<Character> root = new GenTreeNode<Character>(preorder[index]);
				System.out.println(root.getData() + " "+index);
				index++;
				root.setLeft_child(convertPre_Tree(preorder));
				root.setRight_child(convertPre_Tree(preorder));
				return root;

			}
							
					
			
		
		
			
	}
	
	public static void convertPre(GenTreeNode<Character> root , char[] preorder){
		if(root == null){
			preorder[index++] = '$';
			return;
		}
		preorder[index++] = root.getData();
		convertPre(root.getLeft_child(),preorder);
		convertPre(root.getRight_child(),preorder);
		return;
	}

}

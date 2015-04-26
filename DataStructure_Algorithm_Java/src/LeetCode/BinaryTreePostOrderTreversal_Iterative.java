package LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import Basics.GenTreeNode;

public class BinaryTreePostOrderTreversal_Iterative {
	public static void main(String args[]){
		GenTreeNode<Character> root = new GenTreeNode<Character>('a');
		root.setLeft_child(new GenTreeNode('b'));
		root.setRight_child(new GenTreeNode('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode('d'));
		root.getLeft_child().setRight_child(new GenTreeNode('e'));
		root.getRight_child().setRight_child(new GenTreeNode('f'));
		/*root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode('g'));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode('h'));*/
		printPostOrder(root);
		System.out.println();
		printTreePostOrder(root);
	}
	
	public static void printPostOrder(GenTreeNode<Character> root){
		if(root == null)
			return;
		printPostOrder(root.getLeft_child());
		printPostOrder(root.getRight_child());
		System.out.print(root.getData()+" ,");
	}
	
	public static void printTreePostOrder(GenTreeNode<Character> root){
		if(root == null)
			return;
		Stack<GenTreeNode<Character>> stack = new Stack<>();
		Set<Character> set = new HashSet<>();
		
		stack.push(root);
		while(!stack.isEmpty()){
			GenTreeNode <Character> temp = stack.peek();
			if((temp.getLeft_child()== null && temp.getRight_child() == null)
				|| (temp.getLeft_child() == null && set.contains(temp.getRight_child().getData()))
				|| (temp.getRight_child() == null && set.contains(temp.getLeft_child().getData()))
				|| (temp.getLeft_child() != null && temp.getRight_child() != null && set.contains(temp.getLeft_child().getData()) && set.contains(temp.getRight_child().getData()))){
				 
				
				System.out.print(temp.getData()+" ,");
				set.add(stack.pop().getData());
			}
			else{
				if(temp.getRight_child()!=null)
					stack.add(temp.getRight_child());
				if(temp.getLeft_child()!=null)
					stack.add(temp.getLeft_child());
			}
		}
	}
}

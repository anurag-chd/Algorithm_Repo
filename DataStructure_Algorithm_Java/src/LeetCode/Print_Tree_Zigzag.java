package LeetCode;

import java.util.Stack;

import Basics.GenTreeNode;

public class Print_Tree_Zigzag {
	public static void main(String args[]){
		GenTreeNode<Character> root = new GenTreeNode<Character>('a');
		root.setLeft_child(new GenTreeNode<Character>('b'));
		root.setRight_child(new GenTreeNode<Character>('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode<Character>('d'));
		root.getLeft_child().setRight_child(new GenTreeNode<Character>('e'));
		root.getRight_child().setRight_child(new GenTreeNode<Character>('f'));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode<Character>('g'));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode<Character>('h'));
		
		printTree(root);
		
	}
	
	public static void printTree(GenTreeNode<Character> root){
		Stack<GenTreeNode<Character>> current_Level = new Stack<GenTreeNode<Character>>();
		Stack<GenTreeNode<Character>> next_Level = new Stack<GenTreeNode<Character>>();
		
		boolean leftToRight = true;
		
		current_Level.add(root);
		
		while(!current_Level.isEmpty()){
			GenTreeNode<Character> current = current_Level.pop();
			System.out.print(current.getData()+" ");
			
			if(leftToRight){
				if(current.getLeft_child() != null)
					next_Level.push(current.getLeft_child());
				if(current.getRight_child() != null)
					next_Level.push(current.getRight_child());
			}
			
			else{
				if(current.getRight_child() != null)
					next_Level.push(current.getRight_child());
				if(current.getLeft_child() != null)
					next_Level.push(current.getLeft_child());
				
			}
			
			if(current_Level.isEmpty()){
				System.out.println();
				leftToRight = !leftToRight;
				Stack<GenTreeNode<Character>> temp = current_Level;
				current_Level = next_Level;
				next_Level = temp;
			}
		}
		
	}

}

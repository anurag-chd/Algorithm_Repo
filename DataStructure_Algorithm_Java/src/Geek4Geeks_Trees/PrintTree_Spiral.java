package Geek4Geeks_Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Basics.GenTreeNode;

public class PrintTree_Spiral {
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
		
	}
	
	public static void printTree(GenTreeNode<Character> root){
		Queue<GenTreeNode<Character>> queue = new LinkedList<GenTreeNode<Character>>();
		Stack<Character> stack = new Stack<Character>();
		int level[] = new int[treeNodes(root)];

		queue.add(root);
		level[0] = 0;
		int num_node =0;
		
		int count = 0;
		
		LinkedList<GenTreeNode<Character>> list = new LinkedList<GenTreeNode<Character>>();
		while(!queue.isEmpty()){
			
			GenTreeNode<Character> temp = queue.poll();
			list.add(temp);
			
			if(temp.getLeft_child()!=null || temp.getRight_child()!=null)
				
			
			if(temp.getLeft_child()!=null){
				queue.add(temp.getLeft_child());
				level[++num_node] = level[count]+1;
				
			}
			
			if(temp.getRight_child()!=null){
				queue.add(temp.getRight_child());
				level[++num_node] = level[count]+1;
				
			}
			count++;
		}
		
		
		
		for(int i =0 ; i< 8 ;i++){
			System.out.print(level[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i< list.size();i++){
			if(level[i]%2 == 0){
				if(!stack.isEmpty()){
					System.out.println();
					while(!stack.isEmpty()){
						System.out.print(stack.pop()+" ");
					}
					System.out.println();
				}
				System.out.print(list.get(i).getData()+" ");
				
			}
			else{
				stack.push(list.get(i).getData());
				
			}
		}
		System.out.println();
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
			
		
		
		
	}
	
	public static int treeNodes(GenTreeNode root){
		if(root == null){
			return 0;
		}
		else{
			return (1 + treeNodes(root.getLeft_child()) + treeNodes(root.getRight_child()) );
		}
		
	}
}

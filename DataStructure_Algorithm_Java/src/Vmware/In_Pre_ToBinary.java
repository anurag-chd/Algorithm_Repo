package Vmware;

import Basics.GenTreeNode;

public class In_Pre_ToBinary {
	public static int preIndex = 0;	
	public static void main(String srgs[]){
		char in[] = {'D', 'B', 'E', 'A', 'F', 'C'};
		char pre[] = {'A', 'B', 'D', 'E', 'C', 'F'};
		int len = in.length;
		GenTreeNode<Character>  root = createBtree(in,pre,0,len-1);
		printTree(root);
	}
	
	public static void printTree(GenTreeNode root){
		if(root == null)
			return;
		else{
			printTree(root.getLeft_child());
			System.out.println(root.getData());
			printTree(root.getRight_child());
		}
	}
	
	public static GenTreeNode createBtree(char[] in, char[] pre, int start_in,int end_in){
		 if(start_in>end_in){
			 return null;
		 }
		 GenTreeNode<Character> root = new GenTreeNode<Character>(pre[preIndex++]);
		 if(start_in == end_in){
			 return root;
		 }
		 int index = search(root.getData(),in,start_in,end_in);
		 
		 root.setLeft_child(createBtree(in,pre,start_in,index-1));
		 root.setRight_child(createBtree(in,pre,index+1,end_in));
		 
		 return root;
		 
	}
	
	
	public static int search(char c , char[] in, int start, int end){
		for(int i =start;i<=end;i++){
			if(c == in[i])
				return i;
		}
		return -1;
	}
	
	
	
}

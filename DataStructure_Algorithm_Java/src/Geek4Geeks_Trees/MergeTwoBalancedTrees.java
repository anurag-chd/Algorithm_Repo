package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class MergeTwoBalancedTrees {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode(100);
		root.setLeft_child(new GenTreeNode(50));
		root.setRight_child(new GenTreeNode(300));
		root.getLeft_child().setLeft_child(new GenTreeNode(20));
		root.getLeft_child().setRight_child(new GenTreeNode(70));
		
		GenTreeNode<Integer> root1 = new GenTreeNode(80);
		root1.setLeft_child(new GenTreeNode(40));
		root1.setRight_child(new GenTreeNode(120));
		
		GenTreeNode root3 = mergeTrees(root,root1);
		
	}
	static int index = 0;
	static int arr1[] ;
	static int arr2[] ;
	static int mergearr[];
	public static GenTreeNode mergeTrees(GenTreeNode root1, GenTreeNode root2){
		int len1 = treeLength(root1,0);
		int len2 = treeLength(root2,0);
		arr1 = new int[len1];
		arr2 = new int[len2];
		mergearr = new int [len1+ len2];
		
		treeToArray(root1,arr1);
		index =0;
		treeToArray(root2,arr2);
		
		mergeArray();
		GenTreeNode<Integer> mergeRoot = null;
		
		mergeRoot = createBTree(mergeRoot,0,mergearr.length-1);
		
		printTree(mergeRoot);
		return null;
	}
	
	public static void printTree(GenTreeNode<Integer> root){
		if(root == null)
			return;
		printTree(root.getLeft_child());
		System.out.print(root.getData()+" ,");
		printTree(root.getRight_child());
			
	}
	
	public static GenTreeNode createBTree(GenTreeNode root, int start, int end){
		if(start>end){
			return root;
		}
		int middle = (start+ end)/2;
		root = new GenTreeNode(mergearr[middle]);
		root.setLeft_child(createBTree(root.getLeft_child(),start, middle-1));
		root.setRight_child(createBTree(root.getRight_child(),middle+1, end));
		
		return root;
	}
	
	public static void mergeArray(){
		int m = arr1.length;
		int n = arr2.length;
		int i =0, j= 0 ,k =0;
		while(i<m && j < n){
			if(arr1[i] < arr2[j]){
				mergearr[k] = arr1[i];
				i++;
				k++;
			}
			else if(arr1[i] > arr2[j]){
				mergearr[k] = arr2[j];
				k++;
				j++;
			}
			else{
				mergearr[k++] = arr1[i++];
				mergearr[k++] = arr2[j++];
			}
		}
		if(i == m){
			while(j< n){
				mergearr[k++] = arr2[j++];
			}
		}
		else{
			while(i< m){
				mergearr[k++] = arr1[i++];
			}
		}
	}
	
	public static void treeToArray(GenTreeNode<Integer> root, int arr[]){
		if(root == null){
			return ;
		}
		treeToArray(root.getLeft_child() ,arr);
		arr[index++] = root.getData();
		treeToArray(root.getRight_child() ,arr);
		
		
	}
	
	public static int treeLength(GenTreeNode root, int count){
		if(root == null)
			return count;
		
		return  1 +treeLength(root.getLeft_child(),count) + treeLength(root.getRight_child(),count) ;
	}
}

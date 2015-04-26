package Geek4Geeks_Trees;

public class CheckBST_Only_One_child {
	public static void main(String args[]){
		int pre[] = {20, 21, 11, 13, 12};
		System.out.println("Is the BST has only one child " + checkBST(pre));
	}
	public static boolean checkBST(int pre[]){
		int size = pre.length;
		for(int i =0 ; i<size-1 ;i++){
			int left = pre[i] - pre[i+1];
			int right = pre[i] - pre[size-1];
			if(left*right < 0)
				return false;
		}
		return true;
	}
}

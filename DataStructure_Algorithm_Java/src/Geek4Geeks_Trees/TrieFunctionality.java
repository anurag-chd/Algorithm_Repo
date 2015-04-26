package Geek4Geeks_Trees;

public class TrieFunctionality{
	public static void main(String args[]){
		String str_arr[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
		Trie trie = new Trie();
		for(int i = 0 ; i< str_arr.length;i++){
			char arr[] = str_arr[i].toCharArray();
			insertInTrie(trie,arr);
		}
		System.out.println(trie.count);
		System.out.println(searchString(trie,"the"));
		System.out.println(searchString(trie,"these"));
		System.out.println(searchString(trie,"their"));
		System.out.println(searchString(trie,"thaw"));
		char [] str = "the".toCharArray();
		int len = str.length;
		TrieNode root = trie.root;
		System.out.println("\"the\" is present " +searchString(trie,"the"));
		deleteString(root,str,0,len);
		
		System.out.println("\"the\" is present " +searchString(trie,"the"));
	}
	
	public static boolean deleteString(TrieNode root, char [] str, int start, int end){
		if(root == null)
			return false;
		if(start == end){
			if(root.value != 0){
				root.value = 0; // unmark the node as leaf
				
				if(isFreeNode(root))// check if the node is an empty node with no edges having character
					return true;
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
		else{
			int index = charToInt(str[start]);
			
			if(deleteString(root.node[index],str,++start,end)){
				root.node[index] = null;
				return (isFreeNode(root) && !isLeafNode(root));
			}
			return false;
		}
		
	}
	
	//to check if TrieNode is leaf or not
	
	public static boolean isLeafNode(TrieNode node){
		return node.value != 0;
		
	}
	
	public static boolean isFreeNode(TrieNode root){
		if(root == null)
			return false;
		for(int i =0 ; i< 26 ; i++){
			if(root.node[i] != null)
				return false;
		}
		return true;
	}
	
	public static void insertInTrie(Trie trie, char [] str_char){
		TrieNode crawler = trie.root;
		int len = str_char.length;
		trie.count++;
		for(int i =0; i< len ; i++){
			int index = charToInt(str_char[i]);
			if(crawler.node[index] == null){
				crawler.node[index] = new TrieNode();
			}
			crawler = crawler.node[index];
		}
		crawler.value = trie.count;
		
	}
	
	public static boolean searchString(Trie trie, String str){
		char [] str_char = str.toCharArray();
		TrieNode crawler = trie.root;
		int result = 0;
		int len = str_char.length;
		for(int i =0; i< len ; i++){
			
			int index = charToInt(str_char[i]);
			if(crawler.node[index] == null){
				return false;
			}
			// to get the index value of the last character
			
			
			crawler = crawler.node[index];
		}
		result = crawler.value;
		if(result != 0)
			return true;
		
		else
			return false;
		
	}
	
	
	
	public static int charToInt(char c){
		return ((int)c -(int)'a');
	}
	
}


 class Trie {
	TrieNode root;
	int count;
	
	public Trie(){
		root = new TrieNode();
		count = 0;
	}
		
}

class TrieNode {
	int value;
	TrieNode node[];
	
	public TrieNode(){
		this.value = 0;
		node = new TrieNode[128];
		for(int i = 0; i < 26; i++){
			node[i] = null;
		}
	}
	
}

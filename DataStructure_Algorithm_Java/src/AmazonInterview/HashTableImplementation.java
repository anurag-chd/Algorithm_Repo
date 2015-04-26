package AmazonInterview;

public class HashTableImplementation {
	public static void main(String args[]){
		HashTable hashtable = new HashTable(10);
		hashtable.put("anurag", 1);
		hashtable.put("kartik", 2);
		hashtable.put("nikhil", 3);
		hashtable.put("garuna", 8);
		
		System.out.println("table size " +hashtable.numElements);
		
		hashtable.put("anurag",10);
		System.out.println(hashtable.get("anurag"));
		hashtable.remove("anurag");
		System.out.println(hashtable.get("anurag"));
		System.out.println(hashtable.get("garuna"));
		System.out.println("table size " +hashtable.numElements);
		
	}
}

class HashTable {
	int capacity;
	int numElements;
	HashNode[] table; 
	
	public HashTable(int capacity){
		this.capacity = capacity;
		this.numElements = 0;
		this.table = new HashNode[capacity];
	}
	
	// function to get the hash value for a particular key
	public int getHash(Object key){
		// key null return index -1
		if(key == null){
			System.out.println("The key cannot be null");
			return -1;
		}
		else{
			String str = key.toString();
			int sum = 0;
			for(int i = 0; i < str.length();i++)
				sum = sum + (int)str.charAt(i);
			// sum of chars % table.size
			return sum%this.table.length;
		}
	}
	
	// function to add the HasNode to the table
	public void put(Object key, Object value){
		if(key == null || value == null)
			return;
		
		int index = getHash(key);
		if(table[index] == null){
			HashNode node = new HashNode(key,value);
			table[index] = node;
			numElements++;
			return;
		}
		else{
			HashNode temp = table[index];
			if(!temp.contains(key)){
				// if HashNode List at index does not have the key node 
				// append new node to the list end
				while(temp.next != null)
					temp = temp.next;
				HashNode node = new HashNode(key,value);
				temp.next = node;
				numElements++;
				return;
			}
			else{
				// HashNode List at index contains the key node then
				// traverse to that node and change the node's value
				while(temp != null){
					if(temp.key.equals(key)){
						temp.value = value;
						return;
					}
					temp = temp.next;
				}
				return;
			}
		}
	}
	
	
	// function to get the value from a particular key
	public Object get(Object key){
		if(key == null)
			return null;
		int index = getHash(key);
		if(table[index] == null){
			System.out.println("the key does not exist");
			return null;
		}
		else{
			HashNode temp = table[index];
			// Check the HashNode list at that index if it contains particular key
			// return the value else return false
			while(temp !=null){
				if(temp.key.equals(key)){
					return temp.value;
				}
				temp = temp.next;
			}
			System.out.println("the key does not exist");
			return null;
		}
	}
	
	// function to remove the entry in HashTable for a particular key
	public void remove(Object key){
		if(key == null)
			return;
		int index = getHash(key);
		if(table[index] != null){
			HashNode temp = table[index];
			// if the first node in the HashNode List is the key
			if(temp.key.equals(key)){
				table[index] = temp.next;
				numElements--;
				return;
			}
			// else traverse the list
			HashNode parent = temp;
			temp = temp.next;
			while(temp != null){
				if(temp.key.equals(key)){
					parent.next = temp.next;
					temp = null;
					numElements--;
					return;
				}
				parent = temp;
				temp = temp.next;
			}
			System.out.println("the key does not exist");
			return;
		}
	}
}

class HashNode{
	Object key;
	Object value;
	HashNode next;
	
	public HashNode(Object key, Object value){
		this.key = key;
		this.value = value;
		this.next = null;
	}
	
	// equals function checks when their is a collision in map
	// and we want to get the exact key value pair
	public boolean equals(Object obj){
		if(obj instanceof HashNode){
			HashNode node = (HashNode)obj;
			return this.key.equals(node.key);
		}
		else
			return false;
	}
	
	// check whether the HashNode list has the HashNode
	public boolean contains(Object key){
		if(key == null || value == null)
			return false;
		HashNode temp = this;
		while(temp != null){
			if(key.equals(temp.key)){
				return true;
			}
			temp = temp.next;	
		}
		return false;
	}
	
	// to String Function
	public String toString(){
		return "key = "+ this.key.toString() + " value = "+ this.value;
	}
}

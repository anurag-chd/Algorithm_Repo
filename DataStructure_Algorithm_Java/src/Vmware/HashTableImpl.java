package Vmware;

import java.util.*;

public class HashTableImpl {
	private class HashNode{
		Object key;
		Object value;
		
		HashNode(){
			this.key = null;
			this.value = null;
		}
		
		HashNode(Object key , Object value){
			this.key = key;
			this.value = value;
		}
		public Object getKey() {
			return key;
		}

		public void setKey(Object key) {
			this.key = key;
		}
		
		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}
		
		public boolean equals(Object obj){
			if(obj == null)
				return false;
			else{
				if(!(obj instanceof HashNode))
					return false;
				else{
					HashNode node = (HashNode)obj;
					return this.getKey().equals(node.getKey());
				}
			}
		}
		
		public String toString(){
			String str = this.getKey()+"   "+this.getValue();
			return str;
		}
	}	
	
	private final int table_size = 20;
	private int num_elements = 0;
	private Object[] table = new Object[table_size];
		
		
	public int hashCode(Object key){
		String str = key.toString();
		char arr[] = str.toCharArray();
		int sum = 0;
		for(char i : arr){
			sum = sum + (int)i;
		}
		return (sum/table_size);
	}
		
	public void add(Object key, Object value){
		if(key == null || value == null)
			return;
	
		else{
			if(this.contains(key)){
				System.out.println("Duplicate key");
				return;
			}
			else{
				HashNode node = new HashNode(key,value);
				int hash_num = hashCode(node.getKey());
				if(table[hash_num]!=null){
					((LinkedList)this.table[hash_num]).add(node);
					this.num_elements++;
					return;
				}
				else{
					LinkedList<HashNode> node_list = new LinkedList<HashNode>();
					node_list.add(node);
					table[hash_num] = node_list;
					this.num_elements++;
					return;
				}
			}
		}
	}
		
				
	public boolean contains(Object key){
		int hash_num = hashCode(key);
		if(table[hash_num] == null)
			return false;
		else{
			HashNode node = new HashNode();
			node.setKey(key);
			if(((LinkedList)this.table[hash_num]).indexOf(node)>-1){
				return true;
			}
			else
				return false;
		}
	}
		
	public Object get(Object key){
		if(key == null)
			return null;
		
		if(this.contains(key)){
			int hash_num = this.hashCode(key);
			HashNode node = new HashNode();
			node.setKey(key);
			int pos = ((LinkedList)this.table[hash_num]).indexOf(node);
			HashNode temp;
			if(pos>-1){
				temp = (HashNode)((LinkedList)this.table[hash_num]).get(pos);
				return temp.getValue();
			}
			else{
				return null;
			}
		}
		
		else
			return null;
	}
	
	public void remove(Object key){
		if(key == null)
			return ;
		
		if(this.contains(key)){
			int hash_num = this.hashCode(key);
			HashNode node = new HashNode();
			node.setKey(key);
			int pos = ((LinkedList)this.table[hash_num]).indexOf(node);
			
			if(pos>-1){
				 ((LinkedList)this.table[hash_num]).remove(pos);
				return ;
			}
			else{
				return ;
			}
		}
		
		else
			return ;
		
	}
	
}

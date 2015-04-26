package LeetCode;

public class LRU_Cache {
	
	public static int capacity=0;
	public static Cache_Entity [] cache = new Cache_Entity[10]; 
	
	public static void main(String args[]){
		
		for(int i = 1;i < 7 ;i++){
			set(i,i*100);
		}
		//System.out.println("get(1) "+get(1));
		set(10,1000);
		set(11,1100);
		set(12,1200);
		set(13,1300);
		
		
		System.out.println("get(13) "+get(13));
		System.out.println("get(1) "+get(1));
		System.out.println("get(3) "+get(3));
		set(14,1400);
		System.out.println("get(1) "+get(1));
		System.out.println("get(3) "+get(3));
		System.out.println("get(2) "+get(2));
		System.out.println("get(14) "+get(14));
		
		
	}
	
	public static int get(int key){
		for(int i =0 ;i < capacity;i++){
			if(key == cache[i].key){
				cache[i].used_index = cache[i].used_index + 1;
				int result = cache[i].value;
				if(capacity == cache.length){
					shiftDown(cache,i,capacity);
				}
				return result;
			}
		}
		return -1;
	}
	
	public static void set(int key, int value){
		
		if(capacity < cache.length){
			Cache_Entity e = new Cache_Entity(key,value,1);
			cache[capacity] = e;
			capacity++;
			if(capacity == cache.length)
				heapify(cache,cache.length);
		}
		else{
			Cache_Entity e = new Cache_Entity(key,value,3);
			cache[0] = e;
			shiftDown(cache,0,cache.length);
			
		}
		
	}
	
	public static void heapify(Cache_Entity[] cache, int length){
		int start = (int)Math.floor(length-2/2);
		while(start>=0){
			shiftDown(cache,start,cache.length);
			start--;
		}
		
	}
	
	public static void shiftDown(Cache_Entity[] cache, int start , int end){
		int root = start;
		while(root*2 +2 < end){
			int child = root*2 +1;
			if(cache[child].used_index > cache[child+1].used_index){
				child = child +1;
			}
				
			if(cache[child].used_index < cache[root].used_index ){
				swap(cache,root,child);
				root = child;
			}
				
			else{
				return;
			}
		}
	}
	
	public static void swap(Cache_Entity[] cache, int a , int b){
		Cache_Entity temp = cache[a];
		cache[a] = cache[b];
		cache[b] = temp;
		return;
	}
}

class Cache_Entity{
	int key;
	int value;
	int used_index;
	
	public Cache_Entity(int key, int value, int used_index){
		this.key = key;
		this.value = value;
		this.used_index = used_index;
	}
	
	
	
}


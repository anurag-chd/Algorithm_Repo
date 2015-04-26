package AmazonInterview;

public class CircularQueueImpl {
	public static void main(String args[]){
		CircularQueue cQueue = new CircularQueue(5);
		cQueue.enqueue(1); cQueue.enqueue(2);cQueue.enqueue(3);
		cQueue.enqueue(4);
		cQueue.enqueue(5);
		//cQueue.enqueue(6);
		System.out.println(cQueue.dequeue());
		cQueue.enqueue(6);
		System.out.println(cQueue.dequeue());
		cQueue.enqueue(7);
	}
	
}

class CircularQueue{
	int capacity;
	Object table[] ;
	int front,back;

	
	public CircularQueue(int capacity){
		this.capacity = capacity;
		this.table = new Object[capacity];
		front = -1; back = -1; 
	}
	
	// check if queue is empty
	public boolean isEmpty(){
		if(front == back)
			return true;
		else
			return false;
	}
	
	// check if the queue is full
	public boolean isFull(){
		if(back - front == -1 || back - front == capacity)
			return true;
		else
			return false;
	}
	
	//calculate size of the queue
	public int size(){
		if(back>front)
			return back - front;
		else
			return capacity - front + back;
	}
	
	//add elements to the queue
	public void enqueue(Object obj){
		if(this.isFull()){
			System.err.println("The queue is full");
			return;
		}
		else{
			back = (back+1)%capacity;
			this.table[back] = obj;
			return;
		}
	}
	
	// removes element from the queue
	public Object dequeue(){
		if(this.isEmpty()){
			System.err.println("The queue is empty");
			return null;
		}
		else{
			front = (front+1)%capacity;
			Object item = this.table[front];
			this.table[front] = null;
			return item;
		}
	}
	
}

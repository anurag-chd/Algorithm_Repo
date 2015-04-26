package AmazonInterview;

public class Queue_Array {
	
	int arr[];
	int length;
	int head, tail;
	boolean empty_flag;
	public Queue_Array(int length){
		this.length = length;
		arr = new int[length];
		head = -1;
		tail = -1;
		empty_flag = true;						
	}
	
	public void enqueue(int num){
		if(head == -1 && tail ==-1){
			head = 0;
			tail = 0;
			arr[tail] =num;
			empty_flag = false;
		}
		else if( (tail == length-1 && head == 0) || tail+1 == head && empty_flag == false){
			System.out.println("The queue is full");
		}
		else{
			if(tail < length-1){
				arr[++tail] =num;
			}
			else{
				tail = 0;
				arr[tail] = num;
			}
			empty_flag = false;
		}
	}
	
	public int dequeue(){
		if(empty_flag){
			System.out.println("The queue is empty");
			return -1;
		}
		else{
			if(head == tail){
				int num = arr[head];
				if(head < length-1)
					arr[head++] = -1;
				else{
					arr[head] = -1;
					head = 0;
				}
					
				empty_flag = true;
				return num;
			}
			else if(head == length-1){
				int num = arr[head];
				head = 0;
				return num;
			}
			else{
				int num = arr[head++];
				return num;
				
			}
		}
	}
	
	public static void main(String args[]){
		Queue_Array que = new Queue_Array(3);
		que.enqueue(1);
		que.enqueue(2);
		que.enqueue(3);
		
		System.out.println(que.dequeue());
		que.enqueue(4);
		System.out.println(que.dequeue());
		que.enqueue(5);
		que.enqueue(6);
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		que.enqueue(6);
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
	}
	
}

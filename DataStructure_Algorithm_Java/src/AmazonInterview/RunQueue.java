package AmazonInterview;

public class RunQueue {
	public static void main(String[] args) {
        Queue queue = new CircularArrayQueue();
         
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");
        /*System.out.println(queue.size());
        System.out.println(queue.dequeue());
        queue.enqueue("E");
        System.out.println(queue.size());
        //queue.enqueue("F");
        System.out.println(queue.dequeue());
        System.out.println(queue.size());*/
    }

}

interface Queue {
    
    // return the size of the queue
    public int size();
     
    public boolean isEmpty();
     
    public boolean isFull();
     
    // insert an element into the queue 
    public void enqueue(Object obj) throws QueueFullException;
     
    // removes an element from the queue 
    public Object dequeue() throws QueueEmptyException; 
 
}
 
class CircularArrayQueue implements Queue{
     
    private static final int capacity = 5;
    private Object[] Q;
    private final int N; // capacity
    private int f = 0;
    private int r = 0;
 
     
    public CircularArrayQueue(){
        this(capacity);
    }
     
    public CircularArrayQueue(int capacity){
        N = capacity;
        Q = new Object[N];
    }
 
    public int size() {
        if(r > f)
            return r - f;
        return N - f + r;
    }
 
    public boolean isEmpty() {
        return (r == f) ? true : false;
    }
 
    public boolean isFull() {
        int diff = r - f; 
        if(diff == -1 || diff == (N -1))
            return true;
        return false;
    }
 
    public void enqueue(Object obj) throws QueueFullException {
        if(isFull()){
            throw new QueueFullException("Queue is Full.");
        }else{
            Q[r] = obj;
            r = (r + 1) % N;
        }
    }
 
    public Object dequeue() throws QueueEmptyException {
        Object item; 
        if(isEmpty()){
            throw new QueueEmptyException();
        }else{
            item = Q[f];
            Q[f] = null;
            f = (f + 1) % N;
        }
       return item;
    }
 
}
class QueueFullException extends RuntimeException {
	 
    public QueueFullException(){
        super();
    }
     
    public QueueFullException(String message){
        super(message);
    }
     
    public QueueFullException(String message, Throwable cause){
        super(message, cause);
    }
}

 
class QueueEmptyException extends RuntimeException {
 
    public QueueEmptyException(){
        super();
    }
     
    public QueueEmptyException(String message){
        super(message);
    }
     
    public QueueEmptyException(String message, Throwable cause){
        super(message, cause);
    }
}

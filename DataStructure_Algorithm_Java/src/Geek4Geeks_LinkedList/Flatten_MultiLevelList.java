package Geek4Geeks_LinkedList;

public class Flatten_MultiLevelList {
	public static void main(String args[]){
		MultiLevelList node1 = new MultiLevelList(10);
		MultiLevelList node2 = new MultiLevelList(5);
		MultiLevelList node3 = new MultiLevelList(12);
		MultiLevelList node4 = new MultiLevelList(7);
		MultiLevelList node5 = new MultiLevelList(11);
		MultiLevelList node6 = new MultiLevelList(4);
		MultiLevelList node7 = new MultiLevelList(20);
		MultiLevelList node8 = new MultiLevelList(13);
		MultiLevelList node9 = new MultiLevelList(17);
		MultiLevelList node10 = new MultiLevelList(6);
		MultiLevelList node11 = new MultiLevelList(2);
		MultiLevelList node12 = new MultiLevelList(16);
		MultiLevelList node13 = new MultiLevelList(9);
		MultiLevelList node14= new MultiLevelList(8);
		MultiLevelList node15 = new MultiLevelList(3);
		MultiLevelList node16 = new MultiLevelList(19);
		MultiLevelList node17 = new MultiLevelList(15);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node6.next = node7;
		node7.next = node8;
		node9.next = node10;
		node13.next = node14;
		node16.next = node17;
		
		node1.child = node6;
		node4.child = node9;
		node7.child = node11;
		node8.child = node12;
		node9.child = node13;
		node12.child = node15;
		node13.child = node16;
		
		flattenList(node1);
		
	}
	
	
	public static void flattenList(MultiLevelList node){
		if(node == null){
			return;
		}
		MultiLevelList head = node, tail = node;
		tail = traverseToEnd(tail);
		while(head.next != null){
			if(head.child != null){
				tail.next = head.child;
				tail = traverseToEnd(tail);
			}
			head = head.next;
		}
		
		System.out.println(head.data);
		
	}
	
	public static MultiLevelList traverseToEnd(MultiLevelList tail){
		if(tail == null || tail.next == null){
			return tail;
		}
		while(tail.next != null){
			tail = tail.next;
		}
		return tail;
	}
}

class MultiLevelList{
	int data;
	MultiLevelList next;
	MultiLevelList child;
	
	public MultiLevelList(int data)
	{
		this.data = data;
	}
}

package Basics;
import java.util.LinkedList;

public class Test_Java_LinkedList {
	public static void main(String args[]){
		java.util.LinkedList<Integer> list = new java.util.LinkedList<>();
		list.add(1);
		list.add(3);
		list.add(2, 2);
		System.out.println(list);
	}
}

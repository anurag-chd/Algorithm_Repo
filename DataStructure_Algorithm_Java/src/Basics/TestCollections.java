package Basics;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class TestCollections {
	public static void main(String args[]){
		List<Integer> A = new ArrayList<>();
		Object a = new Object();
		Demo d = new Demo();
		d.modify(null);
	}

}

class Demo{  
	
	
	public void modify(List A){
		System.out.println(A+ " link");
	}
	
	public void modify(LinkedList A){
	//public void modify(ArrayList A){
		System.out.println(A+ " Link");
	}
}

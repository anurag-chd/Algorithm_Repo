package Basics;

import java.util.HashSet;
import java.util.Set;

public class Test {
	void m1(){
		System.out.println("A");
		
	}
	public Test m3(){
		System.out.println("Polymorphism in A");
		return this;
	}
	public static void main(String args[]){
		Test a =  Test2.create();
		((Test2) a).m2();
		Test b = a.m3();
		b.m1();
		Set<Integer> s = new HashSet<Integer>();
		s.add(1);
		s = ((Test2)b).setFun(s);
	}
	
	
}

class Test2 extends Test{
	private Test2(){
		System.out.println("Hii");
	}
	
	public static Test2 create(){
		Test2 t = new Test2();
		return t;
	}
	 void m1(){
		System.out.println("B");
	}
	 
	 Set<Integer> setFun(Set<Integer> set){
		 for(int i :set)
			 System.out.println(i);
		 return set;
	 }
	 public Test2 m3(){
			System.out.println("Polymorphism in B");
			return this;
		}
	 
	 void m2(){
		 System.out.println("c");
	 }
}

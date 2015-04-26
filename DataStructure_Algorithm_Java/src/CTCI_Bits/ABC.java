package CTCI_Bits;

import Basics.TestNoModifier;



public class ABC extends TestNoModifier {
	static {
		System.out.println("Static");
	}
	public static void main(String args[]){
		System.out.println("Main");
		ABC a = new ABC();
		a.printSome();
		
	}
	
	public void diplay(){
		System.out.println("Chutiap");
	}
}

class DEF extends ABC{
	public static void show(){
		DEF d = new DEF();
		d.printSome();
	
		
	}
}

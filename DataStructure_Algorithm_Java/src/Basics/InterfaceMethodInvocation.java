package Basics;

public class InterfaceMethodInvocation {

	public static void main(String args[]){
		A1 a;
		//a.printName("Anurag");
	}
}

interface A1{
	public void printName(String str);
}

class B1 implements A1{
	public void printName(String str){
		System.out.println(str);
	}
}
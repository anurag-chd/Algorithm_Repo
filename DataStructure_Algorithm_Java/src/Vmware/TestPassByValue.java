package Vmware;

public class TestPassByValue {
	String name = "asd";
	public static void main(String args[]){
		TestPassByValue tbv = new TestPassByValue();
		System.out.println(tbv.name);
		nameChange(tbv);
		System.out.println(tbv.name);
		tbv.name = "zxc";
		System.out.println(tbv.name);
		nameChange(tbv);
		System.out.println(tbv.name);
	}
	public static void nameChange(TestPassByValue tbv){
		tbv.name = "qwer";
		
	}
}

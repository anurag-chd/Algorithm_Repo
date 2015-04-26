public class TestNoModifier{
	protected void printSome(){
		System.out.println("hi");
	}
	public static void main(String args[]){
		TestModifier t = new ABC(2,3,4);
		t.display();
		
	}
}

class TestModifier {
	int a;
	int b;
	
	public TestModifier(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	protected void display(){
		System.out.println(this.a +" " + this.b);
	}
}

class ABC extends TestModifier{
	int c;
	
	public ABC(int a, int b, int c){
		super(a,b);
		this.c = c;
	}
	public void display(){
		System.out.println(this.a + " " + this.b + " "+ this.c);
	}
	
}




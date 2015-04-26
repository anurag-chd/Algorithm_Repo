package Basics;

public class TestString {
	public static void main(String args[]){
		String test ="";
		System.out.println("String length "+test.length());
		String a1 = new String("Mrinal");
		String a2 = a1;
		a2 = a2.substring(0,2);
		System.out.println("A 1 " + a1);
		System.out.println("A 2 " + a2);
		/*String a = "anurag.choudhary";
		String b = "_id:1,First_Name:1";
		int colon;
		String keys[] = b.split(",");
		for(String key : keys){
			colon = key.indexOf(":");
			String field = key.substring(0, colon);
			String value = key.substring(colon+1);
			if(value.equals("hashed")){
				value = "\""+value+"\"";
				System.out.println(field +" " + value);
			}
			else{
				int val = Integer.parseInt(value);
				System.out.println(field+" " + val);
			}
				
				
		}
		
		
		
		
		int dot = a.indexOf(".");
		String db = a.substring(0, dot);
		String collection = a.substring(dot+1);
		System.out.println(db+"  "+ collection);
*/	}

}

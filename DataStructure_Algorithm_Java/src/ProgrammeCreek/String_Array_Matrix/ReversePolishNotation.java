package ProgrammeCreek.String_Array_Matrix;

import java.util.Stack;

public class ReversePolishNotation {
	public static void main(String args[]){
		String arr1[] = {"4", "0","/", "5", "/", "+"};
		evaluate(arr1);
	}
	
	public static void evaluate(String arr[]){
		Stack<Integer> stack = new Stack<>(); // stack to perform the evaluation
		
		for(int index = 0; index <arr.length ;index++){
			
			try{
				int n = Integer.parseInt(arr[index]);
				stack.push(n);
				
			}
			catch(NumberFormatException e){
				if(stack.size() < 2){
					System.out.println("The polish rotation is wrong. airthmetic ops before num");
					return;
				}
				else{
					int num1 = stack.pop();
					int num2 = stack.pop();
					
					if(calc(num1,num2,arr[index]) != Integer.MIN_VALUE){
						stack.push(calc(num1,num2,arr[index]));
					}
					else{
						return;
					}
				}
			}
		}
		
		System.out.println(stack.pop());
	}
	
	public static int calc(int num1, int num2, String str){
		int result ;
		switch (str){
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num2 - num1;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				if(num1!=0){
					result = num2 / num1;
				}
				else{
					System.out.println("divide by zero exception");
					result = Integer.MIN_VALUE;
				}
				break;
			default :
				System.out.println("Wrong symbol");
				result = Integer.MIN_VALUE;
				break;
		}
		return result;
	}
}

package LeetCode;

import java.util.Stack;

public class ReversePolishNotation {
	
	public static void main(String args[]){
		String str[] = {"4", "13", "5", "/", "+"};
		
		int res = evalRPN(str);
		System.out.println(res);
	}
	
	public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean flag_int;
        int num = 0;
        for(int i =0; i<tokens.length ;i++){
            try{
                num = Integer.parseInt(tokens[i]);
                flag_int = true;
            }
            catch(NumberFormatException e){
                flag_int = false;
            }
            if(flag_int == true){
                stack.push(num);
            }
            else{
                if(stack.isEmpty()){
                    System.out.println("The stack is empty to process the the operation");
                    return -1;
                }
                calc(stack,tokens[i]);
            }
            
        }
        int result = stack.pop();
        return result;
        
    }
    
    public  static void calc(Stack<Integer> stack, String token){
        
        int num2 = stack.pop();
        int num1 = stack.pop();
        switch(token){
            case "+":
                num1 = num2 + num1;
                break;
            
            case "*":
                num1 = num2 * num1;
                break;
            
            case "-":
                num1 = num1 - num2;
                break;
            
            case "/":
                num1 = num1 /num2;
                break;
            
            default :
                System.out.println("The token entered in invalid");
                return;
                
        }
        stack.push(num1);
        return;
            
    }
}

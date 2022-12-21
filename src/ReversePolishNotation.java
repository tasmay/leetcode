/*
* https://leetcode.com/problems/evaluate-reverse-polish-notation/
* */

import java.util.Stack;

public class ReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length < 1) return 0;
        Stack<String> stack = new Stack<>();
        for(int i=0; i<tokens.length; i++) {
            if(!isOperator(tokens[i]))
                stack.push(tokens[i]);
            else {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String res = doOperation(op1, op2, tokens[i]);
                stack.push(res);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private static boolean isOperator(String token) {
        if(token.equalsIgnoreCase("+") || token.equalsIgnoreCase("-")
                || token.equalsIgnoreCase("*") || token.equalsIgnoreCase("/"))
            return true;
        else
            return false;
    }

    private static String doOperation(String op1, String op2, String operator) {
        Integer a = Integer.parseInt(op1);
        Integer b = Integer.parseInt(op2);
        String result = "";
        switch(operator) {
            case "+":
                result = String.valueOf(a+b);
                break;
            case "-":
                result = String.valueOf(a-b);
                break;
            case "/":
                result = String.valueOf(a/b);
                break;
            case "*":
                result = String.valueOf(a*b);
                break;
            default:
                result = "";
        }
        return result;
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}

/*
* https://leetcode.com/problems/valid-parentheses/
* */

import java.util.Stack;

public class ValidParantheses {

    public static boolean isValid(String s) {
        Stack<Character> mystack = new Stack<>();
        for(int i=0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '(')
                mystack.push(')');
            else if (ch == '[')
                mystack.push(']');
            else if (ch == '{')
                mystack.push('}');
            else if (mystack.isEmpty() || mystack.pop() != ch)
                return false;
        }
        return mystack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[({})]";
        System.out.println(isValid(s));
    }
}

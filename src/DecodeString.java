import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        if(s.isEmpty()) return "";
        StringBuilder decoded = new StringBuilder();
        Deque<Integer> num_stack = new LinkedList<>();
        Deque<Character> alpha_stack = new LinkedList<>();
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetter(c)) {
                alpha_stack.addLast(c);
            } else if (Character.isDigit(c)) {
                num_stack.addLast(Character.getNumericValue(c));
            } else if (c == '[') {
                while(!alpha_stack.isEmpty()) {
                    decoded.append(alpha_stack.removeFirst());
                }
                alpha_stack.addLast(']');
            }
        }
        return decoded.toString();
    }

    public static void main(String[] args){
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }
}

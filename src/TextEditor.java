/*
* Implementation of a text editor - dropbox OA
* */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class TextEditor {

    public Deque<Character> left;
    public Deque<Character> right;
    public int cursor;

    public TextEditor() {
        left = new ArrayDeque<Character>();
        right = new ArrayDeque<Character>();
        cursor = 0;
    }

    public void print() {
        for (Iterator it = left.iterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        for (Iterator it = right.iterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
        System.out.println("Cursor: " + cursor);
    }

    public void addText(String text) {
        if(text.isEmpty()) return;
        for(int i=0; i<text.length(); i++) {
            Character ch = Character.valueOf(text.charAt(i));
            left.addLast(ch);
            cursor += 1;
        }
    }

    public int deleteText(int k) {
        int deletedChars = 0;
        int bound = left.size();
        if(k <= left.size())  bound = k;
        for(int i=0; i<bound; i++) {
            left.removeLast();
            cursor -= 1;
            deletedChars += 1;
        }
        return deletedChars;
    }

    public String cursorLeft(int k) {
        int bound = left.size();
        if(k <= left.size())  bound = k;
        for(int i=0; i<bound; i++) {
            right.addFirst(left.removeLast());
            cursor -= 1;
        }
        return getTextLeftToCursor();
    }

    public String cursorRight(int k) {
        int bound = right.size();
        if(k <= right.size())  bound = k;
        for(int i=0; i<bound; i++) {
            left.addLast(right.removeFirst());
            cursor += 1;
        }
        return getTextLeftToCursor();
    }

    public String getTextLeftToCursor() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Iterator it = left.descendingIterator(); it.hasNext() && count<10;) {
            String curr = it.next().toString();
            sb.append(curr);
            count += 1;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addText("leet");
        editor.print();
        editor.addText("practice");
        editor.print();
        System.out.println("cursorRight: " + editor.cursorRight(3));
    }
}

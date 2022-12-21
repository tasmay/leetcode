/*
* https://leetcode.com/problems/first-unique-character-in-a-string/
* */

import java.util.LinkedHashMap;
import java.util.Set;

public class FirstUniqueCharacter {

    public static int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> lh = new LinkedHashMap<Character, Integer>();
        char[] elements = s.toCharArray();
        for(int i=0; i<elements.length; i++) {
            char letter = elements[i];
            if (lh.containsKey(letter)) {
                lh.put(letter, -1);
            } else {
                lh.put(letter, i);
            }
        }
        Set<Character> keys = lh.keySet();
        for (Character key : keys)
            if (lh.get(key) > -1)
                return lh.get(key);
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}

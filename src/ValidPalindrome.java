/*
* https://leetcode.com/problems/valid-palindrome/
* https://leetcode.com/problems/longest-palindrome/
* */

import java.util.HashMap;
import java.util.Map;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        char[] phrase = s.toLowerCase().toCharArray();
        int left = 0, right = phrase.length - 1;
        while (left < right) {
            if (phrase[left] != phrase[right])
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static int longestPalindrome(String s) {
        int result = 0;
        int odd = 0;
        HashMap<Character, Integer> count = new HashMap<>();
        for(char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 1 && entry.getValue()%2 == 0)
                result += entry.getValue();
            else {
                result += entry.getValue() - 1;
                odd = 1;
            }
        }
        return result+odd;
    }

    public static void main(String[] args) {
        String s = "ccc";
        //System.out.println(s.replaceAll("[^A-Za-z0-9]", ""));
        System.out.print(longestPalindrome(s));

    }
}

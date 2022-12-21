/*
* String Manipulation Problems
* https://leetcode.com/problems/longest-substring-without-repeating-characters/
* https://leetcode.com/problems/word-break/
* https://leetcode.com/problems/minimum-window-substring/ (Note: Solution is wrong)
* */

import java.util.List;

public class StringProblems {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.compareToIgnoreCase(" ") == 0) return 1;
        if (s.length() == 1) return 1;
        int maxlength = 0;
        int len = 0;
        int head = 0, tail = 1;
        while (head < s.length() && tail < s.length()) {
            if(s.substring(head,tail).contains(String.valueOf(s.charAt(tail)))) {
                head++;
            } else {
                tail++;
                len = s.substring(head, tail).length();
                if (len > maxlength) maxlength = len;
            }
        }
        return maxlength;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        for(int i=0; i < dp.length; i++) {
            dp[i] = false;
        }
        dp[0] = true;
        for(int i=0; i <= s.length(); i++) {
            if(dp[i] == true) {
                for(String word : wordDict) {
                    if(i + word.length() <= s.length()) // checking bounds
                        if(s.substring(i, i+word.length()).equalsIgnoreCase(word)) {
                            dp[i+word.length()] = true;
                        }
                }
            }
        }
        return dp[s.length()];
    }

    private static boolean isContained(String substr, String sequence) {
        for(int i=0; i < substr.length(); i++) {
            if(!sequence.contains(String.valueOf(substr.charAt(i))))
                return false;
        }
        return true;
    }

    public static String minWindow(String s, String t) {
        String result = "";
        int minLength = 0;
        int left = 0, right = t.length();

        while (left < s.length() && right <= s.length()) {
            if(isContained(t, s.substring(left, right))) {
                if (minLength == 0) minLength = s.substring(left, right).length();
                else minLength = Math.min(minLength, s.substring(left, right).length());
                result = s.substring(left, right);
                left++;
            } else
                right++;
        }
        return result;
    }

    private static boolean isAnagram(String s1, String s2) {
        int[] alphabets = new int[26];
        for(int i=0; i < s1.length(); i++) alphabets[s1.charAt(i) - 'a']++;
        for(int i=0; i < s2.length(); i++) alphabets[s2.charAt(i) - 'a']--;
        for(int i=0; i < alphabets.length; i++)
            if (alphabets[i] != 0) return false;
        return true;
    }

    public static boolean checkInclusion(String s1, String s2) {
        boolean result = false;
        if(s2.length()==0) return false;
       // if(s2.length() == 1)
        int left = 0, right = 1;

        while(left < s2.length() && right < s2.length()) {
            if (isAnagram(s1, s2.substring(left, right+1))) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
//        String s = "applepenapple";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("apple");
//        wordDict.add("pen");
//        wordDict.add("cd");
//        wordDict.add("def");
//        wordDict.add("abcd");
//        System.out.println(wordBreak(s, wordDict));
        //i+word.length()) < s.length()
        //System.out.println(lengthOfLongestSubstring(s));
//        System.out.println('b' - 'b');
        String s = "a";
        String t = "ab";
        //System.out.println(t.substring(0,3));
        System.out.println(checkInclusion(s,t));
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

    public static boolean isAnagram(String s, String t) {
        int[] alphabets = new int[26];
        for(int i=0; i < s.length(); i++) alphabets[s.charAt(i) - 'a']++;
        for(int i=0; i < t.length(); i++) alphabets[t.charAt(i) - 'a']--;
        for(int i=0; i < alphabets.length; i++)
            if (alphabets[i] != 0) return false;
        return true;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if(s.isEmpty() || p.isEmpty()) return new ArrayList<>();
        if(s.length() < p.length()) return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int offset = p.length();
        for(int left=0, right=left+offset; left < s.length() && right < s.length()+1; left++, right=left+offset) {
            String substr = s.substring(left, right);
            if(isAnagram(substr, p))
                result.add(left);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abab", p = "ab";
        System.out.println(findAnagrams(s, p));
    }
}

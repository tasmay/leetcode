import java.util.HashMap;

public class LongestRepeatingCharReplacement {
    public static int characterReplacement(String s, int k) {
        int globalMax = 0;
        int localMax = 1;
        int l = 0, r = l + 1, n = s.length();
        char[] s_arr = s.toCharArray();
        HashMap<Character, Integer> count = new HashMap<>();

        for(int i=0; i<s_arr.length; i++) {
            count.put(Character.valueOf(s_arr[i]), count.getOrDefault(s_arr[i],0) + 1);
        }

      //  char maxChar =

//        while(l<n && r<n) {
//            if(s_arr[l] != )
//        }
        return k;
    }

    public static void main(String[] args){
        System.out.println(characterReplacement("BAA", 1));
    }
}

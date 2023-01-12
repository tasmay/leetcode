import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> mappings = new HashMap<>();

        for(String s: strs) {
            char[] sorted = s.toCharArray();
            Arrays.sort(sorted);
            String key = String.valueOf(sorted);
            List<String> values = mappings.getOrDefault(key, new ArrayList<>());
            values.add(s);
            mappings.put(key, values);
        }

        for(Map.Entry<String, List<String>> entry : mappings.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) {
        //String[] strs = {"ac", "d"};
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        //String[] strs = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        //System.out.println(hashcode("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa") + " - " + hashcode("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(groupAnagrams(strs));
    }
}

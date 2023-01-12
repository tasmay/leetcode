import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    public static HashMap<Character, Character[]> mappings;
    public static ArrayList<String> result;

    public static void backtrack(int i, String curStr, String digits) {
        if (curStr.length() == digits.length()) {
            result.add(curStr);
            return;
        }
        Character[] mapping = mappings.get(digits.charAt(i));
        for(Character c : mapping) {
            backtrack(i+1, curStr+c, digits);
        }
    }

    public static List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        mappings = new HashMap<>();
        mappings.put('2', new Character[]{'a','b','c'});
        mappings.put('3', new Character[]{'d','e','f'});
        mappings.put('4', new Character[]{'g','h','i'});
        mappings.put('5', new Character[]{'j','k','l'});
        mappings.put('6', new Character[]{'m','n','o'});
        mappings.put('7', new Character[]{'p','q','r', 's'});
        mappings.put('8', new Character[]{'t','u','v'});
        mappings.put('9', new Character[]{'w','x','y', 'z'});
        if(!digits.isEmpty())
            backtrack(0, "", digits);
        return result;
    }

    public static void main(String[] args) {
        String digits = "234";
        System.out.println(letterCombinations(digits));
    }
}

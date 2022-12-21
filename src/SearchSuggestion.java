/*
* https://leetcode.com/problems/search-suggestions-system/
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestion {

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<List<String>>();
        Arrays.sort(products, String.CASE_INSENSITIVE_ORDER);
        for(int i=0; i<searchWord.length(); i++) {
            List<String> tmpResult = new ArrayList<String>();
            for(String prod : products) {
                if (prod.startsWith(searchWord.substring(0, i+1)) && tmpResult.size() < 3) {
                    tmpResult.add(prod);
                }
            }
            result.add(tmpResult);
        }
        return result;
    }

    public static void printArray(String strArr[]) {
        for (String string : strArr)
            System.out.print(string + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        String stringArray[] = {"mobile","mouse","moneypot","monitor","mousepad"};
        List<List<String>> searchResult = suggestedProducts(stringArray, "mou");

        String business_names[] = { "burger king", "McDonald's", "super duper burger's", "subway", "pizza hut"};
        String searchTerm = "bur";
    }
}

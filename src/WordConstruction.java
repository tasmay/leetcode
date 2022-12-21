/*
* Word Construction Problems from https://youtu.be/oBt53YbR9Kk
* Understanding dynamic programming / recursion with memoization
* */

import java.util.ArrayList;
import java.util.HashMap;

public class WordConstruction {

    public static Boolean canConstruct(String target, String[] wordBank, HashMap<String , Boolean> memo) {
        if(memo.containsKey(target)) return memo.get(target);
        if(target.isEmpty()) return true;

        for(String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                if(canConstruct(suffix, wordBank, memo) == true) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }

    public static int countConstruct(String target, String[] wordBank, HashMap<String, Integer> memo) {
        if(memo.containsKey(target)) return memo.get(target);
        if(target.isEmpty()) return 1;

        int totalCount = 0;
        for(String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                int count = countConstruct(suffix, wordBank, memo);
                totalCount += count;
            }
        }
        memo.put(target, totalCount);
        return totalCount;
    }

    public static ArrayList<ArrayList<String>> allConstruct(String target, String[] wordBank) {
        if(target.isEmpty()) return new ArrayList<ArrayList<String>>();

        int totalCount = 0;
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        for(String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                ArrayList<ArrayList<String>> suffixWays = allConstruct(suffix, wordBank);
                ArrayList<ArrayList<String>> targetWays = new ArrayList<ArrayList<String>>();
                for (ArrayList<String> way: suffixWays) {
                    way.add(word);
                    targetWays.add(way);
                }
                result = targetWays;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"aaaa","aaa"};
        String target = "aaaaaaa";
        HashMap<String , Boolean> memo = new HashMap<>();
        System.out.println(canConstruct(target, words, memo));
//        HashMap<String , Integer> memo = new HashMap<>();
//        System.out.println(countConstruct(target, words, memo));

//        ArrayList<ArrayList<String>> myList = new ArrayList<ArrayList<String>>();
//        ArrayList<String> listofstrings = new ArrayList<>();
//        listofstrings.add("pur");
//        listofstrings.add("ple");
//        myList.add(listofstrings);
//        System.out.println(myList);

        //System.out.println(allConstruct(target, words));

    }
}

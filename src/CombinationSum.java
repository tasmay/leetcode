/*
*
* */

import java.util.ArrayList;
import java.util.HashMap;

public class CombinationSum {

    public static Boolean hasSum(int[] candidates, int target, HashMap<Integer, Boolean> memo) {
        if(memo.containsKey(target)) return memo.get(target);
        if(target == 0) return true;
        if(target < 0) return false;

        for(int num : candidates) {
            int remainder = target - num;
            if (hasSum(candidates, remainder, memo) == true) {
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }

    public static ArrayList<Integer> bestSum(int[] candidates, int target, HashMap<Integer, ArrayList<Integer>> memo) {
        if(memo.containsKey(target)) return memo.get(target);
        if(target == 0) return new ArrayList<>();
        if(target < 0) return null;

        ArrayList<Integer> shortestCombination = null;

        for(int num : candidates) {
            int remainder = target - num;
            ArrayList<Integer> remainderCombination = bestSum(candidates, remainder, memo);

            ArrayList<Integer> combination = new ArrayList<>();

            System.out.println("Remainder for " + remainder + ": " + remainderCombination);
            if (remainderCombination != null) {
                combination.addAll(remainderCombination);
                combination.add(num);
                if(shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }
        memo.put(target, shortestCombination);
        return shortestCombination;
    }

    public static Boolean iterativeHasSum(int[] candidates, int target) {
        Boolean[] table = new Boolean[target+1];
        for(int i=0; i<table.length; i++)
            table[i] = false;
        table[0] = true;

        for(int i=0; i<table.length; i++) {
            if (table[i] == true) {
                for (int j = 0; j < candidates.length; j++) {
                    int index = candidates[j];
                    if ((i + index) < table.length) table[i + index] = true;
                }
            }
        }
        return table[target];
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{1};
        int target = 0;
        HashMap<Integer, ArrayList<Integer>> memomap = new HashMap<>();
        System.out.println(bestSum(candidates, target, memomap));
//        HashMap<Integer, Boolean> memo = new HashMap<>();
//        System.out.println(hasSum(candidates, target, memo));
//        System.out.println(iterativeHasSum(candidates, target));
    }
}
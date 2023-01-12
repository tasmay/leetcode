/*
* https://leetcode.com/problems/unique-paths/
* */

import java.math.BigInteger;
import java.util.HashMap;

public class UniquePaths {

    public static BigInteger uniquePaths(int m, int n) {
        HashMap<String, BigInteger> memo = new HashMap<String, BigInteger>();
        return uniquePaths(m, n, memo);
    }

    private static BigInteger uniquePaths(int m, int n, HashMap<String, BigInteger> memo) {
        String key = String.valueOf(m) + ',' + String.valueOf(n);
        if(memo.containsKey(key)) return memo.get(key);
        if(m==1 && n==1) return BigInteger.valueOf(1);
        if(m==0 || n==0) return BigInteger.valueOf(0);
        memo.put(key, uniquePaths(m-1, n, memo).add(uniquePaths(m, n-1, memo)));
        return memo.get(key);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
}

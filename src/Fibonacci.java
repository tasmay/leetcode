/*
* https://leetcode.com/problems/fibonacci-number/description/
* */

import java.math.BigInteger;
import java.util.HashMap;

public class Fibonacci {

    // Fibonacci with memoization
    public static BigInteger fib(Integer num, HashMap<Integer, BigInteger> memo) {
        if(num == null) return null;
        if(memo.containsKey(num)) return memo.get(num);
        if(num<=2) return BigInteger.valueOf(1);
        memo.put(num, fib(num - 2, memo).add(fib(num - 1, memo)));
        return memo.get(num);
    }

    public static Integer iterativeFib(Integer n) {
        if (n==0) return 0;
        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }

    public static void main(String[] args) {
//        HashMap<Integer, BigInteger> memo = new HashMap<Integer, BigInteger>();
//        System.out.println(fib(50, memo));
        System.out.println(iterativeFib(7));
    }
}

/*
* Leetcode # 70: https://leetcode.com/problems/climbing-stairs/
* Solution is incorrect for some cases.
* */

public class ClimbingStairs {
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        int[] steps = new int[]{1,2};
        dp[0] = 0;
        for(int i=1; i < dp.length; i++) {
            for(int j=0; j < steps.length; j++)
                if (i-steps[j] > 0)
                    dp[i] = dp[i] + (i-steps[j]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.print(climbStairs(2));
    }
}

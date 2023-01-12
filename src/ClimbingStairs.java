/*
* Leetcode # 70: https://leetcode.com/problems/climbing-stairs/
* Solution is incorrect for some cases.
* */

public class ClimbingStairs {
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i < dp.length; i++) {
                dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = cost[0];
        for(int i=2; i < n+1; i++) {
            dp[i] = cost[i-1] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n], dp[n-1]);
    }

    public static void main(String[] args) {
        //System.out.print(climbStairs(5));
        int[] cost = {10,15,20};
        System.out.print(minCostClimbingStairs(cost));
    }
}

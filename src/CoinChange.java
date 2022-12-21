/*
* https://leetcode.com/problems/coin-change/
* */

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=0; i < dp.length; i++)
            dp[i] = amount+1;
        dp[0] = 0;

        for(int i=1; i < dp.length; i++) {
            for(int coin : coins) {
                if(i-coin >= 0) {
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                }
            }
        }
        if (dp[amount] != amount+1)
            return dp[amount];
        else return -1;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println("result = " + coinChange(coins, amount));
    }
}

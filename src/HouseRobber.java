/*
* https://leetcode.com/problems/house-robber/
* */

public class HouseRobber {

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=1; i < nums.length; i++) {
            if(i-1 == 0 && i+1 == nums.length-1)
                dp[i+1] = dp[i];
            else
                dp[i+1] = Math.max(dp[i-1]+nums[i], dp[i]);
        }
        return dp[nums.length];
    }


    public static void main(String[] args) {
        int[] nums =  {2,3,2};
        System.out.print(rob(nums));
    }
}

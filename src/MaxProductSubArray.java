/*
* https://leetcode.com/problems/maximum-product-subarray/
* Incorrect solution - needs work
* */

public class MaxProductSubArray {

    public static int maxProduct(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=1; i < nums.length; i++) {
            int tmp = Math.max(dp[i], nums[i]*nums[i-1]);
            dp[i+1] = Math.max(tmp, nums[i]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] nums =  {-2,3,-4};
        System.out.print(maxProduct(nums));
    }
}

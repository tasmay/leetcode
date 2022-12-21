/*
* https://leetcode.com/problems/3sum/
* */

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if(nums.length == 0 || nums.length < 3) return new ArrayList<>(result);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            int j = i+1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < 0) j++;
                else if (sum > 0) k--;
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}

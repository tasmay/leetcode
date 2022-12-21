/*
* https://leetcode.com/problems/two-sum/
* */

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> twoSumMap = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            int key = target - nums[i];
            if (twoSumMap.containsKey(key)) {
                return new int[]{i, twoSumMap.get(key)};
            }
            twoSumMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,5};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}

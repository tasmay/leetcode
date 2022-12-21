/*
* https://leetcode.com/problems/contains-duplicate
* */

import java.util.HashMap;

public class containsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        boolean result = false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i]))
                return true;
            else
                map.put(nums[i], nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,1};
        System.out.println(containsDuplicate(nums));
    }
}

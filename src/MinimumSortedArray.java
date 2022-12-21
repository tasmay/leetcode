/*
* https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
* */

public class MinimumSortedArray {

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{11,13,15,17};
        System.out.println(findMin(nums));
    }
}

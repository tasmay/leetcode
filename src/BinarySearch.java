/*
* Leetcode # 704: https://leetcode.com/problems/binary-search/
* */

public class BinarySearch {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,8,9,12};
        int target = 5;
        System.out.println(search(nums, target));
    }
}

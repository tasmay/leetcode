/*
* https://leetcode.com/problems/kth-largest-element-in-an-array/
* */

import java.util.PriorityQueue;

public class KthLargest {

    public static int findKthLargest(int[] nums, int k) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a<b ? 1 : -1);
        for(int i=0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        for(int i=0; i<k; i++) {
            result = pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.print(findKthLargest(nums, k));
    }
}

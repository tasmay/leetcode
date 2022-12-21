/*
* https://leetcode.com/problems/top-k-frequent-elements/
* */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopkFrequent {
    public static int[] topKFrequent(int[] nums, int k) {

        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return count.get(b) - count.get(a);
            }
        });

        for (int n: count.keySet()) {
            heap.add(n);
        }

        int[] topk = new int[k];
        for(int i = 0; i < k; i++) {
            topk[i] = heap.poll();
        }
        return topk;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,2,2,4,4,1,1,1,2,6};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        for(int i=0; i<result.length; i++)
            System.out.println(result[i]);
    }
}

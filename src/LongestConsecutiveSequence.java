import java.util.Iterator;
import java.util.TreeSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        if(nums.length <= 0) return 0;
        int globalCount = 0;
        int count = 1;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i=0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        Iterator<Integer> it = set.iterator();
        int prev_value = it.next();
        while(it.hasNext()) {
            int current_value = it.next();
            if (current_value-prev_value == 1)
                count++;
            else {
                globalCount = Math.max(globalCount, count);
                count = 1;
            }
            prev_value = current_value;
        }
        globalCount = Math.max(globalCount, count);
        return globalCount;
    }

    public static void main(String[] args) {
       // int[] nums = {100,4,200,1,3,2};
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }
}

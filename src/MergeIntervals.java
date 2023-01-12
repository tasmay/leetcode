import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    private static boolean hasOverlap(int[] a, int[] b) {
        return a[1] >= b[0];
    }

    public static int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i=0; i < intervals.length; i++) {
                if(result.isEmpty() || !hasOverlap(result.getLast(), intervals[i])) {
                    result.add(intervals[i]);
                } else {
                    result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
                }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(intervals));
    }
}

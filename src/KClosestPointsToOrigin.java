/*
* https://leetcode.com/problems/k-closest-points-to-origin/
* */

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int k) {
        if(points == null || points.length == 0)
            return null;
        int[][] result = new int[k][2];
        PriorityQueue<int[]> all_distances = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return distanceFromOrigin(o1) - distanceFromOrigin(o2);
            }
        });

        for(int i=0; i < points.length; i++) {
            all_distances.add(points[i]);
        }

        for (int i=0; i < k; i++) {
            result[i] = all_distances.poll();
        }

        return result;
    }

    private static int distanceFromOrigin(int[] point) {
       int x = point[0];
       int y = point[1];
        int d = (x * x) + (y * y);
        return d;
    }

    public static void main(String[] args) {
        //int[][] points = {{1,3},{-2,2}};
        int[][] points = {{3,3},{5,-1}, {-2,4}};
        int k = 2;
        System.out.println(kClosest(points, k));
    }
}

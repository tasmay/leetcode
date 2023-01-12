/*
* https://leetcode.com/problems/cheapest-flights-within-k-stops/submissions/863853114/
* */

import java.util.ArrayList;
import java.util.Arrays;

public class CheapestFlightsKStops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        for(int i=0; i < k+1; i++) {
            int[] temp = Arrays.copyOf(distances, n);
            for(int[] flight : flights) {
                int a = flight[0], b = flight[1], w = flight[2];
                if (distances[a] != Integer.MAX_VALUE) {
                    temp[b] = Math.min(temp[b], distances[a]+w);
                }
            }
            distances = temp;
        }
        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }

    public static void main(String[] args) {
        int[][] flights = new int[][]{ {0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200} };
        int n = 4, src = 0, dst = 3, k = 1;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }
}

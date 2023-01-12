/*
* https://leetcode.com/problems/sum-of-distances-in-tree/
* */

import java.util.Arrays;

public class SumOFDistancesInTree {

    public static int[] bellmanFord(int[][] graph, int src, int n) {
        int[] distances = new int[n];
        Arrays.fill(distances, 0);
        for(int i=0; i < n-1; i++) {
            for(int[] edge : graph) {
                int a = edge[0], b = edge[1];
                distances[b] = distances[a]+1;
            }
        }
        return distances;
    }

    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] sumOfDistances = new int[n];
        Arrays.fill(sumOfDistances, 0);
        int[] temp = bellmanFord(edges, 1, n);
//        for(int i=0; i < n; i++) {
//            int[] temp = bellmanFord(edges, i, n);
//        }
        return sumOfDistances;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        System.out.println(sumOfDistancesInTree(n, edges));
    }
}

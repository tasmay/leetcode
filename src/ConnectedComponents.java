/*
* Leetcode 323. Number of Connected Components in an undirected graph
* */

import java.util.Arrays;

public class ConnectedComponents {

    public static int[] link;
    public static int[] size;

    private static int find(int x){
        while(x != link[x]) x = link[x];
        return x;
    }

    private static boolean same(int a, int b) {
        return find(a) == find(b);
    }

    private static int unify(int a, int b) {
        a = find(a);
        b = find(b);
        if(a==b) return 0;
        if (size[a] > size[b]) {
            size[a] += size[b];
            link[b] = link[a];
         } else {
            size[b] += size[a];
            link[a] = link[b];
        }
        return 1;
    }

    public static int totalComponents(int[][] edges, int n) {
        int totalComponents = n;
        link = new int[n];
        size = new int[n];
        for(int i=0; i < n; i++) link[i] = i;
        Arrays.fill(size, 1);
        for(int i=0; i < edges.length; i++) {
            totalComponents -= unify(edges[i][0], edges[i][1]);
        }
        return totalComponents;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{1,2},{3,4}};
        int n = 5;
        System.out.println(totalComponents(edges, n));
    }
}

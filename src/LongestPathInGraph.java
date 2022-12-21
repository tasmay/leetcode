/*
* Longest Path in a graph
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LongestPathInGraph {
    public static int[] longestPath(HashMap<Integer, List<Integer>> graph) {
        int[] result = new int[graph.size()];

        for(int i=0; i < graph.size(); i++) {
            result[i] = dfs(graph, i);
        }
        return result;
    }

    public static int dfs(HashMap<Integer, List<Integer>> graph, int i) {
        if(graph.get(i).isEmpty()) return 0;
        int result = 0;
        for(Integer edge : graph.get(i)) {
            int pathsize = dfs(graph, edge) + 1;
            result = Math.max(result, pathsize);
        }
        return result;
    }

    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new Integer[]{1,2}));
        graph.put(1, Arrays.asList(new Integer[]{2}));
        graph.put(2, Arrays.asList(new Integer[]{3}));
        graph.put(3, Arrays.asList(new Integer[]{}));
        graph.put(4, Arrays.asList(new Integer[]{3}));

        int[] result = longestPath(graph);
        for(int i=0; i < result.length; i++)
            System.out.print(result[i]);
    }
}

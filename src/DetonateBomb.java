import java.util.*;
import java.util.LinkedList;

public class DetonateBomb {

    public static int maximumDetonation(int[][] bombs) {
        int totalBombs = bombs.length;

        // construct a directed graph
        Map<Integer, List<Integer>> graph = new HashMap();
        for(int i=0; i < totalBombs; i++) {
            // initialize the edge list for node i
            if(!graph.containsKey(i)) graph.put(i, new ArrayList<>());
            for(int j=0; j < totalBombs; j++) {
                if(i==j) continue;
                if(detonates(bombs[i], bombs[j]))
                    graph.get(i).add(j);
            }
        }

        // find max detonated bombs through dfs
        int[] totalDetonated = new int[totalBombs];
        for(int i=0; i < totalBombs; i++) {
            int currentMax = 0;
            boolean[] visited = new boolean[totalBombs];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;
            while(!queue.isEmpty()) {
                int current = queue.remove();
                currentMax += 1;
                List<Integer> adj = graph.get(current);
                for(Integer to : adj) {
                    if(!visited[to]) {
                        queue.add(to);
                        visited[to] = true;
                    }
                }
            }
            totalDetonated[i] = currentMax;
        }
        return Arrays.stream(totalDetonated).max().getAsInt();
    }

    // checks whether the coordinates of bomb y lie in the radius of the circle x
    private static boolean detonates(int[] x, int[] y) {
        return (long) Math.pow(x[0]-y[0], 2) + Math.pow(x[1]-y[1], 2) - Math.pow(x[2], 2) <= 0;
    }

    public static void main(String[] args) {
        //int[][] bombs = new int[][]{ {1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4} };
        //int[][] bombs = new int[][]{ {1,1,5},{10,10,5} };
        //int[][] bombs = new int[][]{ {1,1,100000},{100000,100000,1} };
        int[][] bombs = new int[][]{ {2,1,3},{6,1,4} };
        System.out.println(maximumDetonation(bombs));
    }
}

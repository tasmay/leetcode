/*
* Kahn's Algorithm for Topological Sort in DAG
* */

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {

    public static LinkedList findTopologicalSort(int[][] graph) {
        int n = graph.length;
        LinkedList<Integer> order = new LinkedList<>();
        int[] in_degrees = new int[n];
        LinkedList<Integer> queue = new LinkedList<>();

        // loop through all nodes of the graph and increment the count of
        // in-degrees for all nodes it points to
        for(int i=0; i<n; i++) {
            for(int dst : graph[i]) {
                in_degrees[dst] += 1;
            }
        }

        // loop over the in-degree array and add all nodes to queue that have 0 in-degrees
        for(int i=0; i < n; i++) {
            if(in_degrees[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int node = queue.pop();
            order.add(node);
            for(int dst : graph[node]) {
                in_degrees[dst] -= 1;
                if (in_degrees[dst] == 0)
                    queue.add(dst);
            }
        }
        return order;
    }

    public static void main(String[] args) {
       // int[][] graph = {{1,3}, {2}, {5}, {4}, {1,2}, {}};
        int[][] graph = {{1,2},{3},{3},{}}; // not a good representation though
        System.out.println(findTopologicalSort(graph));
    }
}

import java.util.*;

public class ShortestPathAlgos {

    public static int[] dijkstra(ArrayList[] graph, int startnode, int numNodes) {
        int[] distances = new int[numNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startnode] = 0;

        PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.add(new Integer[]{startnode, 0});

        while(!pq.isEmpty()) {
            Integer[] currentNode = pq.poll();
            int node = currentNode[0];
            ArrayList edges = graph[node];
            Iterator it = edges.iterator();
            while (it.hasNext()) {
                Integer[] e = (Integer[]) it.next();
                int to_node = e[0], cost = e[1];
                int newDist = distances[node] + cost;
                if(newDist < distances[to_node]) {
                    distances[to_node] = newDist;
                    pq.add(new Integer[]{to_node, newDist});
                }
            }
        }
        return distances;
    }

    public static int[] bellmanFord(int[][] graph, int src, int n) {
        int[] distances = new int[n];
        for(int i=0; i<n; i++) distances[i] = Integer.MAX_VALUE;
        distances[src] = 0;
        for(int i=0; i < n-1; i++) {
            for(int[] edge : graph) {
                int a = edge[0], b = edge[1], w = edge[2];
                distances[b] = Math.min(distances[b], distances[a]+w);
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        // driver code for bellman ford algo
        //int[][] graph = new int[][]{ {0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200} };
        int[][] graph = new int[][]{ {0,1,100},{1,2,200},{2,0,100},{1,3,600},{2,3,200} };
        int src = 0, n = 4;
        int[] result = bellmanFord(graph, src, n);
        System.out.println("Bellman Ford:");
        for(int d : result) System.out.print(d + " ");
        System.out.println();

        // driver code for dijkstra's algo
        ArrayList<Integer[]> n0 = new ArrayList<>();
        n0.add(new Integer[]{1,100});

        ArrayList<Integer[]> n1 = new ArrayList<>();
        n1.add(new Integer[]{2,200});
        n1.add(new Integer[]{3,600});

        ArrayList<Integer[]> n2 = new ArrayList<>();
        n2.add(new Integer[]{0,100});
        n2.add(new Integer[]{3,200});

        ArrayList<Integer[]> n3 = new ArrayList<>();

        ArrayList[] graph2 = new ArrayList[]{n0, n1, n2, n3};
        int startnode = 0, numNodes = 4;
        int[] result2 = dijkstra(graph2, startnode, numNodes);
        System.out.println("Dijkstras:");
        for(int d : result2) System.out.print(d + " ");
    }
}

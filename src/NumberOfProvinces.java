public class NumberOfProvinces {

    public static int[] link;
    public static int[] size;

    private static int find(int x){
        while(x != link[x]) x = link[x];
        return x;
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

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int totalProvinces = n;
        link = new int[n];
        size = new int[n];
        for(int i=0; i < n; i++) {
            link[i] = i;
            size[i] = 1;
        }
        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                if(i==j) continue;
                if (isConnected[i][j] == 1)
                    totalProvinces -= unify(i, j);
            }
        }
        return totalProvinces;
    }

    public static void main(String[] args){
//        int[][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        int[][] isConnected = new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
}

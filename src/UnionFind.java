public class UnionFind {

    public static int[] link;
    public static int[] size;

    public static void init(int n) {
        link = new int[n];
        size = new int[n];
        // initilize the array with each element [0..n)
        for(int i=0; i < n; i++) link[i] = i;
        // initialize the size array with 1
        // (as each element belongs to its own set initially)
        for(int i=0; i < n; i++) size[i] = 1;
    }

    public static int find(int x) {
        while(x != link[x]) x = link[x];
        return x;
    }

    public static boolean same(int a, int b) {
        return find(a) == find(b);
    }

    public static void unify(int a, int b) {
        a = find(a);
        b = find(b);
        if(size[a] > size[b]) {
            link[b] = a;
            size[a] += size[b];
        } else {
            link[a] = b;
            size[b] += size[a];
        }
    }

}

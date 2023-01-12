import java.util.HashMap;

public class DetectCycle {

    UnionFind uf = new UnionFind();

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        uf.init(m * n);
        for(int i=0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && grid[i][j] == grid[i][j + 1]) {
                    if(uf.same(i, j+1)) return true;
                    else uf.unify(i, j + 1);
                }
                if (i + 1 < m && grid[i][j] == grid[i + 1][j]) {
                    if(uf.same(i+1, j)) return true;
                    else uf.unify(i + 1, j);
                }
            }
        }
        return false;
    }

}

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticFlow {

    private static boolean[][] pacific_set;
    private static boolean[][] atlantic_set;

    private static boolean dfs_pacific(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i==0 || j==0) return true; // indicies are on boundary
        if(i-1 < 0 || j-1 < 0) return false; // indicies are out of bounds
        // indicies are within bounds, hence do dfs
        boolean north = false, west = false;
        if (grid[i-1][j] <= grid[i][j])
            north = dfs_pacific(grid,i-1, j);
        if (grid[i][j-1] <= grid[i][j])
            west = dfs_pacific(grid, i, j-1);
        return north || west;
    }

    private static boolean dfs_atlantic(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if(i == m-1 || j == n-1) return true; // indicies are on boundary
        if(i+1 >= m || j+1 >= n) return false; // indicies are out of bounds
        // indicies are within bounds, hence do dfs
        boolean south = false, east = false;
        if (grid[i+1][j] <= grid[i][j])
            south = dfs_atlantic(grid, i+1, j);
        if (grid[i][j+1] <= grid[i][j])
            east = dfs_atlantic(grid, i, j+1);
        return south || east;
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        pacific_set = new boolean[m][n];
        atlantic_set = new boolean[m][n];

        for(int i=0; i < m; i++)
            for(int j=0; j < n; j++) {
                if (dfs_pacific(heights, i, j)) {
                    pacific_set[i][j] = true;
                }
                if (dfs_atlantic(heights, i, j)) {
                    atlantic_set[i][j] = true;
                }
            }

        for(int i=0; i < m; i++)
            for(int j=0; j < n; j++) {
                if(pacific_set[i][j] && atlantic_set[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        return result;
    }

    public static void main(String[] args){
        //int[][] heights = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        int[][] heights = new int[][]{{1,2,3},{8,9,4},{7,6,5}};
        System.out.println(pacificAtlantic(heights));
    }

}

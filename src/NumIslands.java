/*
* https://leetcode.com/problems/number-of-islands/
* https://leetcode.com/problems/max-area-of-island/
* */

public class NumIslands {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int numIslands = 0;
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j]=='1') {
                    numIslands = numIslands + dfs(grid, i, j);
                }
        }
        return numIslands;
    }

    public static int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return 0;
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        return 1;
    }

    /**
     * LEETCODE # 695
     * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
     * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
     * The area of an island is the number of cells with a value 1 in the island.
     * Return the maximum area of an island in grid. If there is no island, return 0.
     */
    public static int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int maxArea = 0;
        for(int i=0; i < grid.length; i++)
            for(int j=0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int area = maxAreaDFS(grid, i, j);
                    if (area > maxArea)
                        maxArea = area;
                }
            }
        return maxArea;
    }

    private static int maxAreaDFS(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        int area = 1;
        area = area + maxAreaDFS(grid, i+1, j) + maxAreaDFS(grid, i-1, j) + maxAreaDFS(grid, i, j+1) + maxAreaDFS(grid, i, j-1);
        return area;
    }

    public static void main(String[] args) {
//        char[][] grid = {
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}
//        };
//        char[][] grid = {
//                {'1'}, {'1'}
//        };
//        System.out.println(numIslands(grid));
        int[][] grid = { {0,0,1,0,0,0,0,1,0,0,0,0,0}
                        ,{0,0,0,0,0,0,0,1,1,1,0,0,0}
                        ,{0,1,1,0,1,0,0,0,0,0,0,0,0}
                        ,{0,1,0,0,1,1,0,0,1,0,1,0,0}
                        ,{0,1,0,0,1,1,0,0,1,1,1,0,0}
                        ,{0,0,0,0,0,0,0,0,0,0,1,0,0}
                        ,{0,0,0,0,0,0,0,1,1,1,0,0,0}
                        ,{0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(grid));
    }
}

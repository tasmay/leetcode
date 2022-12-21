/**
 * https://leetcode.com/problems/01-matrix/
 * Note: incomplete and unverified solution
 */

public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) return null;
        int[][] result = new int[mat.length][mat[0].length];

        for(int i=0; i<mat.length; i++)
            for(int j=0; j<mat[i].length; j++) {
                if(mat[i][j] == 0)
                    result[i][j] = 0;
                else {
                    result[i][j] = dfs(mat, i, j);
                }
            }
        return result;
    }

    private static int dfs(int[][] mat, int i, int j) {
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[i].length || mat[i][j] == 0)
            return 1;
        dfs(mat, i-1, j);
        dfs(mat, i+1, j);
        dfs(mat, i, j-1);
        dfs(mat, i, j+1);
        return 1;
    }

    public static void main(String[] args) {

    }
}

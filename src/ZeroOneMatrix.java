import java.util.Arrays;

/**
 * https://leetcode.com/problems/01-matrix/
 * Note: incomplete and unverified solution
 */

public class ZeroOneMatrix {

    public static int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) return null;
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        int INF = m*n;
        // check top and left
        for(int i=0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int up = (i>0) ? dp[i-1][j] : INF;
                    int left = (j>0) ? dp[i][j-1] : INF;
                    dp[i][j] = Math.min(up,left) + 1;
                }
            }
        }
        // check bottom and right
        for(int i=m-1; i>=0; i--)
            for(int j=n-1; j>=0; j--) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int down = (i<m-1) ? dp[i + 1][j] : INF;
                    int right = (j<n-1) ? dp[i][j + 1] : INF;
                    dp[i][j] = Math.min(dp[i][j], Math.min(down,right) + 1);
                }
            }
        return dp;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        System.out.println(updateMatrix(mat));
    }
}

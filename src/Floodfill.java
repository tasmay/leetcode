/*
* https://leetcode.com/problems/flood-fill/
* */

public class Floodfill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color)
            return image;
        floodFillDFS(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public static void floodFillDFS(int[][] image, int i, int j, int color, int orig_color) {
        if(i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != orig_color)
            return;
        image[i][j] = color;
        floodFillDFS(image, i-1, j, color, orig_color); // top
        floodFillDFS(image, i+1, j, color, orig_color); // bottom
        floodFillDFS(image, i, j-1, color, orig_color); // left
        floodFillDFS(image, i, j+1, color, orig_color); // right
    }

    public static void main(String[] args) {
        //int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] image = {{0,0,0},{0,0,0}};
        System.out.println(floodFill(image, 1,0, 2));
        System.out.println();
    }
}

public class WordSearch {

    public static boolean[][] visited;

    public static boolean search(char[][] board, int x, int y, char[] word, int i) {
        // return from edge cases
        if(i == word.length) return true;
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y] || board[x][y] != word[i])
            return false;
        visited[x][y] = true;
        // search next character in all directions
        // return true if character found in any one direction
        if (search(board, x, y+1, word, i+1)
            || search(board, x+1, y, word, i+1)
            || search(board, x, y-1, word, i+1)
            || search(board, x-1, y, word, i+1))
            return true;
        // else return false, character not found
        visited[x][y] = false;
        return false;
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] w = word.toCharArray();
        visited = new boolean[m][n];
        for(int i=0; i < m; i++)
            for(int j=0; j < n; j++) {
                if(search(board, i, j, w, 0)) {
                    return true;
                }
            }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        System.out.println(exist(board, word));
    }
}

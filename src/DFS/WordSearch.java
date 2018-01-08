package DFS;

import static jdk.nashorn.internal.objects.Global.println;

public class WordSearch {
    int[] deltaX = new int[]{0, 0, 1,-1};
    int[] deltaY = new int[]{1,-1,0,0};
    WordSearch(){};
    public boolean exist(char[][] board, String word) {
        //cornor case
        if (board == null || board.length == 0) {
            return !(word == null || word.length() == 0);
        }

        //visited
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //if visited, not need to do it
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int start) {
        if (start == word.length()) {
            return true;
        }

        if (!inBound(board,i, j) || visited[i][j] || board[i][j] != word.charAt(start)) {
            return false;
        }

        visited[i][j] = true;

        for (int q = 0; q < deltaX.length;q++) {
            int r = i + deltaX[q];
            int c = j + deltaY[q];
            if (dfs(board, word, visited, r, c, start + 1)) {
                return true;
            }
        }

        visited[i][j] = false;
        return false;
    }

    private boolean inBound (char[][] board, int i , int j) {
        int m = board.length;
        int n = board[0].length;
        return (i >= 0 && i < m) && (j >= 0 && j < n);
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        boolean res = ws.exist(board, word);
        System.out.println(res);
    }
}

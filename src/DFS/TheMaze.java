package DFS;

public class TheMaze {
    public TheMaze(){

    }

    int[] deltaX = new int[]{0,0,1,-1};
    int[] deltaY = new int[]{1,-1,0,0};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        helper(start,destination,visited,maze);
        int desR = destination[0];
        int desC = destination[1];
        printVisited(visited);
        return visited[desR][desC];
    }

    private void helper(int[] start, int[] destination, boolean[][] visited, int[][] maze) {
        int startR = start[0];
        int startC = start[1];
        int endR = destination[0];
        int endC = destination[1];


        if (!inBound(startR, startC,maze) || visited[startR][startC] || maze[startC][startR] == 1) {
            return;
        }

        if (visited[endR][endC]) {
            return;
        }

        visited[startR][startC] = true;

        for (int i = 0; i < deltaX.length; i++) {
            int r = startR + deltaY[i];
            int c = startC + deltaX[i];
            int[] next = new int[]{r,c};
            helper(next, destination, visited, maze);
        }
    }

    private boolean inBound(int r, int c, int[][]maze) {
        int m = maze.length;
        int n = maze[0].length;
        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }

    private void printVisited(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j]) {
                    System.out.print("T" + " ");
                } else {
                    System.out.print("F" + " ");
                }
            }
            System.out.println();
        }
    }
}

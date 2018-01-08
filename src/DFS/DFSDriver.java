package DFS;

public class DFSDriver {
    public static void main(String args[]){
        TheMaze maze = new TheMaze();
        int[][] matrix = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{0,4};
        int[] end = new int[]{3,2};
        maze.hasPath(matrix, start,end);
    }
}

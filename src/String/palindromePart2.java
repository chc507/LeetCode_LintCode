package String;

public class palindromePart2 {
    public palindromePart2(){}
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut  = new int[n];
        boolean[][] pal = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (c[i] == c[j] && i - j < 2 || pal[j + 1][i - 1]) {
                    pal[i][j] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n-1];
    }
}


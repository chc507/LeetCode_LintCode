package BInarySearch;

public class SearchMatrixII {
    /*
    O(m + n)
     */
    SearchMatrixII(){};
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
            int i = 0;
            int j = matrix[0].length;

            while (i <matrix.length && j >= 0) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] < target) {
                    i++;
                } else {
                    j--;
                }
            }

        return false;
    }
}

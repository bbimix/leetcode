package 矩阵;

import java.util.HashSet;
import java.util.Set;

/**
 * 矩阵置零
 */

public class Lc73 {

    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i : row) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j : col) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
    }

}

package 递归回溯.矩阵最长递增路径;

/**
 * @projectName: leetcode
 * @package: 递归回溯.矩阵最长递增路径
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/20 14:51
 */
public class Solution {

    private int recurtion(int[][] matrix, int i, int j, int n, int m) {
        int max = 0;
        if (j + 1 < m && matrix[i][j + 1] > matrix[i][j]) {
            max = Math.max(recurtion(matrix, i, j + 1, n, m), max);
        }
        if (i + 1 < n && matrix[i + 1][j] > matrix[i][j]) {
            max = Math.max(recurtion(matrix, i + 1, j, n, m), max);
        }
        if (j - 1 > 0 && matrix[i][j - 1] > matrix[i][j]) {
            max = Math.max(recurtion(matrix, i, j - 1, n, m), max);
        }
        if (i - 1 > 0 && matrix[i - 1][j] > matrix[i][j]) {
            max = Math.max(recurtion(matrix, i - 1, j, n, m), max);
        }

        return max + 1;
    }

    public int solve (int[][] matrix) {
        int max = 0;
        int n = matrix.length;
        if (n == 0) {
            return max;
        }
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(recurtion(matrix, i, j, n, m), max);
            }
        }
        return max;
    }
}

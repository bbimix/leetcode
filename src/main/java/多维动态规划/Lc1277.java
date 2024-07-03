package 多维动态规划;

/**
 * 统计全为1的正方形子矩阵
 */

public class Lc1277 {
    public int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0)
                    dp[i][j] = 0;

                else if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                }

                else  {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }

                res += dp[i][j];
            }
        }
        return res;
    }
}

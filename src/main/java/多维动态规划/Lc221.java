package 多维动态规划;

/**
 * 最大正方形
 */

public class Lc221 {
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i - 1 >= 0 && j - 1 >= 0 && matrix[i - 1][j - 1] - '0' > 0) {
                        int pre = dp[i - 1][j - 1];
                        int sq = (int) Math.sqrt(pre);
                        for (int k = 1; k <= sq; k++) {
                            if (matrix[i][j - k] == '0' || matrix[i - k][j] == '0') {
                                dp[i][j] = (1 + k) * (1 + k);
                                break;
                            }
                        }
                        if (dp[i][j] != 1)
                            dp[i][j] = (sq + 1) * (sq + 1);
                    } else {
                        dp[i][j] = 1;
                    }

                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','1','1','1','0'},
                {'1','1','1','1','0'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'0','0','1','1','1'}
        };
        Lc221 solution = new Lc221();
        int res = solution.maximalSquare(matrix);
        System.out.println(res);
    }
}

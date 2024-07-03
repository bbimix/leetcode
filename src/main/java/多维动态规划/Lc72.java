package 多维动态规划;

/**
 * 编辑距离
 * 一次A过
 */

public class Lc72 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        char[] cc1 = word1.toCharArray();
        char[] cc2 = word2.toCharArray();
        int[][] dp = new int[n2 + 1][n1 + 1];


        for (int i = 1; i < n1 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < n2 + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < n2 + 1; i++) {
            for (int j = 1; j < n1 + 1; j++) {
                if (cc2[i - 1] == cc1[j - 1]) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) + 1, dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n2][n1];

    }
}

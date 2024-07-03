package 多维动态规划;

/**
 * 最长公共子序列
 * 一次A过
 */

public class Lc1143 {
    public int longestCommonSubsequence(String text1, String text2) {

        int n1 = text1.length();
        int n2 = text2.length();

        char[] cc1 = text1.toCharArray();
        char[] cc2 = text2.toCharArray();

        int[][] dp = new int[n2 + 1][n1 + 1];

        for (int i = 1; i < n2 + 1; i++) {

            for (int j = 1; j < n1 + 1; j++) {
                if (cc2[i - 1] == cc1[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n2][n1];

    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        Lc1143 lc1143 = new Lc1143();
        int res = lc1143.longestCommonSubsequence(text1, text2);
        System.out.println(res);
    }
}

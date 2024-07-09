package 动态规划;

/**
 * 交错字符串
 */

public class Lc97 {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        char[] ss3 = s3.toCharArray();

        dp[0][0] = true;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && ss1[i - 1] == ss3[i - 1];
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && ss2[j - 1] == ss3[j - 1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i - 1][j] && ss3[i + j - 1] == ss1[i - 1]) {
                    dp[i][j] = true;
                } else if (dp[i][j - 1] && ss3[i + j - 1] == ss2[j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        boolean res = isInterleave(s1, s2, s3);
        System.out.println(res);
    }
}

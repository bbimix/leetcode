package 动态规划.编辑距离1;

/**
 * @projectName: leetcode
 * @package: 动态规划.编辑距离1
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/4 21:10
 */
public class Solution {
    public int editDistance (String str1, String str2) {

        int leng1 = str1.length(), leng2 = str2.length();
        int[][] dp = new int[leng1][leng2];

        dp[0][0] = str1.charAt(0) == str2.charAt(0) ? 0 : 1;

        for (int i = 1; i < leng1; i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }

        for (int j = 1; j < leng2; j++) {
            if (str1.charAt(0) == str2.charAt(j)) {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = dp[0][j - 1] + 1;
            }
        }


        for (int i = 1; i < leng1; i++) {
            for (int j = 1; j < leng2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[leng1 - 1][leng2 - 1];
    }
}

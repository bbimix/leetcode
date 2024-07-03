package 动态规划.正则表达式;

/**
 * @projectName: leetcode
 * @package: 动态规划.正则表达式
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/7 15:11
 */
public class Solution {
    public boolean match (String str, String pattern) {

        if (pattern.charAt(0) == '*') {
            return false;
        }

        int leng1 = str.length(), leng2 = pattern.length();
        /**
         * dp[i][j]表示到i，j的字符与模式是否匹配，1是0否
         * 再填充其他
         * 返回
         */
        int[][] dp = new int[leng1 + 1][leng2 + 1];

        for (int i = 0; i < leng1 + 1; i++) {
            for (int j = 0; j < leng2 + 1; j++) {
                if (j == 0) {
                    dp[i][j] = i == 0 ? 1 : 0;
                } else {
                    if (pattern.charAt(j - 1) != '*') {
                        if (i > 0 && (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {
                        if (j >= 2) {
                            dp[i][j] = dp[i][j - 2];
                        }
                        if (i >= 1 && j >= 2 && (str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.')) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }


            }
        }
        return dp[leng1][leng2] == 1 ? true : false;
    }
}

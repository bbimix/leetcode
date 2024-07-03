package 动态规划.最长括号子串;

/**
 * @projectName: leetcode
 * @package: 动态规划.最长括号子串
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/18 18:02
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int leng = s.length();
        int res = 0;

        if (leng == 0 || s == null) {
            return res;
        }

        int[] dp = new int[leng];
        dp[0] = 0;

        for (int i = 1; i < leng; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    dp[i] = (i - dp[i - 1] > 1 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

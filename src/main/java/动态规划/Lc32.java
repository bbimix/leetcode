package 动态规划;

import java.util.Arrays;
import java.util.Stack;

/**
 * 最长有效括号
 */
public class Lc32 {

    public static int longestValidParentheses(String s) {

        int length = s.length();
        int[] dp = new int[length];
        int max = 0;

        if (length < 2)
            return 0;

        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }
}

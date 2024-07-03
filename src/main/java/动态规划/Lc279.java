package 动态规划;

import java.util.HashSet;
import java.util.Set;

/**
 * 完全平方数
 * 给定一个整数n
 * 返回和为n的所需最少完全平方数的数量
 */

public class Lc279 {

    private static Set<Integer> sqrt = new HashSet<>();

    static {
        for (int i = 1; i * i <= 10000; i++) {
            sqrt.add(i * i);
        }
    }

    public static int numSquares(int n) {
        if (sqrt.contains(n)) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (sqrt.contains(n)) {
                dp[i] = 1;
                continue;
            }
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, dp[i - j * j]);
            }
            dp[i] = minn + 1;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }
}

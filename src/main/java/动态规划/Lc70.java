package 动态规划;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * 简单题
 * 爬楼梯
 * 画图发现是斐波那契数列
 */
public class Lc70 {

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[ i - 2];
        }
        return dp[n];
    }

    /**
     * 还可以用递归剪枝来做
     */
    public static int climbStairsdfs(int n) {

        if (n == 1 || n == 0)
            return 1;

        if (map.containsKey(n))
            return map.get(n);

        int n_1 = climbStairsdfs(n - 1);
        int n_2 = climbStairsdfs(n - 2);
        map.put(n - 1, n_1);
        map.put(n - 2, n_2);
        return climbStairsdfs(n - 1) + climbStairsdfs(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(climbStairsdfs(39));
    }


}

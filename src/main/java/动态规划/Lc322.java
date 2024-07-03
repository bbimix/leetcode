package 动态规划;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 零钱兑换
 * 与最少平方数是一样的
 * 自己通过 但是时间久
 */

public class Lc322 {

    public static int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);

        int length = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int j = 0; j < length; j++) {
                if (coins[j] > i)
                    break;
                if (dp[i - coins[j]] >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);

            }
        }

        return dp[amount] == 10001 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        System.out.println(coinChange(coins, amount));
    }
}

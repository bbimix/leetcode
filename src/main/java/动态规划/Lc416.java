package 动态规划;

import java.util.Arrays;

/**
 * 分割等和子集
 * 想不出来
 * 看完题解自己写出来
 */
public class Lc416 {

    public static boolean canPartition(int[] nums) {

        int length = nums.length;

        if (length < 2)
            return false;

        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        boolean[][] dp = new boolean[length][target + 1];


        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i], true);
        }


        for (int j = 1; j <= target; j++) {
            if (nums[0] != j)
                dp[0][j] = false;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= target; j++) {

                if (nums[i] == j)
                    continue;
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    continue;
                }
                dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[length - 1][target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(canPartition(nums));
    }

}

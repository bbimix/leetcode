package 动态规划;

/**
 * 打家劫舍
 */

public class Lc198 {

    public static int rob(int[] nums) {

        int res = 0;
        int length = nums.length;
        int[] dp = new int[length];

        if (length == 1)
            return nums[0];

        if (length == 2)
            return Math.max(nums[0], nums[1]);

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
}

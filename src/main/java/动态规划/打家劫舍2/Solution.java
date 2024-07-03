package 动态规划.打家劫舍2;

import java.util.Arrays;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: 动态规划.打家劫舍2
 * @className: Solution
 * @author: BeamX
 * @description: 环形打家劫舍，新加数字不能算上第一个了。
 * @date: 2023/12/4 20:04
 */
public class Solution {
    public int rob(int[] nums) {
        int leng = nums.length;
        int[] dp = new int[leng + 1];
        dp[1] = nums[0];
        for (int i = 2; i < leng; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }

        int res = dp[nums.length - 1];

        Arrays.fill(dp, 0);

        dp[1] = 0;

        for (int i = 2; i <= leng; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return Math.max(res, dp[leng]);
    }
}

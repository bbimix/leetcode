package 动态规划.打家劫舍1;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: 动态规划.打家劫舍1
 * @className: Solution
 * @author: BeamX
 * @description: 不偷相邻，想要最大间隔一个都偷。
 * 新加数字前一个包含或者不包含。
 * @date: 2023/12/4 19:54
 */
public class Solution {
    public int rob(int[] nums) {
        int leng = nums.length;
        if (leng < 2) {
            return nums[0];
        }
        //保存至某个数字最大值
        int[] dp = new int[leng];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < leng; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}

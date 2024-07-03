package 动态规划;

/**
 * 乘积最大子数组
 * 自己通过了
 * 但是有地方不明白
 */

public class Lc152 {

    public static int maxProduct(int[] nums) {

        int length = nums.length;

        if (length == 1)
            return nums[0];

        int[] dp = new int[length];
        int[] adp = new int[length];

        int res = 0;

        if (nums[0] >= 0) {
            dp[0] = nums[0];
            if (dp[0] > res)
                res = dp[0];
            adp[0] = 0;
        } else {
            dp[0] = 0;
            adp[0] = nums[0];
        }

        for (int i = 1; i < length; i++) {

            if (nums[i] >= 0) {
                if (dp[i - 1] == 0)
                    dp[i] = nums[i];
                else {
                    if (dp[i - 1] == 0) {
                        dp[i] = nums[i];
                    } else {
                        dp[i] = nums[i] * dp[i - 1];
                    }
                }


                adp[i] = nums[i] * adp[i - 1];
            } else {
                if (dp[i - 1] == 0)
                    adp[i] = nums[i];
                else
                    adp[i] = nums[i] * dp[i - 1];

                dp[i] = nums[i] * adp[i - 1];
            }

            if (dp[i] > res)
                res = dp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,-5,-2,-4,3};
        System.out.println(maxProduct(nums));
    }
}
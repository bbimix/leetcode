package 动态规划;

import java.util.Arrays;

public class Lc300 {

    public static int lengthOfLIS(int[] nums) {

        int length = nums.length;

        if (length == 1)
            return 1;

        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = 1;

        int res = 0;
        for (int i = 2; i <= length; i++) {

            int max = -1, maxreal = -1;
            for (int j = 1; j < i; j++) {
                if (dp[j] > max && nums[i - 1] > nums[j - 1])
                    max = dp[j];
                if (dp[j] > maxreal)
                    maxreal = dp[j];
            }

            if (max > 0) {
                dp[i] = max + 1;
                if (dp[i] > res)
                    res = dp[i];
            } else {
                dp[i] = 1;
                if (dp[i] > res)
                    res = dp[i];
            }
        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
//        lengthOfLIS(nums);
        System.out.println(lengthOfLIS(nums));
    }

}

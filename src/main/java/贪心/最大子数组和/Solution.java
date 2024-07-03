package 贪心.最大子数组和;

/**
 * @projectName: leetcode
 * @package: 贪心.最大子数组和
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2024/1/1 16:21
 */
public class Solution {

    /**
     * 官方题解 时间复杂度n
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }



    public int maxSubArray2(int[] nums) {
        int len = nums.length;

        int res = nums[0];

        if (len == 1)
            return res;

        for (int i = 0; i < len; i++) {
            int temp = 0;
            for (int j = i; j < len; j++) {
                temp = temp + nums[j];
                res = Math.max(temp, res);
                if (temp < 0) {
                    break;
                }
            }
        }
        return res;
    }
}

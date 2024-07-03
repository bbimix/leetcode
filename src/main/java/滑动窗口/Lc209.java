package 滑动窗口;

/**
 * 长度最小的子数组
 */

public class Lc209 {
    public int minSubArrayLen(int target, int[] nums) {

        int sum = 0;
        int n = nums.length;
        int l = 0, r = 0;
        int res = Integer.MAX_VALUE;

        while (r < n) {

            while (r < n && sum < target) {
                sum += nums[r];
                r++;
            }

            while (l < n && sum >= target) {
                res = Math.min(res, (r - l + 1));
                sum -= nums[l];
                l++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

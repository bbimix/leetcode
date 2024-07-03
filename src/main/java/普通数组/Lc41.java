package 普通数组;

import java.util.HashMap;

/**
 * 缺失的第一个正整数
 * 思路 使用map
 * 这捏妈妈怎么想出来
 */

public class Lc41 {

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num >= 1 && num <= n) {
                nums[num - 1] = - Math.abs(nums[num - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return n + 1;
    }

}

package 技巧;

import java.util.Arrays;

/**
 * 多数元素
 */

public class Lc169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

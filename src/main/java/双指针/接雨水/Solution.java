package 双指针.接雨水;

/**
 * @projectName: leetcode
 * @package: 双指针.接雨水
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/20 21:09
 */

public class Solution {
    public long maxWater (int[] arr) {
        int len = arr.length;
        if (len < 3) {
            return 0;
        }

        int i = 0, j = len - 1;
        long water = 0;
        int maxleft = arr[i], maxright = arr[j];

        while (i < j) {
            if (arr[i] < arr[j]) {
                i++;
                if (arr[i] >= maxleft) {
                    maxleft = arr[i];
                    continue;
                }
                water = water + maxleft - arr[i];

            } else {
                j--;
                if (arr[j] >= maxright) {
                    maxright = arr[j];
                    continue;
                }
                water = water + maxright - arr[j];
            }
        }

        return water;
    }
}

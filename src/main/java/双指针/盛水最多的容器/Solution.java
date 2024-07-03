package 双指针.盛水最多的容器;

/**
 * @projectName: leetcode
 * @package: 双指针.盛水最多的容器
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/20 20:57
 */
public class Solution {
    public int maxArea2 (int[] height) {
        //可行但是超时
        int leng = height.length;
        if (leng < 2) {
            return 0;
        }
        int max = 0;

        for (int i = 0; i < leng - 1; i++) {
            for (int j = i + 1; j < leng; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    public int maxArea (int[] height) {
        //贪心算法
        int leng = height.length;
        if (leng < 2) {
            return 0;
        }
        int max = 0;

        int i = 0;
        int j = leng - 1;

        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }
}

package 双指针;

import java.util.Stack;


/**
 * 接雨水
 * 自己A出来的史山
 * 这是坠猴的
 */
public class Lc42 {

    public static int trap(int[] height) {

        int length = height.length;
        if (length <= 2)
            return 0;

        int res = 0;
        int count = 0;
        int l = 0;
        int r = l + 1;

        while (r < length) {
            if (height[l] <= height[r]) {
                res += count;
                count = 0;
                l = r;
                r++;
                continue;
            }
            if (height[l] > height[r] && r == length - 1) {
                count = 0;
                break;
            }
            if (height[l] > height[r]) {
                count += height[l] - height[r];
                r++;
            }
        }

        r = length - 1;
        l = r - 1;

        while (l >= 0) {
            if (height[l] > height[r]) {
                res += count;
                count = 0;
                r = l;
                l--;
                continue;
            }
            if (height[r] > height[l] && r == 0) {
                count = 0;
                break;
            }
            if (height[r] > height[l]) {
                count += height[r] - height[l];
                l--;
                continue;
            }
            l--;
        }

        return res;
    }

    public static int trapOfficial(int[] height) {

        int n = height.length;
        int maxl = 0, maxr = 0;
        int l = 0, r = n - 1;
        int res = 0;

        while (l < r) {

            while (height[l] <= height[r] && l < r) {
                maxl = Math.max(maxl, height[l]);
                res += maxl - height[l];
                l++;
            }
            while (height[l] > height[r] && l < r) {
                maxr = Math.max(maxr, height[r]);
                res += maxr - height[r];
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trapOfficial(height);
        System.out.println(res);
    }

}

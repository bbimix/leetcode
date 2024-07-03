package 双指针;

/**
 * 盛水最多的容器
 * 首先想到纯暴力解法
 */
public class Lc11 {
    /**
     * 纯暴力解法 超时
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int maxvalue = 0;

        int length = height.length;
        for (int left = 0; left < length - 1; left++) {
            for (int right = left + 1; right < length; right++) {

                int value = Math.min(height[left], height[right]) * (right - left);
                maxvalue = Math.max(maxvalue, value);

            }
        }
        return maxvalue;
    }

    public static int maxAreaOfficial(int[] height) {

        int maxvalue = 0;

        int length = height.length;
        int l = 0;
        int r = length - 1;

        while (l < r) {
            maxvalue = Math.max(maxvalue, (r - l) * Math.max(height[l], height[r]));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }


        return maxvalue;
    }

    public static void main(String[] args) {
        int[] h = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaOfficial(h));
    }
}

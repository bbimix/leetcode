package 二分查找;

/**
 * 寻找峰值
 */

public class Lc162 {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}

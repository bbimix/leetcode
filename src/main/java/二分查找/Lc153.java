package 二分查找;

/**
 * 寻找旋转排序数组中的最小值
 */

public class Lc153 {
    public static int findMin(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            if (n == 1)
                return nums[0];
            else
                return Math.min(nums[0], nums[1]);
        }

        int l = 0, r = n - 1;

        while (l <= r) {
            if (nums[l] < nums[r])
                return nums[l];
            int mid = (r - l) / 2 + l;

            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (r < n - 1 && nums[r + 1] < nums[r])
            return nums[r + 1];
        return nums[r];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {4,5,1,2,3}));
    }
}

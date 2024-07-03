package 二分查找;

public class Lc34 {

    public static int[] searchRange(int[] nums, int target) {

        int n = nums.length;

        if (n < 1) {
            return new int[] {-1, -1};
        }

        int i_1 = -1, i_2 = -1;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                i_1 = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                i_2 = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[] {i_1, i_2};
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] res = searchRange(nums, 8);
        System.out.println(res);
    }

}

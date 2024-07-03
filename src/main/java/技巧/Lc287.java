package 技巧;

/**
 * 重复的数
 */

public class Lc287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1;
        int res = -1;
        while (l < r) {
            int count = 0;
            int mid = (r + l) / 2;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            if (count <= mid) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
                res = mid;
            }
        }
        return res;
    }
}

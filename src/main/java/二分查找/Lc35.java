package 二分查找;

/**
 * 搜索插入位置
 */

public class Lc35 {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while (l <= r) {

            if (l == r) {
                if (target > nums[l])
                    return l + 1;
                else
                    return l;
            }

            int mid = (r - l) / 2 + l;

            if (target <= nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        Lc35 lc35 = new Lc35();
        int res = lc35.searchInsert(nums, 0);
        System.out.println(res);
    }

}

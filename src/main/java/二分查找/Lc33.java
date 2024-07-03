package 二分查找;

/**
 * 搜索旋转排序数组
 * 思路是两次二分
 * 第一次先确定k的位置
 * 第二次查找target
 *
 * 通过画图又发现
 * 第一次 可以比较mid的值与left，right的值
 * 如果mid 大于right 说明小于k
 * 如果mid小于left 说明大于k
 */

public class Lc33 {
    public static int search(int[] nums, int target) {
        int n = nums.length;

        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target)
                return mid;
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {3,1};
        int i = search(nums, 1);
        System.out.println(i);
    }

}

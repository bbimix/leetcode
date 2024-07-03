package 查找.二分查找;

/**
 * @projectName: leetcode
 * @package: 查找.二分查找
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/23 22:51
 */
public class Solution {
    public int search (int[] nums, int target) {
        // write code here
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left != right) {
            int mid = left + right / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                while (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                    mid--;
                }
                return mid;
            }
        }

        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}

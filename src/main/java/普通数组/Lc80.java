package 普通数组;

/**
 * 删除有序数组重复项II
 */

public class Lc80 {

    public int removeDuplicates(int[] nums) {

        int n = nums.length;

        if (n <= 2) {
            return n;
        }

        int count = 1;
        int left = 1;

        for (int i = 1; i < n; i++) {

            if (nums[i] == nums[i - 1]) {
                count++;
                if (count <= 2) {
                    nums[left++] = nums[i];
                }
            } else {
                count = 1;
                nums[left++] = nums[i];
            }
        }
        return left;
    }

}

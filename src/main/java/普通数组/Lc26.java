package 普通数组;

/**
 * 删除有序数组中的重复项
 */

public class Lc26 {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;

        if (n <= 1) {
            return n == 1 ? 1 : 0;
        }

        int l = 1, r = 1;

        while (r < n) {

            if (nums[r] != nums[r - 1]) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        Lc26 lc26 = new Lc26();
        int res = lc26.removeDuplicates(nums);
    }
}

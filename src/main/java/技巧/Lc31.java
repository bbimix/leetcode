package 技巧;

/**
 * 下一个排列
 */

public class Lc31 {

    public void nextPermutation(int[] nums) {

        int n = nums.length;
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            while (j >= i && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;

        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}

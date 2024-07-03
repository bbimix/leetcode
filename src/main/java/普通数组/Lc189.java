package 普通数组;

/**
 * 轮转数组
 */

public class Lc189 {

    public void rotate(int[] nums, int k) {

        int n = nums.length;

        if (k > n)
            k = k - n;

        int[] temp = new int[k];

        for (int i = n - 1; i > n - k - 1; i--) {
            temp[i - n + k] = nums[i];
        }

        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];

            if (i < k) {
                nums[i] = temp[i];
            }
        }
    }
}

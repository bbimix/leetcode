package 普通数组;

/**
 * 移除元素
 */

public class Lc27 {
    public int removeElement(int[] nums, int val) {

        int n = nums.length;
        if (n == 0)
            return 0;

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                res++;
            } else {
                nums[i] = -1;
            }
        }

        int right = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] != -1) {
                right = i;
                break;
            }
        }

        int left = 0;

        while (left != right) {
            if (nums[left] != -1)
                left++;
            else {
                swap(nums, left, right);
                left++;
                while (right > left && nums[right] == -1)
                    right--;
            }

        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int removeElementOfficial(int[] nums, int val) {

        int right = 0;
        int res = 0;
        for (int left = 0; left < nums.length; left++) {

            while (right < nums.length && nums[right] == val) {
                right++;
            }
            if (right == nums.length) {
                res = left;
                break;
            }

            nums[left] = nums[right];
            res = left + 1;
            right++;
        }
        return res;
    }
}

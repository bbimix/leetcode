package 双指针;

import java.util.Arrays;

/**
 * 移动零
 */

public class Lc283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int p1 = n - 1, p2 = n - 1;
        int tempindex = 0;
        while (p1 >= 0) {
            if (nums[p1] == 0) {
                swap(nums, p1, p2);
                p2--;
                tempindex = p2;

                while (p2 > p1) {
                    swap(nums, p1, p2);
                    p2--;
                }
                p2 = tempindex;
            }
            p1--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Lc283 lc283 = new Lc283();
        int[] nums = {0,0,0};
        lc283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

package 堆;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 数组中第k个最大元素
 */

public class Lc215 {

    public static int findKthLargest(int[] nums, int k) {

        int n = nums.length;
        int size = n;
        buildHeap(nums, n);
        for (int i = n - 1; i >= n - k + 1; i--) {
            swap(nums, 0, i);
            size--;
            fixHeap(nums, 0, size);
        }
        return nums[0];
    }

    private static void buildHeap(int[] nums, int n) {
        for (int i = n / 2; i >= 0; i--) {
            fixHeap(nums, i, n);
        }
    }

    private static void fixHeap(int[] nums, int parent, int n) {
        int l = parent * 2 + 1;
        int r = parent * 2 + 2;
        int large = parent;
        if (l < n && nums[l] > nums[large]) {
            large = l;
        }
        if (r < n && nums[r] > nums[large]) {
            large = r;
        }
        if (large != parent) {
            swap(nums, parent, large);
            fixHeap(nums, large, n);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int i = findKthLargest(nums, 3);
        System.out.println(i);
    }
}

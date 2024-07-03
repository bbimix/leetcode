package 排序.快速排序;

import java.util.Stack;

/**
 * @projectName: leetcode
 * @package: 排序.直接排序
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/31 21:09
 */
public class Solution {
    public static void quickSort(int[] arr, int low, int high) {
        if (arr.length == 0)
            return;
        if (low >= high) {
            return;
        }

        int left = low;
        int right = high;
        int temp = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        quickSort(arr, low, left - 1);
        quickSort(arr, left+1, high);

    }

    public static void main(String[] args) {
        int [] arr = {5, 6, 2, 74, 5, 45, 12, 34 , 67};
        partition(arr);
        for (int item: arr) {
            System.out.println(item);
        }
    }

    /**
     * 用栈实现
     */

    public static int quicksort2(int[] arr, int low, int high) {
        int left = low;
        int right = high;

        int temp = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= arr[left]) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= arr[right]) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;


    }

    public static void partition(int[] arr) {
        if (arr.length <= 0)
            return;
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        stack.push(arr.length - 1);

        while (!stack.isEmpty()) {
            int high = stack.pop();
            int low = stack.pop();

            int pivot = quicksort2(arr, low, high);

            if (pivot > low) {
                stack.push(low);
                stack.push(pivot - 1);
            }
            if (pivot < high && pivot >= 0) {
                stack.push(pivot + 1);
                stack.push(high);
            }
        }
    }
}

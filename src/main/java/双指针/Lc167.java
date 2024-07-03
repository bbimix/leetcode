package 双指针;

import java.util.ArrayList;
import java.util.List;

/**
 * 两数之和II
 *
 * 先用了回溯 疯狂超时
 *
 * 发现这个题在双指针下面
 */

public class Lc167 {

    public int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;
        int l = 0;
        int r = n - 1;
        int[] res = new int[2];

        while (l < r) {
            while (l < r && numbers[l] + numbers[r] > target) {
                r--;
            }

            while (l < r && numbers[l] + numbers[r] < target) {
                l++;
            }

            if (numbers[l] + numbers[r] == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            }


        }

        return res;

    }

}

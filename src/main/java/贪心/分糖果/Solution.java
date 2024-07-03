package 贪心.分糖果;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: 贪心.分糖果
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/21 12:20
 */
public class Solution {
    public int candy(int[] arr) {

        if (arr.length == 0) {
            return 0;
        } else if (arr.length == 1) {
            return 1;
        }

        int[] candy = new int[arr.length];
        candy[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else if (arr[i] == arr[i - 1]) {
                candy[i] = candy[i - 1];
            } else {
                if (arr[i - 1] == 1) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (arr[j] > arr[j + 1]) {
                            candy[j] += 1;
                        }
                        break;
                    }
                }
                candy[i] = 1;
            }
        }
        System.out.println(Arrays.stream(candy));
        return Arrays.stream(candy).sum();
    }
}

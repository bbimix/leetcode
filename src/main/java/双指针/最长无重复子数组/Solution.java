package 双指针.最长无重复子数组;

import java.util.HashMap;

/**
 * @projectName: leetcode
 * @package: 双指针.最长无重复子数组
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/20 18:15
 */
public class Solution {
    public int maxLength (int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap();
        int result = 0;

        for (int left = 0, right = 0; right < arr.length; right++) {
            if (mp.containsKey(arr[right])) {
                mp.put(arr[right], mp.get(arr[right]) + 1);
            } else {
                mp.put(arr[right], 1);
            }
            while (mp.get(arr[right]) > 1) {
                mp.put(arr[left], mp.get(arr[left]) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}

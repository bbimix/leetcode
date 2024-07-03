package 子串;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 经典的回溯
 */

public class Lc560 {

    public int subarraySum(int[] nums, int k) {

        int n = nums.length;
        int res = 0;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {

            pre += nums[i];
            if (map.containsKey(pre - k)) {
                res += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);

        }
        return res;
    }

}

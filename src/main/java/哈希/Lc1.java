package 哈希;

import java.util.HashMap;

public class Lc1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);

        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (map.get(target - nums[i]) != null) {
                int[] res = {i, map.get(target - nums[i])};
                return new int[] {map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + "-----" + res[1]);
    }
}

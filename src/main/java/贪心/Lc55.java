package 贪心;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 跳跃游戏
 * 思考 可以创建map 记录下标是否可以到达
 */

public class Lc55 {

    public static boolean canJump(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        return dfs(nums, 0, nums.length, set);

    }

    private static boolean dfs(int[] nums, int index, int length, HashSet<Integer> set) {
        if (index == length - 1)
            return true;

        if (set.contains(index)) {
            return false;
        }

        boolean or = false;

        for (int i = nums[index]; i >= 1; i--) {
            if (i + index >= length)
                continue;

            if (dfs(nums, index + i, length, set)) {
                or = true;
                break;
            }

        }

        if (or == false)
            set.add(index);
        return or;
    }

    public static boolean canJumpOfficial(int[] nums) {

        int max = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= length - 1)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,0};
        System.out.println(canJump(nums));
    }
}

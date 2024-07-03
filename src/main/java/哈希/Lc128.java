package 哈希;

import java.util.HashSet;

/**
 * 最长连续序列
 * 自己没A出来
 */

public class Lc128 {
    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int res = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cures = 1;
                int cur = num;

                while (set.contains(cur + 1)) {
                    cur++;
                    cures++;
                }

                res = Math.max(res, cures);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int res = longestConsecutive(nums);
        System.out.println(res);
    }
}

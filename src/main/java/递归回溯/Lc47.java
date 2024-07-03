package 递归回溯;

import java.util.*;

/**
 * 全排列 但是有重复元素
 */

public class Lc47 {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        Arrays.sort(nums);
        dfs(nums, used, res, layer);
        return res;
    }

    private static void dfs(int[] nums, Set<Integer> used, List<List<Integer>> res, List<Integer> layer) {

        if (layer.size() == nums.length) {
            res.add(new ArrayList<>(layer));
            return;
        }

        int prev = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (used.contains(i))
                continue;
            if (i > 0 && nums[i] == prev)
                continue;

            layer.add(nums[i]);
            used.add(i);
            prev = nums[i];
            dfs(nums, used, res, layer);
            layer.remove(layer.size() - 1);
            used.remove(i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = permuteUnique(nums);
        System.out.println(res);
    }

}

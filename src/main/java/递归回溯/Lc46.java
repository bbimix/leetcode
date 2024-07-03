package 递归回溯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排列组合
 * 套路和难度与全体子集类似
 * 都需要看答案才会
 */

public class Lc46 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();

        for (int num: nums) {
            layer.add(num);
        }
        dfs(0, nums.length, res, layer);
        return res;
    }

    private static void dfs(int index, int length, List<List<Integer>> res, List<Integer> layer) {
        if (index == length) {
            res.add(new ArrayList<>(layer));
            return;
        }

        for (int i = index; i < length; i++) {
            Collections.swap(layer, index, i);
            dfs(index + 1, length, res, layer);
            Collections.swap(layer, index, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
    }
}

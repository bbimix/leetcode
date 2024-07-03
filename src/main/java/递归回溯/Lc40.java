package 递归回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集II
 * 存在重复，不能重复选则，通过先排序，判断相邻是否相等来剪枝
 * 答案正确 力扣不通过
 */

public class Lc40 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();
        dfs(candidates, target, res, layer, 0, 0);
        return res;
    }

    private static void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> layer, int index, int sum) {

        if (sum == target) {
            res.add(new ArrayList<>(layer));
            return;
        }


        for (int i = index; i < candidates.length; i++) {

            if (candidates[i] > target)
                return;

            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            layer.add(candidates[i]);
            sum += candidates[i];
            dfs(candidates, target, res, layer, i + 1, sum);
            layer.remove(layer.size() - 1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        int target = 27;
        List<List<Integer>> res = combinationSum2(nums, target);
        System.out.println(res);
    }
}

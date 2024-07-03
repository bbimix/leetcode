package 递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 刚做完回文串做这个题
 * 感觉类似与可以重复选用字母的回文串
 * 可以把单个数字的重复写在循环里
 * 单个数字不满足要求递归到子数组
 */

public class Lc39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        trackBack(candidates, target, 0, 0, candidates.length, res, new ArrayList<>());
        return res;
    }

    private static void trackBack(int[] candidates, int target, int sum, int index, int size, List<List<Integer>> res, List<Integer> layer) {

        if (sum == target) {
            res.add(new ArrayList<>(layer));
            return;
        }

        while (sum < target && index < size) {
            sum += candidates[index];
            layer.add(candidates[index]);
            trackBack(candidates, target, sum, index, size, res, layer);
            sum = sum - layer.get(layer.size() - 1);
            layer.remove(layer.size() - 1);

            index++;
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println(res.toString());
    }
}

package 递归回溯;

import java.util.*;

/**
 * 可以有重复的子集
 * 思考：可以使用set来去重
 * 错误的地方：包含相同元素的子集可能顺序不同被判断为不同子集
 * 需要先对数组进行排序
 *
 * 或者：按照dong的方法，需要排序后
 * 不使用set，用比较相邻元素是否相同的办法剪枝
 */

public class Lc90 {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();
        dfs(nums, res, layer, 0);
        return res;

    }

    private static void dfs(int[] nums, List<List<Integer>> res, List<Integer> layer, int index) {

        res.add(new ArrayList<>(layer));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            layer.add(nums[i]);
            dfs(nums, res, layer, i + 1);
            layer.remove(layer.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> res = subsetsWithDup(nums);
        System.out.println(res);
    }

}

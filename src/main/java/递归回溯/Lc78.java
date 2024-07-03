package 递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出整数数组的全部子集
 * 不会 看答案
 */

public class Lc78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();
        res.add(new ArrayList<>(layer));

        for (int i = 0; i < nums.length; i++) {
            int nowSize = res.size();
            for (int j = 0; j < nowSize; j++) {
                layer = new ArrayList<>(res.get(j));
                layer.add(nums[i]);
                res.add(new ArrayList<>(layer));
            }
        }
        return res;
    }

    /**
     * 递归实现子集枚举通用写法
     */
    public static List<List<Integer>> subsetsdfs(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();
        dfs(nums, res, layer, 0);
        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, List<Integer> layer, int index) {

        if (index == nums.length) {
            res.add(new ArrayList<>(layer));
            return;
        }

        layer.add(nums[index]);
        dfs(nums, res, layer, index + 1);
        layer.remove(layer.size() - 1);
        dfs(nums, res, layer, index + 1);

    }

    /**
     * 上面是用球的视角实现的 对应着求可能在盒子里 也可能不在
     * 下面使用盒子的视角来实现一遍
     */

    public static List<List<Integer>> subsetsdfsBox(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();
        dfsbox(nums, res, layer, 0);
        return res;
    }

    private static void dfsbox(int[] nums, List<List<Integer>> res, List<Integer> layer, int index) {

        res.add(new ArrayList<>(layer));

        for (int i = index; i < nums.length; i++) {
            layer.add(nums[i]);
            dfsbox(nums, res, layer, i + 1);
            layer.remove(layer.size() - 1);
        }


    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsetsdfsBox(nums);
        System.out.println(res);
    }




}

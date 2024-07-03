package 双指针;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 三数之和
 * 有点类似子集 target
 */

public class Lc15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        dfs(nums, 0, length, 0, 0, layer, set, res);
        return res;
    }

    private static void dfs(int[] nums, int index, int length, int target, int left, List<Integer> layer, HashSet<List<Integer>> set, List<List<Integer>> res) {

        if (index == 3 && target == 0 && !set.contains(layer)) {
            res.add(new ArrayList<>(layer));
            set.add(new ArrayList<>(layer));
        }

        HashSet<Integer> setlayer = new HashSet<>();

        for (int i = left; i < length; i++) {

                if (!setlayer.contains(nums[i])) {
                    setlayer.add(nums[i]);
                    layer.add(nums[i]);
                    dfs(nums, index + 1, length, target - nums[i], i + 1, layer, set, res);
                    layer.remove(layer.size() - 1);
                }
        }
    }

    public static List<List<Integer>> threeSumOfficial(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i < length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int target = -nums[i];
            int j = i + 1;
            int k = length - 1;

            while (j < k) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }


                if (nums[j] + nums[k] > target)
                    k--;
                else if (nums[j] + nums[k] < target)
                    j++;
                else {
                    layer.add(nums[i]);
                    layer.add(nums[j]);
                    layer.add(nums[k]);
                    res.add(new ArrayList<>(layer));
                    layer.clear();
                    j++;
                }

            }

        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res;
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0,0,0,0};
        res = threeSumOfficial(nums);
        System.out.println(res);
    }
}

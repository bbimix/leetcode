package 递归回溯.没有重复项数字的全排列;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: 递归回溯.没有重复项数字的全排列
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/19 17:16
 */
public class Solution {
    private void swap(ArrayList<Integer> num, int i, int j) {
        int temp = num.get(i);
        num.set(i, num.get(j));
        num.set(j, temp);
    }

    private void recursion(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> num, int index) {
        if (index == num.size() - 1) {
            res.add(num);
        } else {
            for (int i = index; i < num.size(); i++) {
                swap(num, i, index);
                recursion(res, num, index + 1);
                swap(num, i, index);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> permute (int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) {
            nums.add(num[i]);
        }
        recursion(res, nums, 0);
        return res;
    }
}

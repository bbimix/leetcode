package 递归回溯.括号生成;

import java.util.ArrayList;

/**
 * @projectName: leetcode
 * @package: 递归回溯.括号生成
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/20 11:05
 */
public class Solution {
    private void recursion(int left, int right, String s, ArrayList<String> res) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left != 0) {
            recursion(left - 1, right, s + '(', res);
        }

        if (right != 0 && right > left) {
            recursion(left, right - 1, s + ')', res);
        }
    }


    public ArrayList<String> generateParenthesis (int n) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        recursion(n, n, "", res);
        return res;
    }
}

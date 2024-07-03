package 递归回溯.N皇后;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: 递归回溯.N皇后
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/20 10:14
 */
public class Solution {
    private int res;

    private boolean isValid(int[] pos, int col, int row) {
        for (int i = 0; i < row; i++) {
            if (pos[i] == col || Math.abs(row - i) == Math.abs(col - pos[i])) {
                return false;
            }
        }
        return true;
    }

    private void recursion(int[] pos, int n, int row) {
        if (row == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(pos, i, row)) {
                pos[row] = i;
                recursion(pos, n, row + 1);
            }
        }
    }


    public int Nqueen (int n) {
        res = 0;
        int[] pos = new int[n];
        recursion(pos, n, 0);
        return res;
    }
}

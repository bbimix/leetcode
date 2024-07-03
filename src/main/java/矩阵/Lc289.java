package 矩阵;

import java.util.*;

/**
 * 生命游戏
 *
 * 思路：纯暴力 开一个新的数组 遍历旧数组 往新数组里更新值
 */

public class Lc289 {

    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;


        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cell = board[i][j];
                int count = getCount(board, i, j, m, n);

                if (cell == 1 && count < 2) {
                    res[i][j] = 0;
                } else if (cell == 1 && count > 3) {
                    res[i][j] = 0;
                } else if (cell == 1 && count > 1 && count < 4) {
                    res[i][j] = 1;
                } else if (cell == 0 && count == 3) {
                    res[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = res[i][j];
            }
        }

    }

    private int getCount(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        if (j - 1 >= 0) {
            if (board[i][j - 1] == 1) {
                count++;
            }
            if (i - 1 >= 0){
                if (board[i - 1][j - 1] == 1) {
                    count++;
                }
            }
            if (i + 1 < m) {
                if (board[i + 1][j - 1] == 1) {
                    count++;
                }
            }
        }
        if (j + 1 < n) {
            if (board[i][j + 1] == 1) {
                count++;
            }
            if (i - 1 >= 0){
                if (board[i - 1][j + 1] == 1) {
                    count++;
                }
            }
            if (i + 1 < m) {
                if (board[i + 1][j + 1] == 1) {
                    count++;
                }
            }
        }
        if (i - 1 >= 0){
            if (board[i - 1][j] == 1) {
                count++;
            }
        }
        if (i + 1 < m) {
            if (board[i + 1][j] == 1) {
                count++;
            }
        }

        return count;
    }

}

package 矩阵;

import java.util.HashMap;

/**
 * 有效的数独
 */

public class Lc36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] cub = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int index = board[i][j] - '0' - 1;
                if (board[i][j] != '.') {
                    row[i][index]++;
                    col[j][index]++;
                    cub[i/3][j/3][index]++;
                    if (row[i][index] > 1 || col[j][index] > 1 || cub[i/3][j/3][index] > 1)
                        return false;
                }

            }
        }
        return true;
    }
}

package 递归回溯.岛屿数量;

/**
 * @projectName: leetcode
 * @package: 递归回溯.岛屿数量
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/20 9:19
 */
public class Solution {
    private void dfs(char[][] grid, int i, int j, int n, int m) {
        grid[i][j] = '0';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j, n, m);
        }
        if (i + 1 < n && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j, n, m);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1, n, m);
        }
        if (j + 1 < m && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1, n, m);
        }
    }

    public int solve (char[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }

        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, n, m);
                }
            }
        }
        return count;
    }
}

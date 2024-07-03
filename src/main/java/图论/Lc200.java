package 图论;


import java.util.ArrayList;
import java.util.List;

/**
 * 岛屿数量
 *
 * 自己写的 31/49
 *
 * 方法最后错在
 * 1 1 1
 * 1 0 1
 * 1 1 1
 * 这种
 *
 * 1. 深度优先 最好用
 * 2。广度优先
 * 3. 并查集
 */

public class Lc200 {

    public static int numIslands(char[][] grid) {
        List<List<int[]>> interval = new ArrayList<>();

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            int left = 0, right = 0;
            List<int[]> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {

                //遇到第一个1 记为左
                if (j > 0 && grid[i][j] == '1' && grid[i][j - 1] != '1' || j == 0 && grid[i][j] == '1')
                    left = j;

                //遇到1后面第一个0 记为右
                if (j > 0 && grid[i][j] == '0' && grid[i][j - 1] == '1' || j == n - 1 && grid[i][j] == '1') {
                    right = j;
                    if (right == n - 1 && grid[i][right] == '1')
                        row.add(new int[]{left, right });
                    else
                        row.add(new int[]{left, right - 1});
                }
            }
            interval.add(row);
        }

        int res = interval.get(0).size();

        for (int i = 1; i < m; i++) {

            int pres = interval.get(i - 1).size();
            int curs = interval.get(i).size();
            int coverN = 0;

            for (int j = 0; j < curs; j++) {

                int[] curInter = interval.get(i).get(j);
                for (int k = 0; k < pres; k++) {
                    int[] preInter = interval.get(i - 1).get(k);
                    if (curInter[0] >= preInter[0] && curInter[0] <= preInter[1] ||
                            curInter[1] >= preInter[0] && curInter[1] <= preInter[1]) {
                        coverN++;
                    }

                }

            }
            res = res - coverN + curs;
        }

        return res;

    }

    public static int numIslandsOfficial(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j, m, n);
                }

            }
        }
        return res;
    }

    private static void dfs(char[][] grid, int i, int j, int m, int n) {

        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i, j - 1, m, n);
    }


    public static void main(String[] args) {
//        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};//
                char[][] grid = {{'1'}, {'1'}};

        int res = numIslandsOfficial(grid);

        System.out.println(res);

    }

}

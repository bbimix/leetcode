package 图论;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 *
 * 感觉也是深度遍历
 *
 * 思路 如果遇到2 深度遍历把能到的橘子变成2 遇到1 把位置存入set
 * 最后遍历set位置 查看是否有新鲜橘子
 *
 * 做题更新
 * 只能是广度
 *
 * A出来了
 */

public class Lc994 {

    static int res = 0;

    public static int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;


        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> temp = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    queue.offer(new int[] {i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (makeRot(grid, cur[0] + 1, cur[1], m, n)) temp.offer(new int[] {cur[0] + 1, cur[1]});
            if (makeRot(grid, cur[0] - 1, cur[1], m, n)) temp.offer(new int[] {cur[0] - 1, cur[1]});
            if (makeRot(grid, cur[0], cur[1] + 1, m, n)) temp.offer(new int[] {cur[0], cur[1] + 1});
            if (makeRot(grid, cur[0], cur[1] - 1, m, n)) temp.offer(new int[] {cur[0], cur[1] - 1});

            if (queue.isEmpty()) {
                res++;
                while (!temp.isEmpty()) {
                    queue.offer(temp.poll());
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return res == 0 ? res : res - 1;
    }

    private static boolean makeRot(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1)
            return false;

        grid[i][j] = 2;
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 1}, {0, 1, 2}};
//        int[][] grid = {{0}};
        int res = orangesRotting(grid);
        System.out.println(res);
    }


}

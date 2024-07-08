package 图论;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 蛇形棋
 */

public class Lc909 {
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.offer(new int[] {1, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = cur[0] + i;
                if (next > n * n) {
                    break;
                }
                int [] xy = next2xy(next, n);
                if (board[xy[0]][xy[1]] > 0) {
                    next = board[xy[0]][xy[1]];
                }
                if (next == n * n)
                    return cur[1] + 1;
                if (visited[next] == false) {
                    queue.offer(new int[] {next, cur[1] + 1});
                    visited[next] = true;
                }
            }
        }
        return -1;
    }

    private static int[] next2xy(int next, int n) {
        int count = (next - 1) / n;
        int x = 0, y = n - count - 1;
        if (count % 2 == 0) {
            x = next - (count * n) - 1;
        } else {
            x = n - (next - (count * n));
        }
        return new int[] {y, x};
    }

    public static void main(String[] args) {
        int[][] board = {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1},
        };
        int res = snakesAndLadders(board);
        System.out.println(res);
    }
}

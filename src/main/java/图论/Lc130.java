package 图论;

/**
 * 被围绕的区域
 *
 * 一个o组成的区域如果不靠边
 * 用x填充给
 * 如果靠边 不动
 *
 * 从四个边缘出发 广度优先 把o置I 之后把不是I的全部变x
 * 之后再把i变o
 */

public class Lc130 {

    int m;
    int n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        if (m <= 2 || n <= 2)
            return;

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'I')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return;
        if (board[i][j] == 'O') {
            board[i][j] = 'I';
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
    }

}

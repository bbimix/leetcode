package 递归回溯;

import java.util.*;

/**
 * 在一个二位字符数组里面找word
 *
 */

public class Lc79 {
    public static boolean exist(char[][] board, String word) {

        char[] wordChar = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == wordChar[0]) {
                    if (wordChar.length == 1)
                        return true;
                    visited[i][j] = true;
                    if (exist(board, Arrays.copyOfRange(wordChar, 1, wordChar.length), i, j, visited))
                        return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, char[] wordChar, int i, int j, boolean[][] visited) {

        int m = board.length;
        int n = board[0].length;

        boolean left = false, right = false, up = false, down = false;

        if (i + 1 < m && board[i + 1][j] == wordChar[0]) {
            List<Integer> visit = new ArrayList<>();
            visit.add(i + 1);
            visit.add(j);
            if (wordChar.length == 1 && !visited[i + 1][j])
                return true;

            if (!visited[i + 1][j]) {
                visited[i + 1][j] = true;
                right = exist(board, Arrays.copyOfRange(wordChar, 1, wordChar.length), i + 1, j, visited);
                visited[i + 1][j] = false;
            }
        }
        if (i - 1 >= 0 && board[i - 1][j] == wordChar[0]) {
            List<Integer> visit = new ArrayList<>();
            visit.add(i - 1);
            visit.add(j);
            if (wordChar.length == 1 && !visited[i - 1][j])
                return true;


            if (!visited[i - 1][j]) {
                visited[i - 1][j] = true;
                left =  exist(board, Arrays.copyOfRange(wordChar, 1, wordChar.length), i - 1, j, visited);
                visited[i - 1][j] = false;
            }

        }
        if (j + 1 < n && board[i][j + 1] == wordChar[0]) {
            List<Integer> visit = new ArrayList<>();
            visit.add(i);
            visit.add(j + 1);
            if (wordChar.length == 1 && !visited[i][j + 1])
                return true;

            if (!visited[i][j + 1]) {
                visited[i][j + 1] = true;
                up =  exist(board, Arrays.copyOfRange(wordChar, 1, wordChar.length), i, j + 1, visited);
                visited[i][j + 1] = false;
            }

        }
        if (j - 1 >= 0 && board[i][j - 1] == wordChar[0]) {
            List<Integer> visit = new ArrayList<>();
            visit.add(i);
            visit.add(j - 1);
            if (wordChar.length == 1 && !visited[i][j - 1])
                return true;

            if (!visited[i][j - 1]) {
                visited[i][j - 1] = true;
                down = exist(board, Arrays.copyOfRange(wordChar, 1, wordChar.length), i, j - 1, visited);
                visited[i][j - 1] = false;
            }
        }
        return left || right || up || down;
    }

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCB";
        char[][] board = {{'C','A','A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
        System.out.println(exist(board, word));
    }
}

package 递归回溯;

import com.sun.org.apache.xerces.internal.xinclude.XPointerSchema;

import java.util.*;

public class Lc51 {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> col = new HashSet<>();
        Set<Integer> dig1 = new HashSet<>();
        Set<Integer> dig2 = new HashSet<>();
        dfs(res, queens, n, 0, col, dig1, dig2);
        return res;
    }

    private static void dfs(List<List<String>> res, int[] queens, int n, int index,
                            Set<Integer> col, Set<Integer> dig1, Set<Integer> dig2) {

        if (index == n) {
            List<String> layer = getBoard(queens, n);
            res.add(layer);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col.contains(i))
                continue;

            int digg1 = index - i;
            if (dig1.contains(digg1))
                continue;

            int digg2 = index + i;
            if (dig2.contains(digg2))
                continue;

            queens[index] = i;
            col.add(i);
            dig1.add(digg1);
            dig2.add(digg2);
            dfs(res, queens, n, index + 1, col, dig1, dig2);
            col.remove(i);
            dig1.remove(digg1);
            dig2.remove(digg2);
        }
    }

    private static List<String> getBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(3);
        System.out.println(res.size());

    }
}

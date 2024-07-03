package 递归回溯;

import java.util.HashSet;
import java.util.Set;

/**
 * N皇后问题，
 * 不需要具体解法，
 * 只需要数量
 */

public class Lc52 {

    static int res = 0;

    public static int totalNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> dig1 = new HashSet<>();
        Set<Integer> dig2 = new HashSet<>();

        res += dsf(n, 0, col, dig1, dig2);
        return res;
    }

    private static int dsf(int n, int index, Set<Integer> col, Set<Integer> dig1, Set<Integer> dig2) {

        if (index == n) {
            res++;
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

            col.add(i);
            dig1.add(digg1);
            dig2.add(digg2);
            dsf(n, index + 1, col, dig1, dig2);
            col.remove(i);
            dig1.remove(digg1);
            dig2.remove(digg2);
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 1;
        int ress = totalNQueens(n);
        System.out.println(ress);
    }
}

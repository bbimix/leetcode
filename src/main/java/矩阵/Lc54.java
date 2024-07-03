package 矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */

public class Lc54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        if (matrix == null || m == 0 || n == 0)
            return res;

        int l = 0, r = n - 1;
        int u = 0, d = m - 1;

        while (true) {

            for (int i = l; i < r; i++)
                res.add(matrix[u][i]);
            if (++u > d) break;

            for (int i = u; i < d; i++)
                res.add(matrix[i][r]);
            if (--r < l) break;

            for (int i = r; i >= l; i--)
                res.add(matrix[d][i]);
            if (--d < u) break;

            for (int i = d; i >= u; i--)
                res.add(matrix[i][l]);
            if (++l > r) break;
        }

        return res;
    }

}

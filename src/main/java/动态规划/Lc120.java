package 动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * 三角形最小路径和
 */

public class Lc120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n < 2)
            return n == 1 ? triangle.get(0).get(0) : 0;

        int res = Integer.MAX_VALUE;
        int min;
        for (int i = 1; i < n; i++) {
            List<Integer> layer = triangle.get(i);
            int l = layer.size();
            for (int j = 0; j < l; j++) {
                if (j > 0 && j < l - 1) {
                    min = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                } else if (j == 0) {
                    min = triangle.get(i - 1).get(0);
                } else {
                    min = triangle.get(i - 1).get(j - 1);
                }
                layer.set(j, min + layer.get(j));
                if (i == n - 1) {
                    res = Math.min(res, layer.get(j));
                }
            }
        }
        return res;
    }

}

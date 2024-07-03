package 动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单题
 * 杨辉三角
 */

public class Lc118 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> layer = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    layer.add(1);
                    continue;
                }


                int left = res.get(i - 1).get(j - 1);
                int right = res.get(i - 1).get(j);
                layer.add(left + right);
            }
            res.add(layer);
        }
        return res;
    }
}

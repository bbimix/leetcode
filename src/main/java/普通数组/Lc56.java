package 普通数组;

import sun.nio.cs.ext.MacHebrew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 */


public class Lc56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        if (n == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (res.get(res.size() - 1)[1] >= l) {
                res.get(res.size() - 1)[1] = Math.max(r, res.get(res.size() - 1)[1]);
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }


}

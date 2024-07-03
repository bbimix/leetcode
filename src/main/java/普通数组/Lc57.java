package 普通数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入区间
 */

public class Lc57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int left = newInterval[0];
        int right = newInterval[1];
        boolean over = false;
        List<int[]> reslist = new ArrayList<>();

        for (int[] interval : intervals) {

            if (interval[0] > right) {
                if (!over) {
                    reslist.add(new int[] {left, right});
                    over = true;
                }
                reslist.add(interval);
            } else if (interval[1] < left) {
                reslist.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }

        }

        if (!over) {
            reslist.add(new int[] {left, right});
        }

        int[][] res = new int[reslist.size()][2];

        int index = 0;
        for (int[] val : reslist) {
            res[index++] = val;
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] interval = {{1, 5}};
        Lc57 lc57 = new Lc57();
        int[][] res = lc57.insert(interval, new int[] {6,8});
        for (int i =0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}

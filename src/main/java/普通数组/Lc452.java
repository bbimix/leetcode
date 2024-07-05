package 普通数组;

import 贪心.Lc45;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 用最少数量的箭引爆气球
 *
 * 思路 合并区间 返回合并后的不相连区间数量
 */

public class Lc452 {

    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        int res = 1;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int pre = points[0][1];
        for (int i = 1; i < n; i++) {
            if (pre < points[i][0]) {
                pre = points[i][1];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] point = {{-2147483646,-2147483645},{2147483646,2147483647}};
        Lc452 lc452 = new Lc452();
        int res = lc452.findMinArrowShots(point);
        System.out.println(res);
    }

}

package 贪心.主持人调度;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @projectName: leetcode
 * @package: 贪心.主持人调度
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/21 20:22
 */
public class Solution {
    public int minmumNumberOfHost (int n, int[][] startEnd) {
        int[] start = new int[n];
        int[] end = new int[n];
        //分别得到活动起始时间
        for(int i = 0; i < n; i++){
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }
        //单独排序
        Arrays.sort(start, 0, start.length);
        Arrays.sort(end, 0, end.length);
        int res = 0;
        int j = 0;
        for(int i = 0; i < n; i++){
            //新开始的节目大于上一轮结束的时间，主持人不变
            if(start[i] >= end[j]) {
                j++;
            } else
                //主持人增加
            {
                res++;
            }
        }
        return res;
    }
}

package 堆栈队列.滑动窗口最大值;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @projectName: leetcode
 * @package: 堆栈队列.滑动窗口最大值
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2024/1/1 17:05
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int len = nums.length;

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            q.offer(new int[] {nums[i], i});
        }

        int[] ans = new int[len - k + 1];

        ans[0] = q.peek()[0];

        for (int i = k; i < len; i++) {
            q.offer(new int[] {nums[i], i});
            while (q.peek()[1] <= i - k) {
                q.poll();
            }

            ans[i - k + 1] = q.peek()[0];

        }

        return ans;
    }
}

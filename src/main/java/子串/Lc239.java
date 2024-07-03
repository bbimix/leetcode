package 子串;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 滑动最大窗口
 */

public class Lc239 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> queue = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i < k; i++) {

            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        res[0] = nums[queue.peekFirst()];

        for (int i = k; i < n; i++) {
            if (queue.peekFirst() <= i - k)
                queue.pollFirst();
            if (queue.isEmpty() || nums[i] < nums[queue.peekLast()]) {
                queue.offer(i);
            } else {
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }
                queue.offer(i);
            }
            res[i - k + 1] = nums[queue.peek()];
        }
        return res;
    }

}

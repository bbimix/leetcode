package 堆栈队列.最小的k个数;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @projectName: leetcode
 * @package: 堆栈队列.最小的k个数
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2024/1/1 17:59
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        int len = input.length;

        for (int i = 0; i < len; i++) {
            q.offer(input[i]);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            ans.add(q.peek());
            q.poll();
        }

        return ans;
    }
}

package 堆;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 前k个高频元素
 */

public class Lc347 {
    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] res = new int[k];
        for (int i = 0; i < n; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);
        }



        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] cur = new int[2];
            cur[0] = entry.getKey();
            cur[1] = entry.getValue();
            if (heap.size() == k) {
                if (heap.peek()[1] < cur[1]) {
                    heap.poll();
                    heap.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            } else {
                heap.offer(new int[]{entry.getKey(), entry.getValue()});
            }


        }
        for (int i = 0; i < k; i++) {
            int[] curr = heap.poll();
            res[i] = curr[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] res = topKFrequent(nums, 2);
        for (int i : res) {
            System.out.println(i);
        }
    }
}

package 堆;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 查找和最小的k对数字
 */

public class Lc373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);
            }
        });
        int n1 = nums1.length, n2 = nums2.length;
        for (int i = 0; i < Math.min(n1, k); i++) {
            heap.offer(new int[] {i, 0});
        }

        List<List<Integer>> res = new ArrayList<>();
        while (k-- > 0 && !heap.isEmpty()) {
            int[] cur = heap.poll();
            List<Integer> layer = new ArrayList<>();
            layer.add(nums1[cur[0]]);
            layer.add(nums2[cur[1]]);
            res.add(layer);
            if (cur[1] + 1 < n2) {
                heap.offer(new int[] {cur[0], cur[1] + 1});
            }
        }
        return res;
    }
}

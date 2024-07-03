package 堆.Lc295;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中位数
 * 思路 二叉平衡树能做到
 *
 */


public class MedianFinder {

    PriorityQueue<Integer> minq = new PriorityQueue<>();
    PriorityQueue<Integer> maxq = new PriorityQueue<>();

    public MedianFinder() {
        minq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        maxq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    public void addNum(int num) {
        if (minq.isEmpty() || num < minq.peek()) {
            minq.offer(num);
            if (minq.size() - maxq.size() > 1) {
                maxq.offer(minq.poll());
            }
        } else {
            maxq.offer(num);
            if (maxq.size() > minq.size()) {
                minq.offer(maxq.poll());
            }
        }
    }

    public double findMedian() {
        if (minq.size() == maxq.size()) {
            return (minq.peek() + maxq.peek()) / 2.0;
        } else {
            return minq.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double res = medianFinder.findMedian();
        System.out.println(res);
        medianFinder.addNum(3);
        res = medianFinder.findMedian();
        System.out.println(res);
    }

}

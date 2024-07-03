package 面试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {



    public static ArrayList<Integer> sort(int[] a) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : a) {
            queue.offer(i);
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            res.add(queue.poll());
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 1, 9, 7};
        ArrayList res = sort(a);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

    }
}

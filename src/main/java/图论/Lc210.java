package 图论;

import java.util.*;

/**
 * 课程表II
 */

public class Lc210 {

    List<List<Integer>> edges;
    int[] indeg;
    int[] res;
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        indeg = new int[numCourses];
        res = new int[numCourses];
        index = 0;

        int n = prerequisites.length;
        for (int i = 0; i < n; i++) {
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            indeg[to]++;
            edges.get(from).add(to);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[index++] = cur;
            for (int to : edges.get(cur)) {
                indeg[to]--;
                if (indeg[to] == 0) {
                    queue.offer(to);
                }
            }
        }


        /**
         * 如果不加这个判断 通不过的实例为 [0,1] [1,0]
         * 这里的问题是循环依赖导致队列一开始就是空
         * 所以index为numCourses
         */
        if (index != numCourses) {
            return new int[0];
        }

        return res;
    }

    public static void main(String[] args) {
        int num = 4;
        int[][] pre = {
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };
        Lc210 lc210 = new Lc210();
        int[] res = lc210.findOrder(num, pre);
        System.out.println(Arrays.toString(res));
    }
}

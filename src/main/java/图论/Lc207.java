package 图论;

import java.util.*;

/**
 * 课程表
 *
 * 看出题意是判断图是不是有环
 *
 * 几乎是看着答案写的 捞了
 */

public class Lc207 {

    List<List<Integer>> edge;
    int[] visited;

    boolean vaild;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        vaild = true;
        edge = new ArrayList<>();
        int n = prerequisites.length;
        visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            edge.get(info[1]).add(info[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }


        return vaild;
    }

    private void dfs(int i) {

        visited[i] = 1;
        for (int item : edge.get(i)) {

            if (visited[item] == 0) {
                dfs(item);
                if (!vaild)
                    return;
            } else if (visited[item] == 1) {
                vaild = false;
                return;
            }
        }
        visited[i] = 2;
    }

    public boolean canFinishBfs(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        int[] in = new int[numCourses];
        edge = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            edge.get(info[1]).add(info[0]);
            in[info[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0)
                q.offer(i);
        }

        int visited = 0;

        while (!q.isEmpty()) {
            visited++;
            int cur = q.poll();
            for (int v : edge.get(cur)) {
                in[v]--;
                if (in[v] == 0)
                    q.offer(v);
            }
        }
        return visited == numCourses;
    }

    public static void main(String[] args) {
        Lc207 lc207 = new Lc207();

    }
}

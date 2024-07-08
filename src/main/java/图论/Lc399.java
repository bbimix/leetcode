package 图论;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 除法数值
 *
 * 需要使用有向图
 */

public class Lc399 {

    class UnionFind {
        private int[] parent;

        private double[] weight;

        public UnionFind(int n) {
            parent = new int[n];
            weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(origin);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY)
                return;

            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int esize = equations.size();

        UnionFind unionFind = new UnionFind(2 * esize);

        Map<String, Integer> map = new HashMap<>();

        int id = 0;
        for (int i = 0; i < esize; i++) {
            List<String> layer = equations.get(i);
            String var1 = layer.get(0);
            String var2 = layer.get(1);

            if (!map.containsKey(var1)) {
                map.put(var1, id++);
            }
            if (!map.containsKey(var2)) {
                map.put(var2, id++);
            }
            unionFind.union(map.get(var1), map.get(var2), values[i]);
        }

        int qsize = queries.size();
        double[] res = new double[qsize];
        for (int i = 0; i < qsize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = map.get(var1);
            Integer id2 = map.get(var2);

            if (id1 == null || id2 == null)
                res[i] = -1.0d;
            else
                res[i] = unionFind.isConnected(id1, id2);
        }
        return res;
    }

}

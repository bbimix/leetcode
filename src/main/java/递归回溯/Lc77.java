package 递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 */

public class Lc77 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> layer = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k);
        return res;
    }

    private void dfs(int n, int k) {

        if (k == 0) {
            res.add(new ArrayList<>(layer));
            return;
        }

        for (int i = n; i >= k; i--) {

            layer.add(i);
            dfs(i - 1, k - 1);
            layer.remove(layer.size() - 1);

        }

    }

    public static void main(String[] args) {
        Lc77 lc77 = new Lc77();
        int n = 4, k = 2;
        List<List<Integer>> ress = lc77.combine(n, k);
        System.out.println(ress);
    }

}

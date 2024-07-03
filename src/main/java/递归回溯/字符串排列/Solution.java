package 递归回溯.字符串排列;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: 递归回溯.字符串排列
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/20 9:55
 */
public class Solution {

    private void recursion(ArrayList<String> res, char[] c, StringBuilder s, boolean[] vis) {
        if (s.length() == c.length) {
            res.add(s.toString());
            return;
        }
        for (int i = 0; i < c.length; i++) {
            if (vis[i]) {
                continue;
            }
            if (i > 0 && c[i - 1] == c[i] && !vis[i - 1]) {
                continue;
            }
            vis[i] = true;
            s.append(c[i]);
            recursion(res, c, s, vis);
            vis[i] = false;
            s.deleteCharAt(s.length() - 1);
        }
    }



    public ArrayList<String> Permutation (String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str.length() == 0 || str == null) {
            return res;
        }
        char[] c = str.toCharArray();
        boolean[] vis = new boolean[str.length()];
        Arrays.fill(vis, false);
        StringBuilder s = new StringBuilder();
        recursion(res, c, s, vis);

        return res;
    }
}

package 二叉树;

import java.util.HashMap;

/**
 * 路径和数量
 * 需要弄清楚前缀和的概念
 */

public class Lc437 {



    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefix = new HashMap<>();
        Long curr = 0L;
        prefix.put(curr, 1);
        return dfs(root, targetSum, curr, prefix);
    }

    private int dfs(TreeNode root, int targetSum, Long curr, HashMap<Long, Integer> prefix) {

        if (root == null)
            return 0;

        int res = 0;

        curr += root.val;

        res += prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        res += dfs(root.left, targetSum, curr, prefix);
        res += dfs(root.right, targetSum, curr, prefix);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return res;
    }

}

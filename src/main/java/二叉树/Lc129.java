package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 求根节点到叶节点数字之和
 */

public class Lc129 {

    Integer res;

    public int sumNumbers(TreeNode root) {
        res = 0;
        if (root == null)
            return 0;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int num) {

        num = num * 10 + root.val;

        if (check(root)) {
            res += num;
        }

        else {
            if (root.left != null)
                dfs(root.left, num);
            if (root.right != null)
                dfs(root.right, num);
        }

    }

    private boolean check(TreeNode root) {
        return root.left == null && root.right == null;
    }

}

package 二叉树;

/**
 * 二叉树最大路径和
 */

public class Lc124 {

    int res;

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        deep(root);
        return res;
    }

    private int deep(TreeNode root) {

        if (root == null)
            return 0;

        int deepl = deep(root.left);
        int deepr = deep(root.right);

        int curMax = Math.max(Math.max(deepl + root.val, deepr + root.val), root.val);

        res = Math.max(Math.max(curMax, deepl + deepr + root.val), res);
        return curMax;
    }

}

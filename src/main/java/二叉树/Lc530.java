package 二叉树;

/**
 * 二叉搜索树的最小绝对差
 *
 * 思路 每个节点向上一级返回左子树最大值 和 右子树最小值
 * 上一级节点减去这两个值比较就行
 *
 */

public class Lc530 {

    int pre;
    int res;

    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        res = Integer.MAX_VALUE;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            res = Math.min(res, Math.abs(pre - root.val));
            pre = root.val;
        }
        dfs(root.right);
    }

}

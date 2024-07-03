package 二叉树;

/**
 * 判断是否是二叉搜索树
 * 需要最大最小值来约束左右子树
 * 不能值判断当前节点与左右节点关系
 */

public class Lc98 {

    public boolean isValidBST(TreeNode root) {
        return isVaildBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isVaildBst(TreeNode root, long min, long max) {
        if (root == null)
            return true;

        if (root.val <= min || root.val >= max)
            return false;

        return isVaildBst(root.left, min, root.val) && isVaildBst(root.right, root.val, max);
    }

}

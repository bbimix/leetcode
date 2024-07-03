package 二叉树;

/**
 * 反转二叉树
 *
 * 类似检查是否对称
 *
 * 后续发现这个树不一定是对称的
 * 所以不太行
 */

public class Lc226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

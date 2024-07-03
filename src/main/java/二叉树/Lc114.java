package 二叉树;

public class Lc114 {

    public void flatten(TreeNode root) {
        if (root == null)
            return;

        TreeNode nodeLeft = root.left;
        TreeNode nodeRight = root.right;

        if (nodeLeft == null && nodeRight == null)
            return;

        if (nodeLeft != null)
            flatten(nodeLeft);
        if (nodeRight != null)
            flatten(nodeRight);

        if (nodeLeft == null) {
            return;
        } else if (nodeRight == null) {
            root.right = root.left;
            root.left = null;
        } else {
            TreeNode temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
        }

    }

}

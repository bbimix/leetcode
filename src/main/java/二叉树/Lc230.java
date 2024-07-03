package 二叉树;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc230 {
    public int kthSmallest(TreeNode root, int k) {

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();

        while (root != null || !queue.isEmpty()) {

            while (root != null) {
                queue.push(root);
                root = root.left;
            }

            root = queue.pop();
            k--;

            if (k == 0) {
                break;
            }

            root = root.right;

        }

        return root.val;
    }
}

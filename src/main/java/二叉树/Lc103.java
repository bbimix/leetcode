package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的锯齿形层序遍历
 *
 * 需要一个栈
 */

public class Lc103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        int sign = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            List<Integer> layer = new ArrayList<>();
            List<TreeNode> box = new ArrayList<>();

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                layer.add(node.val);
                box.add(node);
            }

            for (TreeNode cargo : box) {
                if (sign % 2 == 0) {
                    if (cargo.left != null)
                        stack.push(cargo.left);
                    if (cargo.right != null)
                        stack.push(cargo.right);
                } else {
                    if (cargo.right != null)
                        stack.push(cargo.right);
                    if (cargo.left != null)
                        stack.push(cargo.left);
                }
            }
            res.add(layer);
            sign++;
        }
        return res;
    }
}

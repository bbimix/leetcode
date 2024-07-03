package 二叉树;

import java.util.*;

/**
 * 二叉树的层序遍历
 */
public class Lc102 {

    /**
     * 队列方法
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> temp = new ArrayDeque<>();

        if (root == null)
            return res;

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            while (!queue.isEmpty()) {

                TreeNode curNode = queue.poll();
                layer.add(curNode.val);
                if (curNode.left != null) {
                    temp.offer(curNode.left);
                }
                if (curNode.right != null) {
                    temp.offer(curNode.right);
                }
            }
            while (!temp.isEmpty()) {
                queue.offer(temp.poll());
            }
            res.add(layer);
        }

        return res;
    }

    /**
     * 递归方法
     */
    public List<List<Integer>> levelOrderCircle(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int index) {
        if (root == null)
            return;

        if (index == res.size())
            res.add(new ArrayList<>());

        res.get(index).add(root.val);
        dfs(root.left, res, index + 1);
        dfs(root.right, res, index + 1);
    }

}

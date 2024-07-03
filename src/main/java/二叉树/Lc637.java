package 二叉树;

/**
 * 二叉树的层平均值
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc637 {
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val * 1.0;
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            res.add(sum / size);
        }
        return res;
    }
}

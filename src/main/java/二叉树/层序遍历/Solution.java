package 二叉树.层序遍历;

import 二叉树.TreeNode;

import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        queue.offer(root);


        while (!queue.isEmpty()) {

            ArrayList<Integer> level = new ArrayList<>();
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            res.add(level);
        }
        return res;
    }
}

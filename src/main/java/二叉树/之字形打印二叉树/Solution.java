package 二叉树.之字形打印二叉树;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        if (pRoot == null)
            return null;
        stack1.push(pRoot);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();

            if (!stack1.isEmpty()){
                while (!stack1.isEmpty()) {
                    TreeNode temp = stack1.pop();
                    level.add(temp.val);
                    if (temp.left != null)
                        stack2.push(temp.left);
                    if (temp.right != null)
                        stack2.push(temp.right);

                }
                res.add(level);
                continue;
            }

            while (!stack2.isEmpty()) {
                TreeNode temp = stack2.pop();
                level.add(temp.val);
                if (temp.right != null)
                    stack1.push(temp.right);
                if (temp.left != null)
                    stack1.push(temp.left);
            }

            res.add(level);
        }

        return res;
    }
}

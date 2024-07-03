package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 对称二叉树
 *
 * 思路： 使用双指针 照镜子一样的来遍历
 */

public class Lc101 {



    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        getleft(root.left, left);
        getright(root.right, right);

        if (left.size() != right.size())
            return false;

        for (int i = 0; i < left.size(); i++) {
            if (left.get(i) != right.get(i))
                return false;
        }
        return true;
    }

    private void getleft(TreeNode root, List<Integer> left) {
        if (root == null) {
            left.add(null);
            return;
        }

        left.add(root.val);

        getleft(root.left, left);
        getleft(root.right, left);
    }
   private void getright(TreeNode root, List<Integer> right) {
        if (root == null) {
            right.add(null);
            return;
        }

       right.add(root.val);

       getright(root.right, right);
       getright(root.left, right);
    }

}

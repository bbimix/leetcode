package 二叉树;

import java.util.ArrayList;
import java.util.List;


/**
 * 二叉树的右视图
 */
public class Lc199 {

    List<Integer> res = new ArrayList<>();


    public List<Integer> rightSideView(TreeNode root) {
        Integer depth = 0;
        rightSideView(root, res, depth);
        return res;
    }

    private void rightSideView(TreeNode root, List<Integer> res, Integer depth) {
        if (root == null)
            return;

        depth++;

        if (depth > res.size())
            res.add(root.val);

        if (root.right != null)
            rightSideView(root.right, res, depth);
        else if(root.left != null)
            rightSideView(root.left, res, depth);


        if (root.left != null)
            rightSideView(root.left, res, depth);

        depth--;
    }
}

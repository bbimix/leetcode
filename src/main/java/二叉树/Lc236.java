package 二叉树;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Lc236 {

    HashMap<Integer, TreeNode> parentMap = new HashMap<>();
    Set<Integer> visitedSet = new HashSet<>();

    public void dsf(TreeNode root) {
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            dsf(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            dsf(root.right);
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dsf(root);

        while (p != null) {
            visitedSet.add(p.val);
            p = parentMap.get(p.val);
        }
        while (q != null) {
            if (visitedSet.contains(q.val)) {
                return q;
            }
            q = parentMap.get(q.val);
        }

        return null;
    }
}

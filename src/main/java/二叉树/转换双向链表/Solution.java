package 二叉树.转换双向链表;

import 二叉树.TreeNode;

/**
 * 中序遍历
 */
public class Solution {
    TreeNode head = null;
    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null)
            return null;

        Convert(pRootOfTree.left);

        if (pre == null) {
            head = pRootOfTree;
            pre = pRootOfTree;
        }

        else {
            pRootOfTree.left = pre;
            pre.right = pRootOfTree;
            pre = pRootOfTree;
        }

        Convert(pRootOfTree.right);
        return head;
    }
}

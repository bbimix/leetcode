package 二叉树;

import java.util.Arrays;

/**
 * 中序后序生成二叉树
 */

public class Lc106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if (n == 1) {
            return new TreeNode(postorder[0]);
        }

        TreeNode root = new TreeNode(postorder[n - 1]);
        int rooti = 0;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == postorder[n - 1]) {
                rooti = i;
                break;
            }
        }

        int[] newInR = Arrays.copyOfRange(inorder, rooti + 1, n);
        int[] newInL = Arrays.copyOfRange(inorder, 0, rooti);
        int[] newPostR = Arrays.copyOfRange(postorder, rooti, n - 1);
        int[] newPostL = Arrays.copyOfRange(postorder, 0, rooti);

        root.right = buildTree(newInR, newPostR);
        root.left = buildTree(newInL, newPostL);

        return root;
    }
}

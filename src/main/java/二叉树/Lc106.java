package 二叉树;

import java.util.Arrays;

/**
 * 中序后序生成二叉树
 */

public class Lc106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int li, int ri, int lp, int rp) {
        int n = ri - li + 1;

        if (li < 0 || ri < 0 || lp > inorder.length || rp > inorder.length || li > ri || lp > rp)
            return null;

        if (n == 1)
            return new TreeNode(inorder[ri]);

        int tail = postorder[rp];
        TreeNode root = new TreeNode(tail);

        int rooti = 0;
        for (int i = li; i <= ri; i++) {
            if (inorder[i] == tail) {
                rooti = i;
                break;
            }
        }

        root.right = buildTree(inorder, postorder, rooti + 1, ri, rp - (ri - rooti),rp - 1);
        root.left = buildTree(inorder, postorder, li, rooti - 1, rp - ri + li, rp - (ri - rooti) - 1);

        return root;
    }

    public static void main(String[] args) {
        int[] in = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};
        Lc106 lc106 = new Lc106();
        lc106.buildTree(in, post);
    }
}

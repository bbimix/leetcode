package 二叉树;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 中序后序生成二叉树
 */

public class Lc106 {

    int postIndex;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        /**
         * 由于每一个值都不一样 可以生成一个 值对应下标的map
         */
        map = new HashMap<>();
        postIndex = inorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int l, int r) {

        if (l > r)
            return null;



        int rootv = postorder[postIndex--];
        TreeNode root = new TreeNode(rootv);
        int rooti = map.get(rootv);

        root.right = buildTree(inorder, postorder, rooti + 1, r);
        root.left = buildTree(inorder, postorder, l, rooti - 1);

        return root;
    }

    public static void main(String[] args) {
        int[] in = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};
        Lc106 lc106 = new Lc106();
        lc106.buildTree(in, post);
    }
}

package 二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 自己想的办法超级慢
 * 但是通过了
 * 思路是保存中序位置map 得到根节点index 划分array
 * 递归构建树
 */
public class Lc105 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> inmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, inmap);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, HashMap<Integer, Integer> inmap) {

        if (preorder.length == 0)
            return null;

        if (preorder.length == 1)
            return new TreeNode(preorder[0]);

        int index = inmap.get(preorder[0]);

        int[] leftTreeInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightTreeInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        HashMap<Integer, Integer> leftnewinmap = new HashMap<>();
        for (int i = 0; i < leftTreeInorder.length; i++) {
            leftnewinmap.put(leftTreeInorder[i], i);
        }
        HashMap<Integer, Integer> rightnewinmap = new HashMap<>();
        for (int i = 0; i < rightTreeInorder.length; i++) {
            rightnewinmap.put(rightTreeInorder[i], i);
        }

        int[] leftTreePreorder = Arrays.copyOfRange(preorder, 1, leftTreeInorder.length + 1);
        int[] rightTreePreorder = Arrays.copyOfRange(preorder, leftTreeInorder.length + 1, rightTreeInorder.length + leftTreeInorder.length + 1);

        TreeNode curRoot = new TreeNode(preorder[0]);
        curRoot.left = buildTree(leftTreePreorder, leftTreeInorder, leftnewinmap);
        curRoot.right = buildTree(rightTreePreorder, rightTreeInorder, rightnewinmap);

        return curRoot;
    }

    public static void main(String[] args) {
//        int[] preorder = {3,9,20,15,7};
//        int[] inorder  = {9,3,15,20,7};
        int[] preorder = {1,2};
        int[] inorder  = {2,1};
        TreeNode ans = buildTree(preorder, inorder);
        System.out.println(ans);
    }

}

package 二叉树;

/**
 * 二叉树的直径
 * 思路： 每个节点充当根节点的时候，计算左边深度加右边深度 就是对这个节点来说的直径
 * 所以需要三个值 左边最大深度 右边最大深度 以及目前的直径
 * 正好20分钟 A出来了
 *
 * 时间 空间复杂度 都很拉  感觉是因为有重复计算
 */

public class Lc543 {

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        int maxl = 0;
        int maxr = 0;
        int width = 0;
        int chileW = 0;

        if (root == null)
            return 0;

        maxl = getdeep(root.left);
        maxr = getdeep(root.right);
        width = maxl + maxr;
        chileW = Math.max(diameterOfBinaryTree(root.right), diameterOfBinaryTree(root.left));
        return Math.max(width, chileW);
    }


    private int getdeep(TreeNode root) {

        if (root == null)
            return 0;

        return Math.max(getdeep(root.left), getdeep(root.right)) + 1;
    }
}

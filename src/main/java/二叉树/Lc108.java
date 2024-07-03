package 二叉树;

/**
 * 将有序数组转换为二叉搜索树
 *
 * 可以使用分治思想 对数组进行二分构建
 *
 * A过去了
 */


public class Lc108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;

        return build(nums, 0, n - 1);

    }

    private TreeNode build(int[] nums, int left, int right) {


        if (left > right)
            return null;

        if (left == right)
            return new TreeNode(nums[left]);

        int mid = (right - left) / 2 + left;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);

        return root;
    }

}

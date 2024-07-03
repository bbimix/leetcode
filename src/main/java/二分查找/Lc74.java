package 二分查找;

/**
 * 搜索二维矩阵
 * 以为到了某一行需要进行递归式的二分查找，发现不需要
 */

public class Lc74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        for (i = 0; i < m; i++) {
            if (target == matrix[i][n - 1])
                return true;

            if (target < matrix[i][n - 1])
                break;
        }

        if (i == m)
            return false;

        int l = 0, r = n - 1;
        while (l <= r) {

            int mid = (r - l) / 2 + l;
            if (matrix[i][mid] == target) {
                return true;
            } else if (matrix[i][mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}

package 矩阵;

/**
 * 旋转图像
 */

public class Lc48 {

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int l = 0, r = n - 1;
        int u = 0, d = n - 1;

        while (l <= r) {

            for (int i = 0; i < r - l; i++) {

                int temp = matrix[u + i][r];
                matrix[u + i][r] = matrix[u][l + i];

                int temp2 = matrix[d][r - i];
                matrix[d][r - i] = temp;

                temp = matrix[d - i][l];
                matrix[d - i][l] = temp2;

                matrix[u][l + i] = temp;

            }

            l++;
            r--;
            u++;
            d--;

        }

    }

    public static void main(String[] args) {
        Lc48 lc48 = new Lc48();
        int[][] matrx = {
                {2,29,20,26,16,28},
                {12,27,9,25,13,21},
                {32,33,32,2,28,14},
                {13,14,32,27,22,26},
                {33,1,20,7,21,7},
                {4,24,1,6,32,34}};
        lc48.rotate(matrx);
        for (int[] array : matrx) {
            for (int i : array) {
                System.out.println(i);
            }
        }
    }

}

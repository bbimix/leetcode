package 普通数组;

/**
 * H指数 找到数组中有几个大于几的数字 返回几
 *
 * 暴力： 通过
 *
 * 考虑动态规划 不能用动态规划
 */

public class Lc274 {

    public int hIndex(int[] citations) {

        int n = citations.length;
        int[] counter = new int[n + 1];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }

        for (int i = n; i >=0; i--) {
            count += counter[i];
            if (count >= i)
                return i;
        }
        return 0;
    }

}

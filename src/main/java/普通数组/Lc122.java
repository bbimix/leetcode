package 普通数组;

/**
 * 买卖股票的最佳时机II
 */

public class Lc122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int min = prices[0], max = 0;
        boolean ismin = true; // 这一轮是否在确定min

        int res = 0;

        for (int i = 1; i < n; i++) {
            if (ismin) {
                if (prices[i] < min) {
                    min = prices[i];
                } else {
                    ismin = false;
                    max = Math.max(max, prices[i]);
                }
            } else {
                if (prices[i] > max) {
                    max = prices[i];
                } else {
                    res += (max - min);
                    min = prices[i];
                    max = 0;
                    ismin = true;
                }
            }
        }

        if (max == prices[n - 1])
            res += (max - min);

        return res;
    }

    public int maxProfitOfficial(int[] prices) {
        int n = prices.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] - prices[i - 1] > 0)
                res += prices[i] - prices[i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {1,11,9,8,10,0};
        Lc122 lc122 = new Lc122();
        int res = lc122.maxProfit(prices);
        System.out.println(res);
    }
}

package 贪心;

/**
 * 买卖股票的最佳时机
 */

public class Lc121 {
    public static int maxProfit(int[] prices) {

        int res = 0;
        int low = prices[0];
        int length = prices.length;

        for (int i = 1; i < length; i++) {
            low = Math.min(low, prices[i]);
            res = Math.max(res, prices[i] - low);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}

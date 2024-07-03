package 动态规划.买卖股票的最好时机2;

/**
 * @projectName: leetcode
 * @package: 动态规划.买卖股票的最好时机2
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/4 20:52
 */
public class Solution {
    public int maxProfit (int[] prices) {
        int coin = 0;
        for (int i = 0; i < prices.length; i++) {
            int in_price = prices[i];
            while (i + 1 < prices.length && prices[i + 1] > prices[i]) {
                i++;
            }
            coin += (prices[i] - in_price);
        }

        return coin;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {8,9,2,5,4,7,1};
        int res = solution.maxProfit(a);
        System.out.println(res);
    }
}

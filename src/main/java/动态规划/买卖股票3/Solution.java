package 动态规划.买卖股票3;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: 动态规划.买卖股票3
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/6 9:42
 */
public class Solution {

    public int maxProfit (int[] prices) {
        int n=prices.length;
        int buy1=Integer.MIN_VALUE,buy2=Integer.MIN_VALUE;
        int sell1=0,sell2=0;
        for(int curPrice:prices){
            /**
             * buy1  记录 当前买入的最少花费 -cost ；
             * sell1 记录 交易一次的最大收益值 m的ax_profit1 ;
             * buy2  记录 交易一次的收益-当前买入最大值 ；
             * sell2 记录 交易两次的最大收益值 max_profit2 ；
             */
            buy1=Math.max(buy1,(-1)*curPrice);
            sell1=Math.max(sell1,curPrice+buy1);
            buy2=Math.max(buy2,sell1-curPrice);
            sell2=Math.max(sell2,curPrice+buy2);
        }
        return sell2;
// =========================================================
//         buy1:-8    sell1:0     buy2:-8    sell2:0
//         buy1:-8    sell1:1     buy2:-8    sell2:1
//         buy1:-3    sell1:1     buy2:-2    sell2:1
//         buy1:-3    sell1:2     buy2:-2    sell2:3
//         buy1:-1    sell1:2     buy2:1     sell2:3
//         buy1:-1    sell1:2     buy2:1     sell2:4
// =========================================================
    }
}

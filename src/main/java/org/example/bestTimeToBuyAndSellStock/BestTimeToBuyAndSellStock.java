package org.example.bestTimeToBuyAndSellStock;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in
 * the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * <p>
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * <p>
 * Constraints:
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit2(int[] prices) {
        int buy = Integer.MAX_VALUE, sell = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            sell = Math.max(sell, prices[i] - buy);
        }
        return sell;
    }

    public static int maxProfit1(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int profit = 0;

        for (int price : prices) {
            if (price < lsf) {
                lsf = price;
            }
            profit = price - lsf;
            if (op < profit) {
                op = profit;
            }
        }
        return op;
    }


    public static int maxProfit(int[] prices) {
        int posMax = 0;
        int posMin = 0;
        int max = prices[0];
        int min = prices[0];

        for (int i = 0; i < prices.length; i++) {
            int item = prices[i];
            if (item <= min) {
                min = item;
                posMin = i;
            }
            if (item > max) {
                max = item;
                posMax = i;
            }
        }


        if (posMax < posMin) {
            posMin = 0;
            min = prices[0];
            for (int i = 0; i <= posMax; i++) {
                int item = prices[i];
                if (item <= min) {
                    min = item;
                    posMin = i;
                }
            }
        }

        if (posMax > posMin) {
            posMax = 0;
            max = prices[0];
            for (int i = posMin; i < prices.length; i++) {
                int item = prices[i];
                if (item > max) {
                    max = item;
                    posMax = i;
                }
            }
        }

        System.out.println("min= " + min);
        System.out.println("max= " + max);
        System.out.println("posMax= " + posMax);
        System.out.println("posMin= " + posMin);
        return max - min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        int profit = maxProfit2(arr);
        System.out.println("profit=" + profit);
    }

}

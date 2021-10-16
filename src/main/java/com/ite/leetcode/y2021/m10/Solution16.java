package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution16 implements Solution<Integer> {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] maxProfitLeft = new int[n];
        int[] maxProfitRight = new int[n];
        int minLeft = prices[0];
        int maxRight = prices[n - 1];
        int maxLeftProfit = 0;
        int maxRightProfit = 0;
        for (int i = 0; i < n; i++) {
            maxLeftProfit = Math.max(maxLeftProfit, prices[i] - minLeft);
            maxProfitLeft[i] = maxLeftProfit;
            minLeft = Math.min(prices[i], minLeft);

            maxRightProfit = Math.max(maxRightProfit, maxRight - prices[n - 1 - i]);
            maxProfitRight[n - 1 - i] = maxRightProfit;
            maxRight = Math.max(prices[n - 1 - i], maxRight);
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, maxProfitLeft[i] + (i < n - 1 ? maxProfitRight[i + 1] : 0));
        }
        return maxProfit;
    }
}

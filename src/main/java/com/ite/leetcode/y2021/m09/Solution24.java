package com.ite.leetcode.y2021.m09;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution24 implements Solution<Integer> {

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        int tmp;
        for (int i = 3; i <= n; i++) {
            tmp = c;
            c = a + b + c;
            a = b;
            b = tmp;
        }
        return c;
    }
}

package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution14 implements Solution<Integer> {

    public int numSquares(int n) {
        // Lagrange's four-square theorem && Legendre's three-square theorem
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        // is square
        if (isSquare(n)) {
            return 1;
        }
        // check if sum of 2 squares
        for (int i = 1; i * i <= n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        return 3;
    }

    protected boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}

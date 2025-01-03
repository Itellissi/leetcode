package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;

import java.util.Random;

/**
 * @author Issam Tellissi
 */
public class Solution12 implements Solution<Integer> {

    /**
     * Guess game simple implementation
     */
    int pick;

    public int guessNumber(int n) {
        int step = n / 2 + n % 2;
        int number = step;
        int sign;
        while ((sign = guess(number)) != 0) {
            step = step / 2 + step % 2;
            number += sign * step;
        }
        return number;
    }

    public int play(int n, int pick) {
        this.pick = pick < 0 ? new Random().nextInt(n) : pick;
        System.out.printf("\tPicked %s%s%n", (pick < 0) ? "randomly " : "", this.pick);
        return guessNumber(n);
    }

    public int guess(int num) {
        return Integer.compare(pick, num);
    }
}

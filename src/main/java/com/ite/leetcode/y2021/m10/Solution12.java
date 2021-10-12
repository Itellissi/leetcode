package com.ite.leetcode.y2021.m10;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution12 implements Solution<Integer> {

    private static final Logger logger = LogManager.getLogger(Solution12.class);
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
        logger.trace("\tPicked {}{}", (pick < 0) ? "randomly " : "", this.pick);
        return guessNumber(n);
    }

    public int guess(int num) {
        return Integer.compare(pick, num);
    }
}

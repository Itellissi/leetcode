package com.ite.leetcode.y2021.m10;

import java.util.LinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution25 implements Solution<Object> {

    private static final Logger logger = LogManager.getLogger(Solution25.class);

    public void test(String[] methods, int[][] args) {
        MinStack instance = new MinStack();
        for (int i = 0; i < methods.length; i++) {
            String method = methods[i];
            int argument = args[i].length > 0 ? args[i][0] : -1;
            switch (method) {
                case "MinStack":
                    instance = new MinStack();
                    break;
                case "push":
                    logger.info("push " + argument);
                    instance.push(argument);
                    break;
                case "pop":
                    logger.info("pop ");
                    instance.pop();
                    break;
                case "top":
                    logger.info("top : " + instance.top());
                    break;
                case "getMin":
                    logger.info("getMin : " + instance.getMin());
                    break;
            }
        }
    }
}

class MinStack {

    private final LinkedList<int[]> items;

    public MinStack() {
        this.items = new LinkedList<>();
    }

    public void push(int val) {
        if (items.isEmpty()) {
            items.push(new int[]{val, val});
        } else {
            items.push(new int[]{val, Math.min(val, items.peek()[1])});
        }
    }

    public void pop() {
        items.pop();
    }

    public int top() {
        return items.peek()[0];
    }

    public int getMin() {
        return items.peek()[1];
    }
}

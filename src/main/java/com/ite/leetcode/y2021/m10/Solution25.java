package com.ite.leetcode.y2021.m10;

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

    private Object[] last;

    public MinStack() {
    }

    public void push(int val) {
        if (last == null) {
            last = new Object[]{val, val, null};
        } else {
            last = new Object[]{val, Math.min(val, (int) last[1]), last};
        }
    }

    public void pop() {
        last = last != null ? (Object[]) last[2] : null;
    }

    public int top() {
        return (int) last[0];
    }

    public int getMin() {
        return (int) last[1];
    }
}

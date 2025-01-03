package com.ite.leetcode.y2021.m10;


import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution25 implements Solution<Object> {


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
                    System.out.println("push " + argument);
                    instance.push(argument);
                    break;
                case "pop":
                    System.out.println("pop ");
                    instance.pop();
                    break;
                case "top":
                    System.out.println("top : " + instance.top());
                    break;
                case "getMin":
                    System.out.println("getMin : " + instance.getMin());
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

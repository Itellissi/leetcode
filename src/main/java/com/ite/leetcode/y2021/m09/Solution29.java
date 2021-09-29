package com.ite.leetcode.y2021.m09;

import java.util.Arrays;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution29 implements Solution<ListNode[]> {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        ListNode[] result = new ListNode[k];
        curr = head;
        int idx = 0;
        result[idx] = curr;

        int extraCount = size % k;
        int countDown = extraCount > 0 ? size / k : size / k - 1;

        while (curr != null) {
            if (countDown == 0) {
                // split
                if (extraCount > 0) {
                    extraCount--;
                }
                countDown = extraCount > 0 ? size / k : size / k - 1;
                if (curr.next != null) {
                    idx++;
                    result[idx] = curr.next;
                    curr.next = null;
                    curr = result[idx];
                } else {
                    curr = curr.next;
                }
            } else {
                countDown--;
                curr = curr.next;
            }
        }
        return result;
    }

    @Override
    public Object convertParam(Object value, int index) {
        if (index == 0) {
            final String valueStr = (String) value;
            Integer[] items = Arrays.stream(valueStr.substring(1, valueStr.length() - 1)
                  .split(","))
                  .map(String::trim)
                  .map(Integer::valueOf)
                  .toArray(Integer[]::new);
            final ListNode root = items.length > 0 ? new ListNode(items[0]) : null;
            ListNode prev = root;
            for (int i = 1; i < items.length; i++) {
                prev.next = new ListNode(items[i]);
                prev = prev.next;
            }
            return root;
        }
        return value;
    }

    @Override
    public String resultAsString(ListNode[] actualResult) {
        return Arrays.toString(actualResult);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + (next != null ? " -> " + next.toString() : "");
    }
}

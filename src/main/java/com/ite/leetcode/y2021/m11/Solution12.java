package com.ite.leetcode.y2021.m11;

import com.ite.leetcode.Solution;
import com.ite.leetcode.model.ListNode;

/**
 * @author Issam Tellissi
 */
public class Solution12 implements Solution<ListNode> {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.next.val == val) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        return head;
    }
}

package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.model.Node;

/**
 * @author Issam Tellissi
 */
public class Solution31 {

    public Node flatten(Node head) {
        this.doFlatten(head);
        return head;
    }

    public Node doFlatten(final Node head) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            Node next = current.next;
            if (current.child != null) {
                Node lastChild = doFlatten(current.child);
                current.next = current.child;
                current.child.prev = current;
                if (lastChild != null) {
                    lastChild.next = next;
                }
                if (next != null) {
                    next.prev = lastChild;
                } else {
                    next = lastChild;
                }
                current.child = null;
            }
            previous = current;
            current = next;
        }
        return previous;
    }
}

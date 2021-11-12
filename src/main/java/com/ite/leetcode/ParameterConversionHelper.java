package com.ite.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.ite.leetcode.model.ListNode;
import com.ite.leetcode.model.TreeNode;

/**
 * @author Issam Tellissi
 */
public final class ParameterConversionHelper {

    static String identity(String input) {
        return input;
    }

    static int asInt(String input) {
        return Integer.valueOf(input);
    }

    static int[][] asIntMatrix(String str) {
        final String rows = str.substring(2, str.length() - 2);
        return Arrays
              .stream((rows + " ").split("\\],\\["))
              .map(String::trim)
              .map(ParameterConversionHelper::toIntArray)
              .toArray(int[][]::new);
    }

    static char[][] asCharMatrix(String str) {
        final String rows = str.substring(3, str.length() - 3);
        return Arrays
              .stream(rows.split("\"\\],\\[\""))
              .map(ParameterConversionHelper::toCharArray)
              .toArray(char[][]::new);
    }

    static int[] asIntArray(String str) {
        String arr = str.substring(1, str.length() - 1);
        return toIntArray(arr);
    }

    static String[] asStringArray(String str) {
        String arr = str.substring(1, str.length() - 1);
        return toStringArray(arr);
    }

    static String[][] asStringMatrix(String str) {
        final String rows = str.substring(2, str.length() - 2);
        return Arrays
              .stream(rows.split("\\],\\["))
              .map(ParameterConversionHelper::toStringArray)
              .toArray(String[][]::new);
    }

    static TreeNode asTreeNode(String str) {
        TreeNode[] nodes = Arrays.stream(str.substring(1, str.length() - 1).split(","))
              .map(String::trim)
              .map(String::toLowerCase)
              .map(s -> !s.equals("null") && !s.isEmpty() ? new TreeNode(Integer.parseInt(s)) : null)
              .toArray(TreeNode[]::new);
        final LinkedList<TreeNode> parents = new LinkedList<>();
        int currentChildCount = 0;
        TreeNode curr = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i] != null) {
                parents.push(nodes[i]);
            }
            switch (currentChildCount % 2) {
                case 0:
                    curr.left = nodes[i];
                    break;
                case 1:
                    curr.right = nodes[i];
                    curr = parents.removeLast();
                    break;
            }
            currentChildCount++;
        }
        return nodes[0];
    }

    static ListNode asListNode(String str) {
        List<Integer> list = Arrays.stream(str.substring(1, str.length() - 1).split(","))
              .map(String::trim)
              .map(Integer::parseInt)
              .collect(Collectors.toList());
        final ListNode result = list.isEmpty() ? null : new ListNode(list.get(0));
        ListNode curr = result;
        for (int i = 1; i < list.size(); i++) {
            curr.next = new ListNode(list.get(i));
            curr = curr.next;
        }
        return result;
    }

    private static char[] toCharArray(String arr) {
        final String[] charsAsStr = arr.split("\",\"");
        final char[] result = new char[charsAsStr.length];
        for (int i = 0; i < charsAsStr.length; i++) {
            result[i] = charsAsStr[i].charAt(0);
        }
        return result;
    }

    private static int[] toIntArray(String arr) {
        return arr.trim().isEmpty() ?
              new int[0] :
              Arrays.stream(arr.split(",")).mapToInt(Integer::valueOf).toArray();
    }

    private static String[] toStringArray(String arr) {
        return arr.trim().isEmpty() ?
              new String[0] :
              Arrays.stream(arr.split(",")).map(s -> s.substring(1, s.length() - 1)).toArray(String[]::new);
    }
}

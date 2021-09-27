package com.ite.leetcode;

import java.util.Arrays;

/**
 * @author Issam Tellissi
 */
public final class LeetCodeHelper {

    static int[][] toMatrix(String s) {
        String[] rows = s.split("\n");
        int[][] matrix = new int[rows.length][];
        int i = 0;
        int j = 0;
        for (String row : rows) {
            matrix[i] = new int[row.length()];
            j = 0;
            for (char c : row.toCharArray()) {
                matrix[i][j] = Character.getNumericValue(c);
                j++;
            }
            i++;
        }
        return matrix;
    }

    static String[] asStringArray(String str) {
        String arr = str.substring(1, str.length() - 1);
        String[] result = Arrays.stream(arr.split(",")).map(s -> s.substring(1, s.length() - 1)).toArray(String[]::new);
        return result;
    }

    static Class resolveClassName(String date) throws ClassNotFoundException {
        final String day = date.substring(0, 2);
        final String month = date.substring(2, 4);
        final String year = date.substring(4);
        return Class.forName("com.ite.leetcode.y" + year + ".m" + month + ".Solution" + day);
    }
}

package com.ite.leetcode;

import java.util.Arrays;

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
              .stream(rows.split("\\],\\["))
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

    private static char[] toCharArray(String arr) {
        final String[] charsAsStr = arr.split("\",\"");
        final char[] result = new char[charsAsStr.length];
        for (int i = 0; i < charsAsStr.length; i++) {
            result[i] = charsAsStr[i].charAt(0);
        }
        return result;
    }

    private static int[] toIntArray(String arr) {
        return Arrays.stream(arr.split(",")).mapToInt(Integer::valueOf).toArray();
    }

    private static String[] toStringArray(String arr) {
        return Arrays.stream(arr.split(",")).map(s -> s.substring(1, s.length() - 1)).toArray(String[]::new);
    }
}

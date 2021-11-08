package com.ite.leetcode.y2021.m11;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution07 implements Solution<String> {

    public String multiply(String num1, String num2) {
        int[] digits1 = convertToDigits(num1);
        int[] digits2 = convertToDigits(num2);
        int[] result = new int[num1.length() + num2.length()];
        int curr = result.length - 1;
        for (int i = digits2.length - 1; i >= 0; i--) {
            for (int j = digits1.length - 1; j >= 0; j--) {
                result[curr] += digits1[j] * digits2[i];
                result[curr - 1] += result[curr] / 10;
                result[curr] %= 10;
                curr--;
            }
            curr += digits1.length - 1;
        }
        return convertToString(result);
    }

    private String convertToString(int[] result) {
        final StringBuilder resultStr = new StringBuilder();
        boolean hasLeadingZero = result[0] == 0;
        for (int digit : result) {
            if (hasLeadingZero && digit == 0) {
                continue;
            } else {
                hasLeadingZero = false;
                resultStr.append(digit);
            }
        }
        return resultStr.length() == 0 ? "0" : resultStr.toString();
    }

    private int[] convertToDigits(String numberStr) {
        int[] number = new int[numberStr.length()];
        int i = 0;
        for (char d : numberStr.toCharArray()) {
            int digit = d - '0';
            number[i++] = digit;
        }
        return number;
    }
}

package com.ite.leetcode;

/**
 * @author Issam Tellissi
 */
public interface Solution<T> {

    default Object convertParam(Object value, int index) {
        return value;
    }

    /**
     * Converts actual result to a printable String value
     *
     * @param actualResult actual result returned by the solution
     * @return a {@link String} representation of the actual result
     */
    default String resultAsString(T actualResult) {
        return String.valueOf(actualResult);
    }
}

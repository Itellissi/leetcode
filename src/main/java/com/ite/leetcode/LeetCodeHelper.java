package com.ite.leetcode;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Issam Tellissi
 */
public final class LeetCodeHelper {

    static Method getMethod(Class<?> type, String methodName) {
        return Arrays.stream(type.getDeclaredMethods())
              .filter(m -> m.getName().equals(methodName))
              .findFirst()
              .orElseThrow(RuntimeException::new);
    }

    static Class resolveClassName(String date) throws ClassNotFoundException {
        final String day = date.substring(0, 2);
        final String month = date.substring(2, 4);
        final String year = date.substring(4);
        return Class.forName("com.ite.leetcode.y" + year + ".m" + month + ".Solution" + day);
    }

    static InputStream resolveInputFile(String date) {
        final String day = date.substring(0, 2);
        final String month = date.substring(2, 4);
        final String year = date.substring(4);
        final String path = year + "/" + month + "/" + day + ".input";
        return LeetCodeHelper.class.getClassLoader().getResourceAsStream(path);
    }
}

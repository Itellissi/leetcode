package com.ite.leetcode;

import static com.ite.leetcode.LeetCodeHelper.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author Issam Tellissi
 */
public class LeetCodeEvaluator {

    public static void main(String[] args) throws Exception {
        final String date = "27092021";
        final String methodName = "numUniqueEmails";
        final List<Object[]> params = Arrays.asList(
              new Object[]{asStringArray("[\"test.email+alex@leetcode.com\",\"test.e.mail+bob.cathy@leetcode.com\",\"testemail+david@lee.tcode.com\"]")},
              new Object[]{asStringArray("[\"a@leetcode.com\",\"b@leetcode.com\",\"c@leetcode.com\"]")}
        );

        Class<?> solutionClass = resolveClassName(date);
        Object instance = solutionClass.getConstructor(null).newInstance();
        Method method = Arrays.stream(solutionClass.getDeclaredMethods())
              .filter(m -> m.getName().equals(methodName))
              .findFirst()
              .orElseThrow(RuntimeException::new);
        for (Object[] param : params) {
            System.out.println(method.invoke(instance, param));
        }
    }
}

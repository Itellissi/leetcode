package com.ite.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.ite.leetcode.LeetCodeHelper.*;

/**
 * @author Issam Tellissi
 */
public class LeetCodeEvaluator {
    private static final SimpleDateFormat dtf = new SimpleDateFormat("ddMMyyyy");
    private static final Supplier<String> currentDateSupplier = () -> {
        var res = dtf.format(Instant.now());
        System.out.println("Running dynamically for current date " + res);
        return res;
    };

    public static void main(String[] args) throws Exception {
        var customDate = currentDateSupplier.get();
        var testDates = args.length == 0 ?
                new String[]{customDate}
                : args;
        for (String date : testDates) {
            runTestsForDate(date);
        }
    }

    private static <T> void runTestsForDate(String date) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        System.out.println("Running tests for date " + date);
        final InputStream inputStream = resolveInputFile(date);
        final Class<Solution<T>> solutionClass = resolveClassName(date);

        try (final BufferedReader inputReader = new BufferedReader(new InputStreamReader(inputStream))) {
            final Solution<T> instance = solutionClass.getConstructor(null).newInstance();
            final String methodName = inputReader.readLine().trim();
            final Method solutionMethod = getMethod(solutionClass, methodName);

            String methodsString = inputReader.readLine();
            final List<Method> methods = methodsString != null && !methodsString.isEmpty() ?
                    Arrays.stream(methodsString.split(" "))
                            .map(name -> getMethod(ParameterConversionHelper.class, name))
                            .collect(Collectors.toList()) :
                    Collections.emptyList();
            runScenarios(inputReader, instance, solutionMethod, methods);
        }
    }

    private static <T> void runScenarios(BufferedReader inputReader, Solution<T> instance, Method solutionMethod, List<Method> methods) throws IOException, IllegalAccessException, InvocationTargetException {
        final int parametersCount = methods.size();
        String line;
        int counter = 0;
        Object[] params = null;

        while ((line = inputReader.readLine()) != null) {
            if (counter == 0) {
                System.out.println("\tInput : ");
                params = new Object[parametersCount];
            }
            System.out.println("\t\t" + line);
            params[counter] = instance.convertParam(methods.get(counter).invoke(null, line), counter);
            counter++;
            counter %= parametersCount;
            if (counter == 0) {
                long start = System.nanoTime();
                //noinspection unchecked
                T actualResult = (T) solutionMethod.invoke(instance, params);
                long duration = System.nanoTime() - start;
                System.out.printf("\tResult : %s. Calculated in %sms.%n", instance.resultAsString(actualResult), ((double) duration) / 1_000_000);
            }
        }
    }
}

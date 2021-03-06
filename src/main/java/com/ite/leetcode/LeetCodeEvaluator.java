package com.ite.leetcode;

import static com.ite.leetcode.LeetCodeHelper.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Issam Tellissi
 */
public class LeetCodeEvaluator {

    private static final Logger logger = LogManager.getLogger(LeetCodeEvaluator.class);

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            // run for current date
            String currentDate = new SimpleDateFormat("ddMMyyyy").format(new Date());
            logger.trace("Running dynamically for current date {}", currentDate);
            runTestsForDate(currentDate);
        } else {
            for (String date : args) {
                runTestsForDate(date);
            }
        }
    }

    private static void runTestsForDate(String date) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        logger.warn("Running tests for date {}", date);
        final InputStream inputStream = resolveInputFile(date);
        final Class<Solution> solutionClass = resolveClassName(date);

        try (final BufferedReader inputReader = new BufferedReader(new InputStreamReader(inputStream))) {
            final Solution instance = solutionClass.getConstructor(null).newInstance();
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

    private static void runScenarios(BufferedReader inputReader, Solution instance, Method solutionMethod, List<Method> methods) throws IOException, IllegalAccessException, InvocationTargetException {
        final int parametersCount = methods.size();
        String line;
        int counter = 0;
        Object[] params = null;

        while ((line = inputReader.readLine()) != null) {
            if (counter == 0) {
                logger.debug("\tInput : ");
                params = new Object[parametersCount];
            }
            logger.debug("\t\t{}", line);
            params[counter] = instance.convertParam(methods.get(counter).invoke(null, line), counter);
            counter++;
            counter %= parametersCount;
            if (counter == 0) {
                long start = System.nanoTime();
                Object actualResult = solutionMethod.invoke(instance, params);
                long duration = System.nanoTime() - start;
                logger.info("\tResult : {}. Calculated in {}ms.", instance.resultAsString(actualResult), ((double) duration) / 1_000_000);
            }
        }
    }
}

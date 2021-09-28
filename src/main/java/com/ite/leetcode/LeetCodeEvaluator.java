package com.ite.leetcode;

import static com.ite.leetcode.LeetCodeHelper.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
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
        runTestsForDate("26092021");
        runTestsForDate("27092021");
    }

    private static void runTestsForDate(String date) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        logger.warn("Running tests for date {}", date);
        final InputStream inputStream = resolveInputFile(date);
        final Class<?> solutionClass = resolveClassName(date);

        try (final BufferedReader inputReader = new BufferedReader(new InputStreamReader(inputStream))) {
            final Object instance = solutionClass.getConstructor(null).newInstance();
            final String methodName = inputReader.readLine().trim();
            final Method solutionMethod = getMethod(solutionClass, methodName);

            final List<Method> methods = Arrays.stream(inputReader.readLine().split(" "))
                  .map(name -> getMethod(ParameterConversionHelper.class, name))
                  .collect(Collectors.toList());
            runScenarios(inputReader, instance, solutionMethod, methods);
        }
    }

    private static void runScenarios(BufferedReader inputReader, Object instance, Method solutionMethod, List<Method> methods) throws IOException, IllegalAccessException, InvocationTargetException {
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
            params[counter] = methods.get(counter).invoke(null, line);
            counter++;
            counter %= parametersCount;
            if (counter == 0) {
                logger.info("\tResult : {}", solutionMethod.invoke(instance, params));
            }
        }
    }
}

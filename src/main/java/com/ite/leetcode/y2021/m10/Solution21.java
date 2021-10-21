package com.ite.leetcode.y2021.m10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution21 implements Solution {

    private static final Logger logger = LogManager.getLogger(Solution21.class);

    public void test(String[] methods, int[][] args) {
        RandomizedSet instance = new RandomizedSet();
        for (int i = 0; i < methods.length; i++) {
            String method = methods[i];
            int argument = args[i].length > 0 ? args[i][0] : -1;
            switch (method) {
                case "RandomizedSet":
                    instance = new RandomizedSet();
                    break;
                case "insert":
                    logger.info("insert " + argument + " : " + instance.insert(argument));
                    break;
                case "remove":
                    logger.info("remove " + argument + " : " + instance.remove(argument));
                    break;
                case "getRandom":
                    logger.info("getRandom : " + instance.getRandom());
                    break;
            }
        }
    }
}

class RandomizedSet {

    private final Map<Integer, Integer> indexes = new HashMap<>();
    private final List<Integer> elements = new ArrayList<>();
    private final Random rng = new Random();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        Integer index = indexes.get(val);
        if (index == null) {
            elements.add(val);
            indexes.put(val, elements.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int val) {
        Integer index = indexes.get(val);
        if (index != null) {
            // getLastItem
            int lastItem = elements.get(elements.size() - 1);
            // replace item at index with last
            elements.set(index, lastItem);
            // change it index in index map
            indexes.put(lastItem, index);
            // remove last item from the list as we swapped its place
            elements.remove((int) elements.size() - 1);
            // remove val from indexes
            indexes.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return elements.get(rng.nextInt(elements.size()));
    }
}
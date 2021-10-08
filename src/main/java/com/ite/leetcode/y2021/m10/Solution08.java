package com.ite.leetcode.y2021.m10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution08 implements Solution {

    private static final Logger logger = LogManager.getLogger(Solution08.class);

    public void test(String[] methods, String[][] args) {
        Trie instance = null;
        for (int i = 0; i < methods.length; i++) {
            String method = methods[i];
            String argument = args[i].length > 0 ? args[i][0] : null;
            switch (method) {
                case "Trie":
                    instance = new Trie();
                    break;
                case "insert":
                    logger.info("insert " + argument);
                    instance.insert(argument);
                    break;
                case "search":
                    logger.info("search " + argument + ": " + instance.search(argument));
                    break;
                case "startsWith":
                    logger.info("startsWith " + argument + ": " + instance.startsWith(argument));
                    break;
            }
        }
    }
}

class Trie {

    private final Trie[] children = new Trie[26];
    private boolean isTerminating;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int idx = 0;
        char[] wordChars = word.toCharArray();
        Trie current = this;
        int currentCharIdx;
        Trie prev;
        while (idx < wordChars.length) {
            currentCharIdx = wordChars[idx] - 'a';
            prev = current;
            current = current.children[currentCharIdx];
            if (current == null) {
                current = new Trie();
                prev.children[currentCharIdx] = current;
            }
            idx++;
        }
        current.isTerminating = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie trie = findTrie(word);
        return trie != null && trie.isTerminating;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return findTrie(prefix) != null;
    }

    private Trie findTrie(String word) {
        Trie current = this;
        char[] chars = word.toCharArray();
        for (int i = 0; current != null && i < chars.length; i++) {
            current = current.children[chars[i] - 'a'];
        }
        return current;
    }
}
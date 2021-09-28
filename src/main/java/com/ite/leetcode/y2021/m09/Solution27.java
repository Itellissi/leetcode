package com.ite.leetcode.y2021.m09;

import java.util.HashSet;
import java.util.Set;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution27 implements Solution<Integer> {

    public int numUniqueEmails(String[] emails) {
        Set<String> mails = new HashSet<>();
        for (String m : emails) {
            StringBuilder actualMail = new StringBuilder();
            String[] parts = m.split("@");
            String local = parts[0];
            for (char c : local.toCharArray()) {
                if (c == '+') {
                    break;
                } else if (c != '.') {
                    actualMail.append(c);
                }
            }
            actualMail.append('@').append(parts[1]);
            mails.add(actualMail.toString());
        }
        return mails.size();
    }
}

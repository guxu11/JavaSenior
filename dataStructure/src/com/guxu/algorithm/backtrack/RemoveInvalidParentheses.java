package com.guxu.algorithm.backtrack;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 301 删除无效括号

TODO: 超时
 */
public class RemoveInvalidParentheses {
    private Set<String> res = new HashSet<>();
    private int maxLen;
    private int maxLenOrigin;
    public List<String> removeInvalidParentheses(String s) {
        List<String> ress = new ArrayList<>();
        maxLen = getMaxLen(s);
        maxLenOrigin = maxLen;
        backtrack(s);
        for (String r: res) {
            if (r.length() == maxLen) ress.add(r);
        }
        if (ress.isEmpty()) ress.add("");
        return ress;
    }

    private int getMaxLen(String s) {
        int l = 0, r = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') l++;
            else if (c == ')') r++;
        }
        return s.length() - Math.abs(l - r);
    }

    private void backtrack(String s) {
        if (s.length() <= maxLenOrigin && isValid(s)) {
             res.add(s);
             if (res.size() == 1) maxLen = s.length();
             else {
                 maxLen = maxLen > s.length() ? maxLen : s.length();
             }
             return;
         }
         for (int i = 0; i < s.length(); i++) {
             if (!res.isEmpty() && s.length() < maxLen) return;
             backtrack(s.substring(0, i) + s.substring(i + 1));
         }

    }

    private boolean isValid(String s) {
        if (s.length() == 0) return true;
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push('(');
            else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
    @Test
    public void test() {
        List<String> r = removeInvalidParentheses(")(f");
        System.out.println(r);

    }
}

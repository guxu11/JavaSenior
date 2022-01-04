package com.guxu.algorithm.backtrack;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
leetcode 1087 花括号展开
 */
public class BraceExpansion {
    private List<String> list = new ArrayList<>();
    public String[] expand(String s) {
        StringBuilder sb = new StringBuilder();
        backtrace(s, sb, 0);
        Collections.sort(list);
        return list.toArray(new String[list.size()]);
    }
    private void backtrace(String s, StringBuilder sb, int index) {
        if (index == s.length()) {
            list.add(sb.toString());
            return;
        }
        if (s.charAt(index) == '{') {
            int count = 0;
            for (int i = index + 1; s.charAt(i) != '}'; i++) {
                count++;
            }
            for (int i = index + 1; s.charAt(i) != '}'; i++) {
                char ch = s.charAt(i);
                if (ch != ',') {
                    sb.append(s.charAt(i));
                    backtrace(s, sb, index + count + 2);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        } else {
            sb.append(s.charAt(index));
            backtrace(s, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    @Test
    public void test() {
        expand("abcd");
        System.out.println(list);
    }
}

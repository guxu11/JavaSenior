package com.guxu.algorithm.backtrack;

/*
leetcode 856 括号得分
 */
import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;

public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (char c: s.toCharArray()) {
            if (c == '(') stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                int temp = v > 0 ? w + 2 * v : w + 1;
                stack.push(temp);
            }
        }
        return stack.pop();
    }


    @Test
    public void test() {
        int score = scoreOfParentheses("(()(()))");
        System.out.println(score);
    }
}

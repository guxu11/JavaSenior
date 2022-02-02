package com.guxu.algorithm.stack;

import org.testng.annotations.Test;

import java.util.Stack;

/*
150. 逆波兰表达式求值
 */
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (Character.isDigit(tokens[i].charAt(0)) || (tokens[i].length() > 1 && tokens[i].charAt(0) == '-')) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int latter = stack.pop();
                int former = stack.pop();
                System.out.println("former: " + former + " latter: " + latter);
                stack.push(cal(former, latter, tokens[i]));
            }

        }
        return stack.pop();
    }

    private int cal(int former, int latter, String sign) {
        int res = 0;
        switch (sign) {
            case "+": res = former + latter;
            break;
            case "-": res = former - latter;
            break;
            case "*": res = former * latter;
            break;
            case "/": res = former / latter;
            break;
        }
        return res;

    }

    @Test
    public void test() {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int res = evalRPN(tokens);
        System.out.println(res);
    }
}

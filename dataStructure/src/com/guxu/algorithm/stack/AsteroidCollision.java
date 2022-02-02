package com.guxu.algorithm.stack;

import org.testng.annotations.Test;

import java.util.Stack;

/*
735. 行星碰撞
 */
public class AsteroidCollision {
    private Stack<Integer> stack = new Stack<>();
    public int[] asteroidCollision(int[] asteroids) {
        int i = 0;
        while (i < asteroids.length) {
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else if (asteroids[i] < 0){
                int flag = asteroidCollision(asteroids, i);
                if (flag == 0) {
                    stack.push(asteroids[i]);
                }
            }
            i++;
        }


        int[] res = new int[stack.size()];
        for (int j = res.length - 1; j >= 0 ; j--) {
            res[j] = stack.pop();
        }
        return res;
    }
    private int asteroidCollision (int[] asteroids, int i) {
        if (stack.isEmpty() || stack.peek() < 0) return 0;
        if (stack.peek() + asteroids[i] > 0) return 1;
        if (stack.peek() + asteroids[i] == 0) {
            stack.pop();
            return 2;
        }
        stack.pop();
        return asteroidCollision(asteroids, i);
    }



    @Test
    public void test() {
        int[] ast = {10, 2, -5};
        int [] res = asteroidCollision(ast);
        for (int i: res) System.out.print(i + " ");
        System.out.println();
    }
}

package com.guxu.other;

public class TryCatchFinally {
    public static int test1() {
        int x = 1;
        try {
            return x;
        } finally {
            x = 2;
            return x;
        }
    }

    public static void main(String[] args) {
        System.out.println(test1());
    }
}
